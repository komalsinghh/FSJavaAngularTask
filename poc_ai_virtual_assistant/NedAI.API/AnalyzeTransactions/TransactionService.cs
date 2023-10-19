using NedAI.API.Models;
using Newtonsoft.Json;
using OpenAI_API.Chat;

namespace NedAI.API.AnalyzeTransactions
{
    public class TransactionService : ITransactionService
    {
        private ILogger<TransactionService> _logger;
        private readonly HttpClient _httpClient;
        public TransactionService(ILogger<TransactionService> logger,
                                        IHttpClientFactory httpClientFactory,
                                        AppSettings appSettings)
        {
            _logger = logger;
            _httpClient = httpClientFactory.CreateClient();
            _httpClient.BaseAddress = new Uri($"{appSettings.NedGPTUrl}");
            _httpClient.DefaultRequestHeaders.Add("Accept", "application/json");
        }

        public async Task<List<AnalyzeTransactionsResponse>> AnalyzeTransactionAsync(AnalyzeTransactionsRequest analyzeTransactionsRequest)
        {
            List<AnalyzeTransactionsResponse> analyzeTransactionsResponseList = null;
            try
            {
                // Validate

                if (analyzeTransactionsRequest == null)
                {
                    throw new ArgumentNullException(nameof(analyzeTransactionsRequest));
                }

                // 1. Create System Prompt
                var systemPromptContent = TransactionPrompts.TRANSACTIONS_LIST_PROMPT;

                if(analyzeTransactionsRequest.Categorize)
                {
                    systemPromptContent += $" {TransactionPrompts.CATEGORIZE_TRANSACTIONS_PROMPT}";
                }

                if(analyzeTransactionsRequest.FraudDetection)
                {
                    systemPromptContent += $" {TransactionPrompts.DETECT_FRAUD_TRANSACTIONS_PROMPT}";
                }

                systemPromptContent += $"{TransactionPrompts.FORMAT_JSON_PROMPT}";

                var systemPrompt = new GPTChatMessage(ChatMessageRole.System, systemPromptContent);

                // 2. Create User Prompt

                var transactionData = File.ReadAllText(@"Data\TransactionData.json");
                var userPrompt = new GPTChatMessage(ChatMessageRole.User, transactionData);

                var prompts = new List<GPTChatMessage> { systemPrompt, userPrompt };

                // 3. Send to OpenAPI Chat Completion
                var gptResponse = await _httpClient.PostAsJsonAsync("/api/gpt/Completion", prompts);
                var responseContent = await gptResponse.Content.ReadAsStringAsync();
                // 4. Extract OpenAPI Response Content and return response
                if (gptResponse.IsSuccessStatusCode)
                {
                    // Read the response content as a string
                    
                    var chatResult = JsonConvert.DeserializeObject<ChatResult>(responseContent);
                    var content = chatResult.Choices.First().Message.Content;
                    analyzeTransactionsResponseList = JsonConvert.DeserializeObject<List<AnalyzeTransactionsResponse>>(content);
                }

            }
            catch (Exception ex)
            {
                _logger.LogError(ex.Message, ex);
                throw;
            }
            return analyzeTransactionsResponseList;
        }

        public async Task<List<AccountTransaction>> BulkUpdateTransactionsAsync(List<AccountTransaction> accountTransactions)
        {
            List<AccountTransaction> accountTransactionsList = null;
            try
            {
                var serializedTransactions = JsonConvert.SerializeObject(accountTransactions, Formatting.Indented);
                File.WriteAllText(@"Data\TransactionData.json", serializedTransactions);

                return await GetTransactionsAsync();
            }
            catch(Exception) 
            {
                throw;
            }
        }
        private async Task<List<AccountTransaction>> GetTransactionsAsync()
        {
            try
            {
                string jsonData = File.ReadAllText(@"Data\TransactionData.json");
                var transactions = JsonConvert.DeserializeObject<List<AccountTransaction>>(jsonData);
                return transactions;
            }
            catch (Exception ex)
            {
                _logger.LogError(ex.Message, ex);
                throw;
            }
        }
    }
}

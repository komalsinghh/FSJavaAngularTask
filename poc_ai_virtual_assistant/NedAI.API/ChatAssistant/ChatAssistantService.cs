using NedAI.API.Models;

namespace NedAI.API.ChatAssistant
{
    public class ChatAssistantService : IChatAssistantService
    {
        private ILogger<ChatAssistantService> _logger;
        private readonly HttpClient _httpClient;
        public ChatAssistantService(ILogger<ChatAssistantService> logger,
                                        IHttpClientFactory httpClientFactory,
                                        AppSettings appSettings)
        {
            _logger = logger;
            _httpClient = httpClientFactory.CreateClient();
            _httpClient.BaseAddress = new Uri($"{appSettings.NedGPTUrl}");
            _httpClient.DefaultRequestHeaders.Add("Accept", "application/json");
        }

        public async Task<ConversationMessage> CreateUpdateConversationAsync(Conversation conversation)
        {
            ConversationMessage conversationMessage = null;
            try
            {
                conversationMessage = new ConversationMessage();

            }
            catch (Exception)
            {

                throw;
            }
            return conversationMessage;
        }
    }
}

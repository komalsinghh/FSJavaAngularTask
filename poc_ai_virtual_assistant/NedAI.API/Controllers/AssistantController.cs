using Microsoft.AspNetCore.Mvc;
using NedAI.API.ChatAssistant;

namespace NedAI.API.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class AssistantController : ControllerBase
    {
        private readonly ILogger<AssistantController> _logger;
        private readonly IChatAssistantService _chatAssistantService;

        public AssistantController(ILogger<AssistantController> logger, IChatAssistantService chatAssistantService)
        {
            _logger = logger;
            _chatAssistantService = chatAssistantService;
        }

        //[HttpGet("completion")]
        //public async Task<ActionResult> Completion(string query)
        //{
        //    string jsonString = System.IO.File.ReadAllText(@"Data\prompts.json");
        //    // Deserialize the JSON content into an array of KeyValuePair objects.
        //    var prompts = System.Text.Json.JsonSerializer.Deserialize<Prompt[]>(jsonString);
        //    if (prompts == null || prompts.Length == 0)
        //    {
        //        return StatusCode(500, "Prompts data not found.");
        //    }
        //    var completetionPrompt = prompts.First(p => p.Name == "Completion");
           
        //    List<GPTChatMessage> messages = new List<GPTChatMessage>();
        //    messages.Add(new GPTChatMessage() { Role = "System", Name = "NedBot", Content = completetionPrompt.Value });
        //    messages.Add(new GPTChatMessage() { Role = "Assistant", Name = "NedBot", Content = query });
        //    var client = new RestClient(_baseGPTURL);
        //    var request = new RestRequest("/api/gpt/Completion", Method.Post);
        //    request.AddHeader("Content-Type", "application/json");
        //    request.AddJsonBody(messages.ToArray());

        //    var response = await client.ExecuteAsync<GPTChatResult>(request);

        //    if(response.IsSuccessful)
        //    {
        //        return Ok(response.Data);
        //    }

        //    return Ok();
        //}

        [HttpPost("conversation/{conversationId}")]
        public async Task<ConversationMessage> CreateUpdateConversationAsync(string conversationId, ConversationMessage userMessage)
        {
            var conversation = new Conversation { ConversationId = conversationId, ConversationMessage = userMessage };
            return await _chatAssistantService.CreateUpdateConversationAsync(conversation);
        }


    }
}
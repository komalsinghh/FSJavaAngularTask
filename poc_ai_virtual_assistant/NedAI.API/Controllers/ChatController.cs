using Microsoft.AspNetCore.Mvc;
using NedAI.API.Models;
using OpenAI_API.Chat;
using RestSharp;
using System.Text.Json;

namespace NedAI.API.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class ChatController : ControllerBase
    {
        private readonly ILogger<ChatController> _logger;
        private readonly string _baseGPTURL = "https://ned-gpt.azurewebsites.net";
        //private readonly string _baseGPTURL = "https://localhost:7034";
        public ChatController(ILogger<ChatController> logger)
        {
            _logger = logger;
        }

        [HttpGet("completion")]
        public async Task<ActionResult> Completion(string query)
        {
            string jsonString = System.IO.File.ReadAllText(@"data\prompts.json");

            // Deserialize the JSON content into an array of KeyValuePair objects.
            var prompts = JsonSerializer.Deserialize<Prompt[]>(jsonString);
            if (prompts == null || prompts.Length == 0)
            {
                return StatusCode(500, "Prompts data not found.");
            }
            var completetionPrompt = prompts.First(p => p.Name == "Completion");
           
            List<GPTChatMessage> messages = new List<GPTChatMessage>();
            messages.Add(new GPTChatMessage() { Role = "System", Name = "NedBot", Content = completetionPrompt.Value });
            messages.Add(new GPTChatMessage() { Role = "Assistant", Name = "NedBot", Content = query });
            var client = new RestClient(_baseGPTURL);
            var request = new RestRequest("/api/gpt/Completion", Method.Post);
            request.AddHeader("Content-Type", "application/json");
            request.AddJsonBody(messages.ToArray());

            var response = await client.ExecuteAsync<GPTChatResult>(request);

            if(response.IsSuccessful)
            {
                return Ok(response.Data);
            }

            return Ok();
        }

        [HttpGet("Test")]
        public string Get()
        {
            return "Hello from ChatController";
        }
    }
}
using Newtonsoft.Json;
using OpenAI_API.Chat;
using OpenAI_API;

namespace NedAI.API.Models
{
    public class GPTChatResult
    {
        public string Id { get; set; }

        public IReadOnlyList<ChatChoice> Choices { get; set; }
        public ChatUsage Usage { get; set; }
    }
    
    public class ChatChoice
    {
        public int Index { get; set; }

        public GPTChatMessage Message { get; set; }

        public string FinishReason { get; set; }

        public GPTChatMessage Delta { get; set; }

    }

    public class ChatUsage : Usage
    {
        public int CompletionTokens { get; set; }
    }
}

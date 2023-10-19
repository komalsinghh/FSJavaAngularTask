using Newtonsoft.Json;

namespace NedAI.API.Models
{
    public class GPTChatMessage
    {
        public GPTChatMessage()
        {
            this.Role = "User";
        }

        public GPTChatMessage(string role, string content)
        {
            this.Role = role;
            this.Content = content;
        }

        public string Role { get; set; }

        public string Content { get; set; }

        public string Name { get; set; } = "NedBot";
    }
}

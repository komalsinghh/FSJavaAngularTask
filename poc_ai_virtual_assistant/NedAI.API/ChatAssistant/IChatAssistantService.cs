namespace NedAI.API.ChatAssistant
{
    public interface IChatAssistantService
    {
        Task<ConversationMessage> CreateUpdateConversationAsync(Conversation conversation);
    }
}

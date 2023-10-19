namespace NedAI.API.Models
{
    public class AccountTransaction
    {
        public int TransactionId { get; set; }
        public int AccountNumber { get; set; }
        public DateTime TransactionDate { get; set; }
        public string TransactionType { get; set; }
        public string Description { get; set; }
        public decimal Amount { get; set; }
    }
}

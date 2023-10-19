using NedAI.API.Models;

namespace NedAI.API.AnalyzeTransactions
{
    public class AnalyzeTransactionsResponse : AccountTransaction
    {
        public string Category { get; set; }
        public bool? PossibleFraudulent { get; set; }
    }
}

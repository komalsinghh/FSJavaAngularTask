namespace NedAI.API.AnalyzeTransactions
{
    public class AnalyzeTransactionsRequest
    {
        public bool Categorize { get; set; }
        public bool FraudDetection { get; set; }
        public DateTime FromDate { get; set; }
        public DateTime ToDate { get; set; }

    }
}
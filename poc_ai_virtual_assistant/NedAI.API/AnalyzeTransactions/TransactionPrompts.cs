namespace NedAI.API.AnalyzeTransactions
{
    public static class TransactionPrompts
    {
        public const string TRANSACTIONS_LIST_PROMPT = $"Given the user transactions in json format.";
        public const string CATEGORIZE_TRANSACTIONS_PROMPT = $"Categorize each of the transaction into a spending category, add a new json property called \"category\".";
        public const string DETECT_FRAUD_TRANSACTIONS_PROMPT = $"Find out possible fraud transactions, add a new boolean json property called \"possibleFraudulent\" always. If transaction is not possible fraudulent then make it false, else make it true.";
        public const string FORMAT_JSON_PROMPT = $"Do not include any explanations, only provide an RFC8259 compliant JSON response.";
    }

}

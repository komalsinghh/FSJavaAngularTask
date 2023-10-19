using NedAI.API.Models;

namespace NedAI.API.AnalyzeTransactions
{
    public interface ITransactionService
    {
        public Task<List<AnalyzeTransactionsResponse>> AnalyzeTransactionAsync(AnalyzeTransactionsRequest analyzeTransactionsRequest);
        public Task<List<AccountTransaction>> BulkUpdateTransactionsAsync(List<AccountTransaction> accountTransactionList);
    }
}

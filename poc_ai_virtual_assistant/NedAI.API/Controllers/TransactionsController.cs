using Microsoft.AspNetCore.Mvc;
using NedAI.API.AnalyzeTransactions;
using NedAI.API.Models;

namespace NedAI.API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class TransactionsController : ControllerBase
    {
        private readonly ILogger<TransactionsController> _logger;
        private readonly ITransactionService _transactionService;

        public TransactionsController(ILogger<TransactionsController> logger, ITransactionService transactionService)
        {
            _logger = logger;
            _transactionService = transactionService;
        }

        [HttpPost]
        [Route("analyze")]
        public async Task<List<AnalyzeTransactionsResponse>> AnalyzeTransactions(AnalyzeTransactionsRequest analyzeTransactionsRequest)
        {
            return await _transactionService.AnalyzeTransactionAsync(analyzeTransactionsRequest);
        }

        [HttpPost]
        [Route("update/bulk")]
        public async Task<List<AccountTransaction>> BulkUpdateTransactions(List<AccountTransaction> accountTransactionList)
        {
            return await _transactionService.BulkUpdateTransactionsAsync(accountTransactionList);
        }
    }
}

using NedAI.API.AnalyzeTransactions;
using NedAI.API.ChatAssistant;
using NedAI.API.Models;
using Newtonsoft.Json.Serialization;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();
builder.Services.AddControllers().AddNewtonsoftJson(options =>
{
    // Use the recommended settings to maintain compatibility with System.Text.Json
    options.SerializerSettings.ContractResolver = new CamelCasePropertyNamesContractResolver();
    options.SerializerSettings.ReferenceLoopHandling = Newtonsoft.Json.ReferenceLoopHandling.Ignore;
});
var appConfig = new AppSettings();
builder.Configuration.Bind("AppSettings", appConfig);
builder.Services.AddSingleton(appConfig);
builder.Services.AddHttpClient();
builder.Services.AddTransient<ITransactionService, TransactionService>();
builder.Services.AddTransient<IChatAssistantService, ChatAssistantService>();

var configuration = new ConfigurationBuilder()
     .AddJsonFile($"appsettings.json");

var config = configuration.Build();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();

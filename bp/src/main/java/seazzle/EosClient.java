package seazzle;


import feign.RequestLine;

public interface EosClient
{
    @RequestLine("POST /v1/chain/get_producers")
    ProducerContainer getProducers(ProducerRequest request);

    @RequestLine("POST /v1/chain/get_account")
    Account getAccount(AccountRequest request);
    
    @RequestLine("POST /v1/chain/get_table_rows")
    TableContainer getTable(TableRequest request);
    
}

package seazzle;


import com.fasterxml.jackson.annotation.JsonProperty;

public class TableRequest
{
	
	@JsonProperty (value="key_type")
    public String key_type;
	@JsonProperty(value="limit")
    private String limit;
    @JsonProperty (value="table")
    public String table="voters";
    @JsonProperty(value="index_position")
    public String index_position="primary";
    
    @JsonProperty (value="scope")
    public String scope="eosio";
    @JsonProperty (value="code")
    public String code="eosio";
    @JsonProperty(value = "lower_bound")
    private String lowerBound;
    @JsonProperty(value = "upper_bound")
    private String upperBound;
    private String json;
    public String getLimit(){return limit;}
    public void setLimit(String limit){this.limit = limit;}
    public String getLowerBound(){return lowerBound;}
    public void setLowerBound(String lowerBound){this.lowerBound = lowerBound;}
    public String getJson(){return json;}
    public void setJson(String json){this.json = json;}
    
    
}

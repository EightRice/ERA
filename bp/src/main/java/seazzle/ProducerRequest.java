package seazzle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProducerRequest
{
    private String limit;
    @JsonProperty(value = "lower_bound")
    private String lowerBound;
    private String json;

    public String getLimit()
    {
        return limit;
    }

    public void setLimit(String limit)
    {
        this.limit = limit;
    }

    public String getLowerBound()
    {
        return lowerBound;
    }

    public void setLowerBound(String lowerBound)
    {
        this.lowerBound = lowerBound;
    }

    public String getJson()
    {
        return json;
    }

    public void setJson(String json)
    {
        this.json = json;
    }
}

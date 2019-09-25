package seazzle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Producer
{
    private String owner;
    @JsonProperty(value = "producer_key")
    private String producerKey;
    private String url;
    @JsonProperty(value = "total_votes")
    private String totalVotes;

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public String getProducerKey()
    {
        return producerKey;
    }

    public void setProducerKey(String producerKey)
    {
        this.producerKey = producerKey;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getTotalVotes()
    {
        return totalVotes;
    }

    public void setTotalVotes(String totalVotes)
    {
        this.totalVotes = totalVotes;
    }
}

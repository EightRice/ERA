package seazzle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Voter {
	
	@JsonProperty(value="owner")
	public String owner;
	@JsonProperty(value = "producers")
	public String[] producers;
	@JsonProperty(value = "staked")
	public long staked;
	@JsonProperty(value="last_vote_weight")
	public Double last_vote_weight;
	@JsonProperty(value="proxied_vote_weight")
	public Double proxied_vote_weight;
	@JsonProperty(value="proxy")
	public String proxy;
	
}

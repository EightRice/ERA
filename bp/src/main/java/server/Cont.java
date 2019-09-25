package server;

import java.util.ArrayList;

import seazzle.Producer;

public class Cont {
	public String title;
	public String owner;
	public long balance;
	public long staking;
	public int votingStake;
	public Double voteWeight;
	public Double proxiedWeight;
	public boolean isProxy;
	public Cont proxy;
	public String website;
	public int team;
	public int dapps;
	public int contentVolume;
	public int contentEngagement;
	public int communityBuilding;
	public int followers;
	public String twitter;public String telegram;public String steemit;
	public int jurisdiction;
	public int backlinks;
	public int activism;
	public int philantropics;
	public String [] prodStrings;
	public ArrayList<Producer>producers;
	public ArrayList<Prod>prods;
	public int cpu;public  int ram;public  int stg; int exec;
	public int infra;

	
	public Cont() {
		this.producers=new ArrayList<Producer>();
		this.prods=new ArrayList<Prod>();

	}
}

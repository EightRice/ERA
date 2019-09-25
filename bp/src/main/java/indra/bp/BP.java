package indra.bp;

import java.text.DecimalFormat;
import java.util.Random;

public class BP {
public int rank;
public	String acct;
public	int votes;
public	int voters;
public	Double percent;
public double procent;
public	String location;
public String localong;
public	boolean hybrid;
public	boolean cloud;
public	boolean baremetal;
public	int avgExecTime;
public int ramgb;public int nram;
public int storagegb;public int nstorage;
public int cores;public int ncores;
public int infra;public int ninfra;
public	int team;public int nteam;
public	int dappsTotal;public int ndapps;
public	int devSuccess;
public	int dappsNew;
public	int contentVolume;public int nContVol;
public	int contentEdu;
public	int contentEdi;
public	int contentEng;
public	int communityBuilding; public int nComBuilding;
public	int followers;public int nfollowers;
public	int smplatform;
public	int jurisdiction;
public int geoDensity;public int ngeodens;
public int popularity;
public int backlinks;public int nbacklinks;
public int eospervote;
public int eos;
public String eosstring;
public String twitter;
public String steamit;
public String othername; public String otheracct;
public int GeoDiversity;
public String website;
public String telegram;
public String name;
public String percstring;
DecimalFormat hau=new DecimalFormat("#.##");
	public BP(String acct, String loc, String eos, int votes, int coinpervote,String percent ) {
		this.acct=acct;this.location=loc;this.eosstring=eos; this.votes=votes;this.percstring=percent;
		this.popularity=normalize(this.rank, 200, 1);
		this.eospervote=coinpervote;
		this.percent=Double.parseDouble(percstring)*100;
		this.percstring=hau.format(this.percent);
	}

	public BP(String acct, String location,int eospervote,int votes,Double percent, int eos) {
		this.acct=acct;this.location=location;this.votes=votes;this.eospervote=eospervote;this.percent=percent;
		
		this.eos=eos;this.geoDensity=0;
		
		
		this.popularity=normalize(this.rank, 200, 1);
		
	this.percent=percent;
	}
	@Override
	public String toString() {
		return "BP [acct=" + acct + ", votes=" + votes + ", voters=" + voters + ", percent=" + percent + ", Location="
				+ location + "]\n";
	}
	public int normalize(int value, int oldmax, int oldmin) {
		int max=9;int min=0;
		int result1=((value-oldmin)*9)/(oldmax-oldmin);return result1;
	}
	
}

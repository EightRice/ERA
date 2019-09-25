package indra.bp;

import java.util.ArrayList;
import java.util.HashMap;

import server.Engine;

@SuppressWarnings("rawtypes")
public class Stakeholder{
	String acct;
<<<<<<< HEAD
	public long stake;
	public ArrayList<BP> approved=new ArrayList<BP>();
	public ArrayList<String>aprobati;
	boolean proxied;
	String proxy;
	public double percpervotes;
	public boolean selectat;
	public boolean voted;
	public Stkview vedere;
	public int jurisdiction=0;
	public int geoDiversity=0;
	public int backlinks=0;
	public int dapps=0;
	public int followers=0;
	public int articles=0;
	public int team=0;
	public double percent=0;
	public int popularity=0;
	public int community=0;
	public int infra=0;
	public HashMap<String,Integer> prefs;
	public double jurisdictionw=0;
	public double geoDensityw=0;
	public double backlinksw=0;
	public double dappsw=0;
	public double followersw=0;
	public double articlesw=0;
	public double teamw=0;
	public double percentw=0;
	public double popularityw=0;
	public double communityw=0;
	public double infraw=0;
	public double distanta=0;
	public ArrayList<Feature>features;
	public Stakeholder(String name, ArrayList<String>aprobati, String proxy,long stake) {
		this.features=new ArrayList<Feature>();
		this.prefs=new HashMap<String,Integer>();
		this.aprobati=aprobati;
		this.acct=name;
		this.stake=stake;
		this.proxy=proxy;
		if (proxy==null) {this.proxied=false;}			
		for (int i=0;i<aprobati.size();i++) {
			for (int j=0;j<Engine.producers.size();j++)
			{
				if (aprobati.get(i).equals(Engine.producers.get(j).acct)) {
					this.approved.add(Engine.producers.get(j));
				}
			}
		}
	for (int i=0;i<approved.size();i++) {
	this.jurisdiction=approved.get(i).jurisdiction+this.jurisdiction;
	this.geoDiversity=approved.get(i).GeoDiversity+this.geoDiversity;
	this.articles=approved.get(i).contentVolume+this.articles;
	this.dapps=approved.get(i).dappsTotal+this.dapps;
	this.followers=approved.get(i).followers+this.followers;
	this.team=approved.get(i).team+this.team;
	this.infra=approved.get(i).infra+this.infra;
	this.backlinks=approved.get(i).backlinks+this.backlinks;
	this.popularity=approved.get(i).popularity+this.popularity;
	if (this.aprobati.size()>0) {this.voted=true;}
	}
//	this.jurisdictionw=(10000000*this.jurisdiction)/this.stake;
//	this.geoDensityw=(10000000*this.geoDiversity)/this.stake;
//	this.articlesw=(10000000*this.articles)/this.stake;
//	this.dappsw=(10000000*this.dapps)/this.stake;
//	this.followersw=(10000000*this.followers)/this.stake;
//	this.teamw=(10000000*this.team)/this.stake;
//	this.infraw=(10000000*this.infra)/this.stake;
//	this.backlinksw=(10000000*this.backlinks)/this.stake;
//	this.popularityw=(10000000*this.popularity)/this.stake;
=======
	public int stake;
	public ArrayList<BP> approved=new ArrayList<BP>();
	public ArrayList<String>aprobati;
	boolean proxied;
	String proxy;
	public double percpervotes;
	public boolean selectat;
	public boolean voted;
	public Stkview vedere;
	public int jurisdiction=0;
	public int geoDiversity=0;
	public int backlinks=0;
	public int dapps=0;
	public int followers=0;
	public int articles=0;
	public int team=0;
	public double percent=0;
	public int popularity=0;
	public int community=0;
	public int infra=0;
	public HashMap<String,Integer> prefs;
	public double jurisdictionw=0;
	public double geoDensityw=0;
	public double backlinksw=0;
	public double dappsw=0;
	public double followersw=0;
	public double articlesw=0;
	public double teamw=0;
	public double percentw=0;
	public double popularityw=0;
	public double communityw=0;
	public double infraw=0;
	public double distanta=0;
	public int activism=0;
	public ArrayList<Feature>features;
	public Stakeholder(String name, ArrayList<String>aprobati, String proxy,int stake) {
		this.features=new ArrayList<Feature>();
		this.prefs=new HashMap<String,Integer>();
		this.aprobati=aprobati;
		this.acct=name;
		this.stake=stake;
		this.proxy=proxy;
		if (proxy==null) {this.proxied=false;}			
		for (int i=0;i<aprobati.size();i++) {
			for (int j=0;j<Engine.producers.size();j++)
			{
				if (aprobati.get(i).equals(Engine.producers.get(j).acct)) {
					this.approved.add(Engine.producers.get(j));
				}
			}
		}
	for (int i=0;i<approved.size();i++) {
	this.jurisdiction=approved.get(i).jurisdiction+this.jurisdiction;
	this.geoDiversity=approved.get(i).GeoDiversity+this.geoDiversity;	
	this.articles=approved.get(i).contentVolume+this.articles;
	this.dapps=approved.get(i).dappsTotal+this.dapps;
	this.followers=approved.get(i).followers+this.followers;
	this.team=approved.get(i).team+this.team;
	this.infra=approved.get(i).infra+this.infra;
	this.backlinks=approved.get(i).backlinks+this.backlinks;
	this.popularity=approved.get(i).popularity+this.popularity;
	if (this.aprobati.size()>0) {this.voted=true;}
	}
	this.jurisdictionw=(10000000*this.jurisdiction)/this.stake;
	this.geoDensityw=(10000000*this.geoDiversity)/this.stake;
	this.articlesw=(10000000*this.articles)/this.stake;
	this.dappsw=(10000000*this.dapps)/this.stake;
	this.followersw=(10000000*this.followers)/this.stake;
	this.teamw=(10000000*this.team)/this.stake;
	this.infraw=(10000000*this.infra)/this.stake;
	this.backlinksw=(10000000*this.backlinks)/this.stake;
	this.popularityw=(10000000*this.popularity)/this.stake;
>>>>>>> branch 'master' of https://github.com/gsampathkumar/EOS-Electorate-Research-Model.git
	Feature jurisf=new Feature("juri", jurisdiction);
	Feature geodf=new Feature("geod",geoDiversity);
	Feature contf=new Feature("articles",articles);
	Feature smpf=new Feature("followers",followers);
	Feature teamf=new Feature("team",team);
	Feature infraf=new Feature("infra",infra);
	Feature backf=new Feature("backlinks",backlinks);
	Feature comdf=new Feature("comdev", community);
	Feature appsf=new Feature("dapps", dapps);
	features.add(jurisf);features.add(geodf);features.add(contf);features.add(smpf);features.add(teamf);features.add(infraf);
	features.add(backf);features.add(comdf);features.add(appsf);
	}
	@Override
	public String toString() {
		return "Stakeholder [acct=" + acct + ", stake=" + stake + ", proxy=" + proxy + ", approved="+approved+"]\n";
	}
	public int normalize(int value, int oldmax, int oldmin, String featurename) {
		int max=9;int min=0;
		int result1=((value-oldmin)*9)/(oldmax-oldmin);return result1;
	}
	public Stakeholder compareTo(Stakeholder o) {
		if (this.distanta<o.distanta)
		{return this;}
		return o;
	}
}
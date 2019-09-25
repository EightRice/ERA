package server;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import indra.bp.BP;
import indra.bp.Stakeholder;
import indra.bp.Work;
import indra.bp.Workbp;
import indra.bp.Workbp2;
@WebListener
public class Engine implements ServletContextListener{
public static ArrayList<BP> producers;
public static ArrayList<Stakeholder> stakeholders;
public static ArrayList<BP> proxies;
public static int totalstake;
<<<<<<< HEAD
public static long onepercent;
public static long chiartotal=0;
ArrayList<Integer>infras=new ArrayList();
ArrayList<Integer>teams=new ArrayList();
ArrayList<Integer>juris=new ArrayList();
ArrayList<Integer>apps=new ArrayList();
ArrayList<Integer>smp=new ArrayList();
ArrayList<Integer>conts=new ArrayList();
ArrayList<Integer>comdev=new ArrayList();
ArrayList<Integer>ranks=new ArrayList();
ArrayList<Integer>backlinks=new ArrayList();
ArrayList<Integer>geodivs=new ArrayList();
ArrayList<Integer>pinfras=new ArrayList();
ArrayList<Integer>pteams=new ArrayList();
ArrayList<Integer>pjuris=new ArrayList();
ArrayList<Integer>papps=new ArrayList();
ArrayList<Integer>psmp=new ArrayList();
ArrayList<Integer>pconts=new ArrayList();
ArrayList<Integer>pcomdev=new ArrayList();
ArrayList<Integer>pranks=new ArrayList();
ArrayList<Integer>pbacklinks=new ArrayList();
ArrayList<Integer>pgeodivs=new ArrayList();
ArrayList<Double>winfras=new ArrayList();
ArrayList<Double>wteams=new ArrayList();
ArrayList<Double>wjuris=new ArrayList();
ArrayList<Double>wapps=new ArrayList();
ArrayList<Double>wsmp=new ArrayList();
ArrayList<Double>wconts=new ArrayList();
ArrayList<Double>wcomdev=new ArrayList();
ArrayList<Double>wranks=new ArrayList();
ArrayList<Double>wbacklinks=new ArrayList();
ArrayList<Double>wgeodivs=new ArrayList();
public static HashMap<String,String> harta;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		producers=new ArrayList<BP>();
		stakeholders=new ArrayList<Stakeholder>();
		proxies=new ArrayList();
//		SheetBP sqs=new SheetBP();try{producers=sqs.act();}catch (Exception e) {}
//	    SheetStake sst=new SheetStake();
		Workbp2 workbp2=new Workbp2();
		try {workbp2.act();}catch(FileNotFoundException e2) {}catch(IOException e1) {e1.printStackTrace();}
//		Thread t1=new Thread(new Getres());
//		t1.start();
		Workbp workbp=new Workbp();
		try {workbp.act();} catch (FileNotFoundException e1) {} catch (IOException e1) {e1.printStackTrace();}
	    Work work=new Work();
	    try {work.act();} catch (FileNotFoundException e1) {} catch (IOException e1) {e1.printStackTrace();}
	    ArrayList<String> locsshort=new ArrayList<String>();
	    ArrayList<String> loclong=new ArrayList<String>();
	    ArrayList<Integer>geovalues=new ArrayList<Integer>();
	    for (BP bp:producers) {
	    	for(BP bpi:producers) {
	    		if (bp.location.equals(bpi.location)) {bp.geoDensity++;}
	    	}
	    }
	    for (BP bp:producers) {if(bp.geoDensity>0) {geovalues.add(bp.geoDensity);}}
	    for(BP bp:producers) {
	    bp.ngeodens=bp.normalize(bp.geoDensity, Collections.max(geovalues), Collections.min(geovalues)); 	
	    bp.GeoDiversity=9-bp.ngeodens;
	    }
//	    try{stakeholders=SheetStake.act();}catch(Exception e) {}
	    onepercent=chiartotal/100;
	    for (int i=0;i<stakeholders.size();i++) {
	    	stakeholders.get(i).percent=stakeholders.get(i).stake/onepercent;
	    	stakeholders.get(i).prefs.put("Node Setup",stakeholders.get(i).infra);
	    	stakeholders.get(i).prefs.put("Team Notoriety",stakeholders.get(i).team);
	    	stakeholders.get(i).prefs.put("Developer Activity",stakeholders.get(i).dapps);
	    	stakeholders.get(i).prefs.put("Content Creation",stakeholders.get(i).articles);
	    	stakeholders.get(i).prefs.put("Social Media Presence",stakeholders.get(i).followers);
	    	stakeholders.get(i).prefs.put("Jurisdiction Friendliness",stakeholders.get(i).jurisdiction);
	    	stakeholders.get(i).prefs.put("Popularity", stakeholders.get(i).popularity);
	    	stakeholders.get(i).prefs.put("Community Development",stakeholders.get(i).community);
	    	stakeholders.get(i).prefs.put("Backlinks", stakeholders.get(i).backlinks);
	    }
	    for (Stakeholder stk:stakeholders) {
	    	infras.add(stk.infra);teams.add(stk.team);juris.add(stk.jurisdiction);
	    	apps.add(stk.dapps);conts.add(stk.articles);smp.add(stk.followers);
	    	comdev.add(stk.community);ranks.add(stk.popularity);backlinks.add(stk.backlinks);
	    	geodivs.add(stk.geoDiversity);
	    	}
	    for (Stakeholder stk:stakeholders) {
	    	stk.infra=normalize(stk.infra, Collections.max(infras), Collections.min(infras));
	    	stk.articles=normalize(stk.articles, Collections.max(conts), Collections.min(conts));
	    	stk.jurisdiction=normalize(stk.jurisdiction, Collections.max(juris), Collections.min(juris));
	    	stk.team=normalize(stk.team, Collections.max(teams), Collections.min(teams));
	    	stk.followers=normalize(stk.followers, Collections.max(smp), Collections.min(smp));
	    	stk.dapps=normalize(stk.dapps, Collections.max(apps), Collections.min(apps));
	    	stk.community=normalize(stk.community, Collections.max(comdev), Collections.min(comdev));
	    	stk.popularity=normalize(stk.popularity,Collections.max(ranks),Collections.min(ranks));
	        System.out.println("vechiul baci "+stk.backlinks);
	    	stk.backlinks=normalize(stk.backlinks,Collections.max(backlinks),Collections.min(backlinks));System.out.println("iar acum "+stk.backlinks);
	    	stk.geoDiversity=normalize(stk.geoDiversity, Collections.max(geodivs), Collections.min(geodivs));
	    }normprod();normstk();
	    String[] shortctr= {"JP", "SG", "US", "HK", "UA", "KR",
	    		"VG", "IL", "GB", "CK", "CA", "SE",
	    		"BR", "TH", "AR", "BG", "IN", " ", "FR", "NL", "IS", 
	    		"KE", "IE","PL", "AU", "RU", "DE", "ER", "VN", 
	    		"IO", "ES", "VE", "SI", "BZ", "CR", "AL", 
	    		"TW", "NO", "CH", "AE", "IT", "PR", "LT", 
	    		"NG", "RO","CN"};
	    String[] longctr= {"Japan", "Singapore", "United States", "Honk Kong", "Ukraine", "South Korea",
	    		"British Virgin Islands", "Israel", "Great Britain", "Cook Islands", "Canada", "Sweden",
	    		"Brazil", "Thailand", "Argentina", "Bulgaria", "India", " ", "France", "Netherlands", "Iceland", 
	    		"Kenia", "Ireland ","Poland", "Australia", "Russia", "Germany", "Eritrea", "Vietnam", 
	    		"British Indian Ocean", "Spain", "Venezuela", "Slovenia", "Belize", "Costa Rica", "Albania", 
	    		"Taiwan", "Norway", "Switzerland", "United Arab Emirates", "Italy", "Puerto Rico", "Lithuania", 
	    		"Nigeria", "Romania","China"};
	    harta=new HashMap<String,String>();
	    for (int i=0;i<shortctr.length;i++) {
	    	harta.put(shortctr[i], longctr[i]);
	    }
	    for (BP bp : producers) {
	    if(bp.location!=null&&bp.location.length()>=2) {bp.location=bp.location.substring(0,2);	}
	    	bp.localong=harta.get(bp.location);System.out.println("avem locatia "+bp.location+" si "+harta.get(bp.location));
	    }
	    for (int i=0;i<stakeholders.size();i++) {
	    	chiartotal=chiartotal+stakeholders.get(i).stake;}
	    float one=chiartotal/100;
	    for (int i=0;i<stakeholders.size();i++) {
	    	stakeholders.get(i).percent=stakeholders.get(i).stake/one;
	    	stakeholders.get(i).percpervotes=stakeholders.get(i).percent/stakeholders.get(i).approved.size()/2;
	    }
	}
	void normstk() {
		for (Stakeholder stk:stakeholders) {
	    	winfras.add(stk.infraw);wteams.add(stk.teamw);wjuris.add(stk.jurisdictionw);
	    	wapps.add(stk.dappsw);wconts.add(stk.articlesw);wsmp.add(stk.followersw);
	    	wcomdev.add(stk.communityw);wranks.add(stk.popularityw);wbacklinks.add(stk.backlinksw);
	    	wgeodivs.add((Math.abs(stk.geoDensityw)));
	    	}
	    for (Stakeholder stk:stakeholders) {
	    	stk.infraw=normalize(stk.infraw, Collections.max(winfras), Collections.min(winfras));
	    	stk.articlesw=normalize(stk.articlesw, Collections.max(wconts), Collections.min(wconts));
	    	stk.jurisdictionw=normalize(stk.jurisdictionw, Collections.max(wjuris), Collections.min(wjuris));
	    	stk.teamw=normalize(stk.teamw, Collections.max(wteams), Collections.min(wteams));
	    	stk.followersw=normalize(stk.followersw, Collections.max(wsmp), Collections.min(wsmp));
	    	stk.dappsw=normalize(stk.dappsw, Collections.max(wapps), Collections.min(wapps));
	    	stk.communityw=normalize(stk.communityw, Collections.max(wcomdev), Collections.min(wcomdev));
	    	stk.popularityw=normalize(stk.popularityw,Collections.max(wranks),Collections.min(wranks));
	       System.out.println("vechiul baci "+stk.backlinks);
	    	stk.backlinksw=normalize(stk.backlinksw,Collections.max(wbacklinks),Collections.min(wbacklinks));
	    	System.out.println("iar acum "+stk.backlinks);
	    	stk.geoDensityw=normalize(stk.geoDensityw, Collections.max	(wgeodivs), Collections.min(wgeodivs));
	    }
	}
	void normprod() {
		    for (BP stk:producers) {
		    	pinfras.add(stk.infra);pteams.add(stk.team);pjuris.add(stk.jurisdiction);
		    	apps.add(stk.dappsTotal);pconts.add(stk.contentVolume);psmp.add(stk.followers);
		    	pcomdev.add(stk.communityBuilding);pranks.add(stk.popularity);pbacklinks.add(stk.backlinks);
		    	pgeodivs.add(stk.GeoDiversity);
		    	}
		    for (BP stk:producers) {
		    	stk.infra=normalize(stk.infra, Collections.max(infras), Collections.min(infras));
		    	stk.contentVolume=normalize(stk.contentVolume, Collections.max(pconts), Collections.min(pconts));
		    	stk.jurisdiction=normalize(stk.jurisdiction, Collections.max(pjuris), Collections.min(pjuris));
		    	stk.team=normalize(stk.team, Collections.max(teams), Collections.min(teams));
		    	stk.followers=normalize(stk.followers, Collections.max(psmp), Collections.min(psmp));
//		    	stk.dappsTotal=normalize(stk.dappsTotal, Collections.max(papps), Collections.min(papps));
		    	stk.communityBuilding=normalize(stk.communityBuilding, Collections.max(pcomdev), Collections.min(pcomdev));
		    	stk.popularity=normalize(stk.popularity,Collections.max(pranks),Collections.min(pranks));
		    	stk.backlinks=normalize(stk.backlinks,Collections.max(backlinks),Collections.min(backlinks));System.out.println("iar acum "+stk.backlinks);
		    	stk.GeoDiversity=normalize(stk.GeoDiversity, Collections.max(pgeodivs), Collections.min(pgeodivs));
		    	stk.GeoDiversity=stk.GeoDiversity-5;
		    }
	}
	public int normalize(int value, int oldmax, int oldmin) {
		int max=9;int min=0;
		if (oldmax-oldmin!=0) {
		int result1=((value-oldmin)*9)/(oldmax-oldmin);return result1;
	}return 1;}
	public Double normalize(Double value, Double oldmax, Double oldmin) {
		int max=9;int min=0;
		if (oldmax-oldmin!=0) {
		Double result1=((value-oldmin)*9)/(oldmax-oldmin);return result1;
	}return 0.0;
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
=======
public static int onepercent;
public static int chiartotal=0;
ArrayList<Integer>infras=new ArrayList();
ArrayList<Integer>teams=new ArrayList();
ArrayList<Integer>juris=new ArrayList();
ArrayList<Integer>apps=new ArrayList();
ArrayList<Integer>smp=new ArrayList();
ArrayList<Integer>conts=new ArrayList();
ArrayList<Integer>comdev=new ArrayList();
ArrayList<Integer>ranks=new ArrayList();
ArrayList<Integer>backlinks=new ArrayList();
ArrayList<Integer>geodivs=new ArrayList();
ArrayList<Integer>pinfras=new ArrayList();
ArrayList<Integer>pteams=new ArrayList();
ArrayList<Integer>pjuris=new ArrayList();
ArrayList<Integer>papps=new ArrayList();
ArrayList<Integer>psmp=new ArrayList();
ArrayList<Integer>pconts=new ArrayList();
ArrayList<Integer>pcomdev=new ArrayList();
ArrayList<Integer>pranks=new ArrayList();
ArrayList<Integer>pbacklinks=new ArrayList();
ArrayList<Integer>pgeodivs=new ArrayList();
ArrayList<Double>winfras=new ArrayList();
ArrayList<Double>wteams=new ArrayList();
ArrayList<Double>wjuris=new ArrayList();
ArrayList<Double>wapps=new ArrayList();
ArrayList<Double>wsmp=new ArrayList();
ArrayList<Double>wconts=new ArrayList();
ArrayList<Double>wcomdev=new ArrayList();
ArrayList<Double>wranks=new ArrayList();
ArrayList<Double>wbacklinks=new ArrayList();
ArrayList<Double>wgeodivs=new ArrayList();
public static HashMap<String,String> harta;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		producers=new ArrayList<BP>();
		stakeholders=new ArrayList<Stakeholder>();
		proxies=new ArrayList();
		
//		SheetBP sqs=new SheetBP();try{producers=sqs.act();}catch (Exception e) {}
//	    SheetStake sst=new SheetStake();
		Workbp2 workbp2=new Workbp2();
		try {workbp2.act();}catch(FileNotFoundException e2) {}catch(IOException e1) {e1.printStackTrace();}
		
		Workbp workbp=new Workbp();
		try {workbp.act();} catch (FileNotFoundException e1) {} catch (IOException e1) {e1.printStackTrace();}
	    Work work=new Work();
	    try {work.act();} catch (FileNotFoundException e1) {} catch (IOException e1) {e1.printStackTrace();}
	    ArrayList<String> locsshort=new ArrayList<String>();
	    ArrayList<String> loclong=new ArrayList<String>();
	    ArrayList<Integer>geovalues=new ArrayList<Integer>();
	    for (BP bp:producers) {
	    	for(BP bpi:producers) {
	    		if (bp.location.equals(bpi.location)) {bp.geoDensity++;}
	    	}
	    }
	    for (BP bp:producers) {if(bp.geoDensity>0) {geovalues.add(bp.geoDensity);}}
	    for(BP bp:producers) {
	    bp.ngeodens=bp.normalize(bp.geoDensity, Collections.max(geovalues), Collections.min(geovalues)); 	
	    bp.GeoDiversity=9-bp.ngeodens;
	    }
//	    try{stakeholders=SheetStake.act();}catch(Exception e) {}
	    onepercent=chiartotal/100;
	    for (int i=0;i<stakeholders.size();i++) {
	    	stakeholders.get(i).percent=stakeholders.get(i).stake/onepercent;
	    	stakeholders.get(i).prefs.put("Node Setup",stakeholders.get(i).infra);
	    	stakeholders.get(i).prefs.put("Team Notoriety",stakeholders.get(i).team);
	    	stakeholders.get(i).prefs.put("Developer Activity",stakeholders.get(i).dapps);
	    	stakeholders.get(i).prefs.put("Content Creation",stakeholders.get(i).articles);
	    	stakeholders.get(i).prefs.put("Social Media Presence",stakeholders.get(i).followers);
	    	stakeholders.get(i).prefs.put("Jurisdiction Friendliness",stakeholders.get(i).jurisdiction);
	    	stakeholders.get(i).prefs.put("Popularity", stakeholders.get(i).popularity);
	    	stakeholders.get(i).prefs.put("Community Development",stakeholders.get(i).community);
	    	stakeholders.get(i).prefs.put("Backlinks", stakeholders.get(i).backlinks);
	    }
	    for (Stakeholder stk:stakeholders) {
	    	infras.add(stk.infra);teams.add(stk.team);juris.add(stk.jurisdiction);
	    	apps.add(stk.dapps);conts.add(stk.articles);smp.add(stk.followers);
	    	comdev.add(stk.community);ranks.add(stk.popularity);backlinks.add(stk.backlinks);
	    	geodivs.add(stk.geoDiversity);
	    	}
	    for (Stakeholder stk:stakeholders) {
	    
	    	stk.infra=normalize(stk.infra, Collections.max(infras), Collections.min(infras));
	    	stk.articles=normalize(stk.articles, Collections.max(conts), Collections.min(conts));
	    	stk.jurisdiction=normalize(stk.jurisdiction, Collections.max(juris), Collections.min(juris));
	    	stk.team=normalize(stk.team, Collections.max(teams), Collections.min(teams));
	    	stk.followers=normalize(stk.followers, Collections.max(smp), Collections.min(smp));
	    	stk.dapps=normalize(stk.dapps, Collections.max(apps), Collections.min(apps));
	    	stk.community=normalize(stk.community, Collections.max(comdev), Collections.min(comdev));
	    	stk.popularity=normalize(stk.popularity,Collections.max(ranks),Collections.min(ranks));
	        System.out.println("vechiul baci "+stk.backlinks);
	    	stk.backlinks=normalize(stk.backlinks,Collections.max(backlinks),Collections.min(backlinks));System.out.println("iar acum "+stk.backlinks);
	    	stk.geoDiversity=normalize(stk.geoDiversity, Collections.max(geodivs), Collections.min(geodivs));
	    
	    }normprod();normstk();
	    
	    
	    String[] shortctr= {"JP", "SG", "US", "HK", "UA", "KR",
	    		"VG", "IL", "GB", "CK", "CA", "SE",
	    		"BR", "TH", "AR", "BG", "IN", " ", "FR", "NL", "IS", 
	    		"KE", "IE","PL", "AU", "RU", "DE", "ER", "VN", 
	    		"IO", "ES", "VE", "SI", "BZ", "CR", "AL", 
	    		"TW", "NO", "CH", "AE", "IT", "PR", "LT", 
	    		"NG", "RO","CN"};
	    
	    String[] longctr= {"Japan", "Singapore", "United States", "Honk Kong", "Ukraine", "South Korea",
	    		"British Virgin Islands", "Israel", "Great Britain", "Cook Islands", "Canada", "Sweden",
	    		"Brazil", "Thailand", "Argentina", "Bulgaria", "India", " ", "France", "Netherlands", "Iceland", 
	    		"Kenia", "Ireland ","Poland", "Australia", "Russia", "Germany", "Eritrea", "Vietnam", 
	    		"British Indian Ocean", "Spain", "Venezuela", "Slovenia", "Belize", "Costa Rica", "Albania", 
	    		"Taiwan", "Norway", "Switzerland", "United Arab Emirates", "Italy", "Puerto Rico", "Lithuania", 
	    		"Nigeria", "Romania","China"};
	    
	    harta=new HashMap<String,String>();
	    
	    for (int i=0;i<shortctr.length;i++) {
	    	harta.put(shortctr[i], longctr[i]);
	    }
	    
	    for (BP bp : producers) {
	    if(bp.location!=null&&bp.location.length()>=2) {bp.location=bp.location.substring(0,2);	}
	    	bp.localong=harta.get(bp.location);System.out.println("avem locatia "+bp.location+" si "+harta.get(bp.location));
	    }
	    
	    for (int i=0;i<stakeholders.size();i++) {
	    	chiartotal=chiartotal+stakeholders.get(i).stake;}
	    float one=chiartotal/100;
	    for (int i=0;i<stakeholders.size();i++) {
	    	stakeholders.get(i).percent=stakeholders.get(i).stake/one;
	    	stakeholders.get(i).percpervotes=stakeholders.get(i).percent/stakeholders.get(i).approved.size()/2;
	    }
	}
	void normstk() {
		for (Stakeholder stk:stakeholders) {
	    	winfras.add(stk.infraw);wteams.add(stk.teamw);wjuris.add(stk.jurisdictionw);
	    	wapps.add(stk.dappsw);wconts.add(stk.articlesw);wsmp.add(stk.followersw);
	    	wcomdev.add(stk.communityw);wranks.add(stk.popularityw);wbacklinks.add(stk.backlinksw);
	    	wgeodivs.add((Math.abs(stk.geoDensityw)));
	    	}
	    for (Stakeholder stk:stakeholders) {
	    	stk.infraw=normalize(stk.infraw, Collections.max(winfras), Collections.min(winfras));
	    	stk.articlesw=normalize(stk.articlesw, Collections.max(wconts), Collections.min(wconts));
	    	stk.jurisdictionw=normalize(stk.jurisdictionw, Collections.max(wjuris), Collections.min(wjuris));
	    	stk.teamw=normalize(stk.teamw, Collections.max(wteams), Collections.min(wteams));
	    	stk.followersw=normalize(stk.followersw, Collections.max(wsmp), Collections.min(wsmp));
	    	stk.dappsw=normalize(stk.dappsw, Collections.max(wapps), Collections.min(wapps));
	    	stk.communityw=normalize(stk.communityw, Collections.max(wcomdev), Collections.min(wcomdev));
	    	stk.popularityw=normalize(stk.popularityw,Collections.max(wranks),Collections.min(wranks));
	       System.out.println("vechiul baci "+stk.backlinks);
	    	stk.backlinksw=normalize(stk.backlinksw,Collections.max(wbacklinks),Collections.min(wbacklinks));
	    	System.out.println("iar acum "+stk.backlinks);
	    	stk.geoDensityw=normalize(stk.geoDensityw, Collections.max	(wgeodivs), Collections.min(wgeodivs));
	}
	    }

	void normprod() {
		    for (BP stk:producers) {
		    	pinfras.add(stk.infra);pteams.add(stk.team);pjuris.add(stk.jurisdiction);
		    	apps.add(stk.dappsTotal);pconts.add(stk.contentVolume);psmp.add(stk.followers);
		    	pcomdev.add(stk.communityBuilding);pranks.add(stk.popularity);pbacklinks.add(stk.backlinks);
		    	pgeodivs.add(stk.GeoDiversity);
		    	}
		    for (BP stk:producers) {
		    	stk.infra=normalize(stk.infra, Collections.max(infras), Collections.min(infras));
		    	stk.contentVolume=normalize(stk.contentVolume, Collections.max(pconts), Collections.min(pconts));
		    	stk.jurisdiction=normalize(stk.jurisdiction, Collections.max(pjuris), Collections.min(pjuris));
		    	stk.team=normalize(stk.team, Collections.max(teams), Collections.min(teams));
		    	stk.followers=normalize(stk.followers, Collections.max(psmp), Collections.min(psmp));
//		    	stk.dappsTotal=normalize(stk.dappsTotal, Collections.max(papps), Collections.min(papps));
		    	stk.communityBuilding=normalize(stk.communityBuilding, Collections.max(pcomdev), Collections.min(pcomdev));
		    	stk.popularity=normalize(stk.popularity,Collections.max(pranks),Collections.min(pranks));
		    	stk.backlinks=normalize(stk.backlinks,Collections.max(backlinks),Collections.min(backlinks));System.out.println("iar acum "+stk.backlinks);
		    	stk.GeoDiversity=normalize(stk.GeoDiversity, Collections.max(pgeodivs), Collections.min(pgeodivs));
		    	stk.GeoDiversity=stk.GeoDiversity-5;
		    }
	}
	public int normalize(int value, int oldmax, int oldmin) {
		int max=9;int min=0;
		if (oldmax-oldmin!=0) {
		int result1=((value-oldmin)*9)/(oldmax-oldmin);return result1;
	}return 1;}
	public Double normalize(Double value, Double oldmax, Double oldmin) {
		int max=9;int min=0;
		if (oldmax-oldmin!=0) {
		Double result1=((value-oldmin)*9)/(oldmax-oldmin);return result1;
	}return 0.0;
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
	
>>>>>>> branch 'master' of https://github.com/gsampathkumar/EOS-Electorate-Research-Model.git
}


package indra.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import server.Engine;

public class SmallVotes extends Stakeholder {
	
	HashMap<String,Integer>preferinte;
	
	
	public SmallVotes(String name, ArrayList<String> aprobati, String proxy, int stake) {
		super(name, aprobati, proxy, stake);
		
	preferinte=new HashMap<String, Integer>();
	
	preferinte.put("starteosiobp", 11);
	preferinte.put("big.one", 11);
	preferinte.put("eoshuobipool",15 );
	preferinte.put("eosinfstones", 10);
	preferinte.put("whaleex.com", 18);
	preferinte.put("eoslaomaocom", 21);
	preferinte.put("newdex.bp", 11);
	preferinte.put("bitfinexeos1", 18);
	preferinte.put("zbeosbp11111", 9);
	preferinte.put("eosdotwikibp", 5);
	preferinte.put("atticlabeosb", 16);
	preferinte.put("certikeosorg", 8);
	preferinte.put("eosflytomars", 13);
	preferinte.put("eossv12eossv", 12);
	preferinte.put("eosiomeetone", 17);
	preferinte.put("hoo.com", 9);
	preferinte.put("cochainworld", 10);
	preferinte.put("eossv12eossv", 12);
	preferinte.put("eosbeijingbp", 13);
	preferinte.put("slowmistiobp", 8);
	preferinte.put("eosiosg11111", 12);
	preferinte.put("helloeoscnbp", 10);
	preferinte.put("eoscannonchn", 17);
	preferinte.put("eosasia11111", 12);
	preferinte.put("koreainbexbp", 8);
	preferinte.put("eosauthority", 22);
	preferinte.put("eoslambdacom", 4);
	preferinte.put("eos42freedom", 14);
	preferinte.put("eosswedenorg", 17);
	preferinte.put("eosnewyorkio", 18);
	preferinte.put("eosnationftw", 15);
	preferinte.put("eoscanadacom", 17);
	preferinte.put("eos.fish", 6);
	preferinte.put("eosecologybp", 4);
	preferinte.put("eosliquideos", 16);
	preferinte.put("cypherglasss", 15);
	preferinte.put("argentinaeos", 12);
	preferinte.put("eosrapidprod", 4);
	preferinte.put("jedaaaaaaaaa", 12);
	preferinte.put("dapppub.bp", 3);
	preferinte.put("eosdacserver", 17);
	
	Iterator it = this.preferinte.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<String, Integer> pair = (Map.Entry)it.next();
	        
	        for (BP bp : Engine.producers) {
	        	if (pair.getKey().equals(bp.acct)) {
	        		this.approved.add(bp);
	        		this.aprobati.add(bp.acct);
	        		this.jurisdiction=this.jurisdiction+pair.getValue()*bp.jurisdiction;
	        		this.articles=this.articles+pair.getValue()*bp.contentVolume;
	        		this.backlinks=this.backlinks+pair.getValue()*bp.backlinks;
	        		this.dapps=this.dapps+pair.getValue()*bp.dappsTotal;
	        		this.team=this.team+pair.getValue()*bp.team;
	        		this.followers=this.followers+pair.getValue()*bp.followers;
	        		this.infra=this.infra+pair.getValue()*bp.infra;
	        		this.geoDiversity=this.geoDiversity+pair.getValue()*bp.GeoDiversity;
	        		this.popularity=this.popularity+pair.getValue()*bp.popularity;
	        	}
	        	
	        }
	        
	    }
	    
	    
	    
	
	}

	
}

package server;
import java.util.ArrayList;
import java.util.Iterator;
import indra.bp.Stakeholder;
import seazzle.EosClientProvider;
import seazzle.TableContainer;
import seazzle.TableRequest;
import seazzle.Voter;

public class Getres implements Runnable{
	public static ArrayList<Voter>voters=new ArrayList<Voter>();
	public static ArrayList<String> bounds= new ArrayList<String>();
	static EosClientProvider eosclientprovider=new EosClientProvider();
	@Override
	public void run() {
		while (true) {
			String lower_bound="";
			int rowCount=500;
			while(rowCount==500) {
				System.out.println("new request: lowerBound:"+lower_bound);
			    TableRequest request = new TableRequest();
			    request.setJson(Boolean.TRUE.toString());
			    request.setLimit("500");
			    request.index_position="primary";
			    request.key_type="name";
			    request.setLowerBound(lower_bound);
			    TableContainer x =eosclientprovider.getEosCLient().getTable(request);
			    Iterator<Voter> iter=x.getRows().iterator();
			     rowCount=0;
			    while (iter.hasNext()) {
			    	rowCount++; 
				    Voter voter=iter.next();
				    if(rowCount>1&&voter.producers.length>0) {voters.add(voter);ArrayList<String>produs=new ArrayList<String>();
				    for (int j=0;j<voter.producers.length;j++) {produs.add(voter.producers[j]);}
				    Engine.stakeholders.add(new Stakeholder(voter.owner, produs, voter.proxy, voter.staked));
				    
				    }
				    if (rowCount==500) {lower_bound=voter.owner;bounds.add(lower_bound);}
				    System.out.println(rowCount+" account: " +voter.owner+", staking: "+voter.staked+ ", voting for "+voter.producers.length);   
			    }
			    System.out.println("|||||||||||||||||||||||||| lowerbound= "+lower_bound+" list of lower bounds="+bounds);
			}int dupli=0;
			for (Voter v: voters) {
				for (Voter x:voters) {
					if (v.equals(x)&&voters.indexOf(v)!=voters.indexOf(x)) {dupli++;}
				}
			}
		System.out.println("We have "+voters.size()+" voters and "+dupli+" duplicates");
	try {
		Thread.sleep(21600000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
		
 }
}

package server;

import java.util.ArrayList;
import java.util.Iterator;
import indra.bp.Stakeholder;
import seazzle.EosClientProvider;
import seazzle.TableContainer;
import seazzle.TableRequest;
import seazzle.Voter;
public class GetVoters implements Runnable {
	public static ArrayList<Voter>voters=new ArrayList<Voter>();
	public static ArrayList<String> bounds= new ArrayList<String>();
	static EosClientProvider eosclientprovider=new EosClientProvider();
	public void run() {
			String lower_bound="eos";
			int rowCount=500;
			int callCount=0;
			while(rowCount==500&&callCount<3) {
				callCount++;
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
				    if(rowCount>1&&voter.producers.length>0&&voter.last_vote_weight>0) {voters.add(voter);
				    int votingWeight=(int) Math.round(voter.last_vote_weight);
				    ArrayList<String>aprobati=new ArrayList<String>();
				    for (int i=0;i<voter.producers.length;i++) {aprobati.add(voter.producers[i]);}
				    Engine.stakeholders.add(new Stakeholder(voter.owner, aprobati, voter.proxy, votingWeight));
				    }
				    lower_bound=voter.owner;
//				    System.out.println(rowCount+" account: " +voter.owner+", staking: "+voter.staked+ ", voting for "+voter.producers.length);   
			    }
			    System.out.println("|||||||||||||||||||||||||| lowerbound= "+lower_bound+" list of lower bounds="+bounds);
			}
//			Engine.voters=voters;
			int dupli=0;
			for (Voter v: voters) {
				for (Voter x:voters) {
					if (v.equals(x)&&voters.indexOf(v)!=voters.indexOf(x)) {dupli++;}
				}
			}
		System.out.println("We have "+voters.size()+" voters and "+dupli+" duplicates");
	}
}
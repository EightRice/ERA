package server;

import java.util.Iterator;

import seazzle.EosClientProvider;
import seazzle.Producer;
import seazzle.ProducerContainer;
import seazzle.ProducerRequest;
import seazzle.TableRequest;

public class Workbp3 {
	
	public Workbp3() {
//		EosClientProvider eosclientprovider=new EosClientProvider();
//        TableRequest request = new TableRequest();
//        
//        request.setJson(Boolean.TRUE.toString());
////        request.setLowerBound("0");
//        request.setLimit("200");;;;
//        ProducerContainer x =eosclientprovider.getEosCLient().getTable(request);
//        Iterator<Producer> iter =x.getRows().iterator();
//        while (iter.hasNext()) {
//        Producer prod=iter.next();
//        
//        
//        System.out.println("avem produceru "+prod.getOwner()+" si "+prod.getTotalVotes() +" si "+ prod.getProducerKey());
//        
		EosClientProvider eosclientprovider=new EosClientProvider();
        ProducerRequest request = new ProducerRequest();
        request.setJson(Boolean.TRUE.toString());
//        request.setLowerBound("0");
        request.setLimit("200");;;
        ProducerContainer x =eosclientprovider.getEosCLient().getProducers(request);
        Iterator<Producer> iter =x.getRows().iterator();
        while (iter.hasNext()) {
        Producer prod=iter.next();
        Engine.prods.add(prod);
        
        
//        System.out.println("avem produceru "+prod.getOwner()+" si "+prod.getTotalVotes() +" si "+ prod.getProducerKey());
        
        
        
        
        }
	}
}

package indra.bp;

import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class Topline extends AbsoluteLayout{
	String acct; String votes; String voters; String percent; String location;
	CheckBox chec;
	
	public Topline(String acct, String votes, String voters, String percent, String location){
	
	setHeight("50px");
	
	setWidth("100%");
	
	this.acct=acct;this.votes=votes;this.voters=voters;this.percent=percent;this.location=location;
	chec=new CheckBox();
	
	HorizontalLayout dreapta=new HorizontalLayout();
	HorizontalLayout stanga=new HorizontalLayout();
	HorizontalLayout centru=new HorizontalLayout();
			
	
//	addComponent(chec,"top:17px;left:3px");
	
	Label account=new Label("Account");account.setStyleName("topline");
	stanga.addComponent(account);stanga.setComponentAlignment(account, Alignment.MIDDLE_LEFT);
	Label share=new Label("Share of Votes");share.setStyleName("topline");
	stanga.addComponent(share);stanga.setComponentAlignment(share, Alignment.MIDDLE_CENTER);
	
	Label eosio=new Label("EOS");eosio.setStyleName("topline");
	stanga.addComponent(eosio);stanga.setComponentAlignment(eosio, Alignment.MIDDLE_CENTER);
	stanga.setWidth("100%");
	addComponent(stanga,"top:12px;left:34px");
	
	Label eospevot=new Label("EOS/Vote");eospevot.setStyleName("topline");
	stanga.addComponent(eospevot);stanga.setComponentAlignment(eospevot, Alignment.MIDDLE_CENTER);
	Label voturi=new Label("Total Votes");voturi.setStyleName("topline");
	stanga.addComponent(voturi);stanga.setComponentAlignment(voturi, Alignment.MIDDLE_CENTER);
	
	Label loc=new Label("Location");loc.setStyleName("topline");
	stanga.addComponent(loc);stanga.setComponentAlignment(loc, Alignment.MIDDLE_RIGHT);
	
	}
	AbsoluteLayout getme(){return this;}
	

}

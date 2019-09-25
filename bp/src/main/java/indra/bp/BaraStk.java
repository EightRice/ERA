package indra.bp;

import java.awt.Checkbox;

import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class BaraStk extends AbsoluteLayout{
	String acct; String votes; String voters; String percent; String location;
	CheckBox chec;
	
	public BaraStk(CheckBox check){
	
	setHeight("50px");
	
	setWidth("100%");
	
	this.chec=check;
	
	HorizontalLayout dreapta=new HorizontalLayout();
	HorizontalLayout stanga=new HorizontalLayout();
	HorizontalLayout centru=new HorizontalLayout();
			
	
	addComponent(chec,"top:17px;left:3px");
	
	Label account=new Label("Account");account.setStyleName("topline");
	stanga.addComponent(account);stanga.setComponentAlignment(account, Alignment.MIDDLE_LEFT);
	Label share=new Label("Stake");share.setStyleName("topline");
	stanga.addComponent(share);stanga.setComponentAlignment(share, Alignment.MIDDLE_CENTER);
	
	
	
	stanga.setWidth("100%");
	addComponent(stanga,"top:12px;left:34px");
	
	
	
	}
	AbsoluteLayout getme(){return this;}
	

}

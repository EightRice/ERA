package indra.bp;

import java.util.ArrayList;

import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.data.HasValue.ValueChangeListener;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

public class Stkview extends AbsoluteLayout{
	public double distance;
	public Stakeholder stakeholder;
	CheckBox chec;
	Clustering clust;
	public String name;
	public Stkview(Stakeholder stakeholder, Dreapta pedreapta,ArrayList<Stakeholder>selectati,CheckBox ck,boolean ecluster,double distance){
	setHeight("30px");
	setStyleName("unom");
	setWidth("100%");
	this.stakeholder=stakeholder;
	this.distance=distance;
	this.clust=clust;
	
	chec=new CheckBox();
	if (ecluster==false) {
	chec.addValueChangeListener(new ValueChangeListener<Boolean>() {
		@Override
		public void valueChange(ValueChangeEvent<Boolean> event) {
			if (event.getValue()==true)
			{
			stakeholder.selectat=true;
			if(pedreapta!=null)	{
					System.out.println("selectat dreapta");
					pedreapta.refresh();}else {selectati.add(stakeholder);}
			
			}else {
				stakeholder.selectat=false;
				if(pedreapta!=null)	{pedreapta.refresh();}else {selectati.remove(stakeholder);}
			
			}
		}
	});;
	}
	
	HorizontalLayout dreapta=new HorizontalLayout();
	HorizontalLayout stanga=new HorizontalLayout();
	HorizontalLayout centru=new HorizontalLayout();
	if (ck==null) {
	addComponent(chec,"top:8px;left:3px");}
	
	Button account=new Button(stakeholder.acct);account.setStyleName(ValoTheme.BUTTON_BORDERLESS);
	account.addClickListener(new ClickListener() {
		@Override
		public void buttonClick(ClickEvent event) {
			getUI().getCurrent().addWindow(new Stakewin(stakeholder));
		}
	});
	
	
	account.setHeight("30px");
	addComponent(account,"top:0px;left:28px");
	Label stake=new Label(""+stakeholder.stake);
	
	Label dist=new Label("dist: "+distance);
	stanga.addComponents(stake);stanga.setComponentAlignment(stake, Alignment.MIDDLE_CENTER);
if(ecluster==true) {stanga.addComponent(dist);}
	
	//	Label proxy=new Label(stakeholder.proxy);
	
	stanga.setWidth("100%");
	addComponent(stanga,"top:0px;left:240px");
//	addComponent(dreapta,"top:12px;right:6px");dreapta.setWidth("450px");
	
	
	}
	AbsoluteLayout getme(){return this;}
	

}

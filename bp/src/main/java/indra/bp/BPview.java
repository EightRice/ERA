package indra.bp;

import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.themes.ValoTheme;

public class BPview extends AbsoluteLayout{
	
	String acct; String votes; String voters; String percent; String location;String eos;
	CheckBox chec;
	public BPview(BP bp, int rank){
	setHeight("50px");
	setStyleName("unom");
	setWidth("100%");
	chec=new CheckBox();
	HorizontalLayout dreapta=new HorizontalLayout();
	HorizontalLayout stanga=new HorizontalLayout();
	HorizontalLayout centru=new HorizontalLayout();
//	addComponent(chec,"top:17px;left:3px");
	Button account=new Button("#"+rank+"   "+bp.acct);
	account.setStyleName(ValoTheme.BUTTON_BORDERLESS);
	account.addClickListener(new ClickListener() {
		@Override
		public void buttonClick(ClickEvent event) {
			getUI().getCurrent().addWindow(new Canwin(bp));
		}
	});
	account.setHeight("50px");
	addComponent(account,"top:0px;left:28px");
	Label share=new Label(bp.percstring+"%");System.out.println("avem percentul string: "+bp.percstring);
	stanga.addComponent(share);stanga.setComponentAlignment(share, Alignment.MIDDLE_CENTER);
	Label eosio=new Label(""+bp.eosstring);
	stanga.addComponent(eosio);stanga.setComponentAlignment(eosio, Alignment.MIDDLE_CENTER);
	stanga.setWidth("100%");
	addComponent(stanga,"top:12px;left:240px");
	Label eospevot=new Label(""+bp.eospervote);
	stanga.addComponent(eospevot);stanga.setComponentAlignment(eospevot, Alignment.MIDDLE_CENTER);
	Label voturi=new Label(""+bp.votes);
	stanga.addComponent(voturi);stanga.setComponentAlignment(voturi, Alignment.MIDDLE_CENTER);
	Label loc=new Label(bp.location);
	stanga.addComponent(loc);stanga.setComponentAlignment(loc, Alignment.MIDDLE_RIGHT);
//	addComponent(new Label(percent),"top:12px;right:500px");
//	addComponent(new Label(location),"top:12px;right:20px");
//	addComponent(dreapta,"top:12px;right:6px");dreapta.setWidth("450px");
	}
	AbsoluteLayout getme(){return this;}
	
}

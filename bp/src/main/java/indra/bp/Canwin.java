package indra.bp;

import java.util.ArrayList;
import java.util.Arrays;
import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.BarChartConfig;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import charts.Barili;

public class Canwin extends Window{
	public BP bp;
	public Canwin(BP bp) {
		this.bp=bp;
		AbsoluteLayout chiartot=new AbsoluteLayout();chiartot.setStyleName("toata");
		chiartot.setWidth("100%");chiartot.setHeight("700px");
		VerticalLayout tot=new VerticalLayout();
		Label spatiu=new Label();spatiu.setHeight("29px");
		tot.setStyleName("toata");tot.setWidth("100%");
		setHeight("700px");setWidth("900px");
		Label nume=new Label(bp.acct);tot.setStyleName("toata");
		nume.setStyleName("nosluts");
		tot.addComponent(spatiu);
		setContent(chiartot);
		this.center();
		VerticalLayout sus=new VerticalLayout();
		chiartot.addComponent(sus);sus.setWidth("100%");
		chiartot.addComponent(tot,"top:100px;left:0px");
		HorizontalLayout locsisite=new HorizontalLayout();locsisite.setWidth("70%");
		Label website=new Label();website.setContentMode(ContentMode.HTML);
		String pagina;
		StringBuilder sb=new StringBuilder();
		sb.append("<a href="+bp.website+">"+bp.website+"</a>");
		website.setValue(sb.toString());
		sus.addComponents(nume);
		chiartot.addComponent(locsisite,"top:90px;left:250px");
		sus.setComponentAlignment(nume, Alignment.TOP_CENTER);
		Label loc=new Label("Org location: "+bp.localong);
		Label sharet=new Label("Share: ");
		locsisite.addComponents(loc,website);
		Label rank=new Label("#"+bp.rank);rank.setStyleName("rank");
		chiartot.addComponent(rank,"top:0px;left:30px");
		chiartot.addComponent(sus,"top:0px;left:0px");
		HorizontalLayout hori=new HorizontalLayout();hori.setStyleName("toata");hori.setWidth("100%");
		VerticalLayout one=new VerticalLayout();one.setWidth("150px");one.setStyleName("toata");
		VerticalLayout two=new VerticalLayout();two.setWidth("70px");two.setStyleName("toata");
		VerticalLayout three=new VerticalLayout();three.setWidth("150px");three.setStyleName("toata");
		VerticalLayout four=new VerticalLayout();four.setWidth("70px");four.setStyleName("toata");
		hori.addComponents(one,two,three,four);hori.setWidth("70%");
		Label share=new Label(""+bp.percent+"%");share.setStyleName("metrics");
		Label eost=new Label("EOS: ");Label eos=new Label(""+bp.eosstring);eos.setStyleName("metrics");
		Label votest=new Label("Total Votes: ");Label votes=new Label(""+bp.votes);votes.setStyleName("metrics");
		Label epvt=new Label("EOS/Vote: ");Label epv=new Label(""+bp.eospervote);epv.setStyleName("metrics");
		Label twittert=new Label("Twitter: ");Label twitter=new Label("N/A");twitter.setStyleName("metrics");
		if (bp.twitter!=null&&bp.twitter.length()>3) {twitter.setValue(bp.twitter);}
		Label telegramt=new Label("Telegram: ");Label telegram=new Label("N/A");
		if(bp.telegram!=null&&bp.telegram.length()>3) {telegram.setValue(bp.telegram);}
		telegram.setStyleName("metrics");
		one.addComponent(sharet);one.setComponentAlignment(sharet,Alignment.MIDDLE_RIGHT);;;
		two.addComponent(share);two.setComponentAlignment(share, Alignment.MIDDLE_CENTER);
		three.addComponent(eost);three.setComponentAlignment(eost, Alignment.MIDDLE_RIGHT);
		four.addComponent(eos);four.setComponentAlignment(eos, Alignment.MIDDLE_CENTER);
		one.addComponent(votest);one.setComponentAlignment(votest, Alignment.MIDDLE_RIGHT);
		two.addComponent(votes);two.setComponentAlignment(votes, Alignment.MIDDLE_CENTER);
		three.addComponent(epvt);three.setComponentAlignment(epvt, Alignment.MIDDLE_RIGHT);
		four.addComponent(epv);four.setComponentAlignment(epv, Alignment.MIDDLE_CENTER);
		one.addComponent(twittert);one.setComponentAlignment(twittert, Alignment.MIDDLE_RIGHT);
		two.addComponent(twitter);two.setComponentAlignment(twitter, Alignment.MIDDLE_CENTER);
		three.addComponent(telegramt);three.setComponentAlignment(telegramt, Alignment.MIDDLE_RIGHT);;;
		four.addComponent(telegram);four.setComponentAlignment(telegram,Alignment.MIDDLE_CENTER);
		String [] features= {"infra","team","jurisdiction","geodensity","contvol","dapps",
				"backlinks","community","followers"};;
		Integer[] valoriint= {bp.infra,bp.team,bp.jurisdiction,bp.GeoDiversity,bp.contentVolume,bp.dappsTotal,
				bp.backlinks,bp.communityBuilding,bp.followers};
		ArrayList<Integer>valori= new ArrayList<Integer>(Arrays.asList(valoriint));
		Barili barili=new Barili(valori, "Candidate Features");
		Component tabel=barili.getChart();tabel.setWidth("92%");
		tot.addComponents(hori);
		chiartot.addComponent(tabel,"top:290px;left:25px");
		tot.setComponentAlignment(hori, Alignment.BOTTOM_CENTER);
	}
	
}

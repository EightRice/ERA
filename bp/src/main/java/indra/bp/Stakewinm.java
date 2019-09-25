package indra.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import charts.Gogoasa;

public class Stakewinm extends Window{
	public BP bp;
	
	public Stakewinm(SmallVotes holder) {
		this.bp=bp;
		VerticalLayout tot=new VerticalLayout();
		Label spatiu=new Label();spatiu.setHeight("29px");
		setDraggable(true);
		;setWidth("450px");
		Label nume=new Label(holder.acct);
		nume.setStyleName("nosluts");
		tot.addComponents(spatiu,nume);
		tot.setComponentAlignment(nume, Alignment.TOP_CENTER);
		setContent(tot);
		this.center();
		Label cash=new Label("Voting with "+holder.stake+ " EOS");
		cash.setStyleName("nosluts");
		Label aprobati=new Label();
		aprobati.setContentMode(ContentMode.HTML);	
		aprobati.setWidth("100%");
		StringBuilder texte=new StringBuilder();
		VerticalLayout votingfor=new VerticalLayout();
		votingfor.setStyleName("toata");
		if (true) {
		texte.append("<b>Voting for:</b> ");
		Iterator it = holder.preferinte.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<String, Integer> pair = (Map.Entry)it.next();
	        if (pair.getValue()>9) {
	        texte.append(pair.getKey()+" 0."+pair.getValue()+"%, ");
	        }else {texte.append(pair.getKey()+" 0.0"+pair.getValue()+"%, ");}
	    }
		aprobati.setValue(texte.toString());
		votingfor.addComponent(aprobati);
		VerticalLayout prefs=new VerticalLayout();
		ArrayList<String>categorii=new ArrayList<String>();
		String[] features= {"Node Setup","GeoDiversity","Team","DApps","Content Volume","Jurisdiction","Social Media Presence","Backlinks"};
		categorii.addAll(Arrays.asList(features));
		ArrayList<Integer>scoruri=new ArrayList<Integer>();
		Integer[] valori={holder.infra,(int)holder.geoDiversity/40,holder.team*23,holder.dapps,holder.articles,holder.jurisdiction/29,holder.followers,holder.backlinks};
		scoruri.addAll(Arrays.asList(valori));
		Gogoasa gog=new Gogoasa(categorii, scoruri, "Preferences:");
		ChartJs chart=(ChartJs) gog.getChart();
		prefs.addComponent(chart);
		tot.addComponents(cash,votingfor,prefs);	
		tot.setComponentAlignment(cash, Alignment.MIDDLE_CENTER);
		tot.setComponentAlignment(votingfor, Alignment.MIDDLE_CENTER);
		tot.setComponentAlignment(prefs, Alignment.MIDDLE_CENTER);
		prefs.setComponentAlignment(chart, Alignment.MIDDLE_CENTER);
		}
		else {
			Label hasnt=new Label(holder.acct+" hasn't voted.");hasnt.setStyleName("nosluts");
			setHeight("300px");
			tot.addComponent(hasnt); tot.setComponentAlignment(hasnt, Alignment.MIDDLE_CENTER);
			tot.setHeight("100%");}
	}
}

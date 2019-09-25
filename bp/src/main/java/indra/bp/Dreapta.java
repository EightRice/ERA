package indra.bp;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import charts.Multidonut;
import charts.Placinta;
import charts.Placintaw;
import server.Engine;

public class Dreapta extends VerticalLayout {
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	long total=0;
	String aprobati;
	boolean all;
	public Dreapta() {	
		refresh();
		
	}
	public void refresh() {
		double percent=0;double votingPercent=0;double allocPercent=0;
		long totalstake=0;
		int infra=0;int team=0;int backlinks=0;int juris=0;int geodens=0;int contvol=0;int followers=0;int apps=0;
		int community=0;int popularity=0;
		long votingTotal=0;int votingShare=0;
=======
	int total=0;
	String aprobati;
	boolean all;
	public Dreapta() {	
		refresh();
		
	}
	public void refresh() {
		double percent=0;double votingPercent=0;double allocPercent=0;
		int totalstake=0;
		int infra=0;int team=0;int backlinks=0;int juris=0;int geodens=0;int contvol=0;int followers=0;int apps=0;
		int community=0;int popularity=0;
		int votingTotal=0;int votingShare=0;
>>>>>>> branch 'master' of https://github.com/gsampathkumar/EOS-Electorate-Research-Model.git
		int allocatedTotal=0;int allocatedShare=0; 
		int selectati=0;
		ArrayList<Stakeholder>totialesi=new ArrayList<Stakeholder>();
		ArrayList<Stakeholder>votatialesi=new ArrayList<Stakeholder>();
		total=0;selectati=0;percent=0;
		removeAllComponents();
		double infraw=0;double teamw=0;double backlinksw=0;double jurisw=0;double geodensw=0;double contvolw=0;
		double followersw=0;double communityw=0; double popularityw=0;double appsw=0;
		ArrayList<String> features=new ArrayList<String>();
		String[] feat={"Infrastructure","Team","Backlinks","Jurisdiction","GeoDensity",
		"Content Volume","Followers","Developer Activity","Community Building","Popularity"};
		features.addAll(Arrays.asList(feat));
		ArrayList<Integer> valori=new ArrayList<Integer>();
		StringBuilder texte=new StringBuilder();
		VerticalLayout votingfor=new VerticalLayout(); 
		ArrayList<String>texti=new ArrayList<String>();
		votingfor.setStyleName("toata");
		int totalbp=0;
		for (int i=0;i<Engine.stakeholders.size();i++) {
			totalstake=totalstake+Engine.stakeholders.get(i).stake;
			if (Engine.stakeholders.get(i).selectat==true) {
			for (String aprobat:Engine.stakeholders.get(i).aprobati) {if(!texti.contains(aprobat)) {texti.add(aprobat);}}	
				totialesi.add(Engine.stakeholders.get(i));
				total=total+Engine.stakeholders.get(i).stake;
				percent=percent+Engine.stakeholders.get(i).percent;
				selectati++;
				if(Engine.stakeholders.get(i).approved.size()>0) {	
					votatialesi.add(Engine.stakeholders.get(i));
				votingPercent=votingPercent+Engine.stakeholders.get(i).percent;
				votingTotal=votingTotal+Engine.stakeholders.get(i).stake;
				infra=infra+Engine.stakeholders.get(i).infra;
				team=team+Engine.stakeholders.get(i).team;
				apps=apps+Engine.stakeholders.get(i).dapps;
				backlinks=backlinks+Engine.stakeholders.get(i).backlinks;
				juris=juris+Engine.stakeholders.get(i).jurisdiction;
				geodens=geodens+Math.abs(Engine.stakeholders.get(i).geoDiversity);
				contvol=contvol+Engine.stakeholders.get(i).articles;
				followers=followers+Engine.stakeholders.get(i).followers;
				community=community+Engine.stakeholders.get(i).community;
				popularity=popularity+Engine.stakeholders.get(i).popularity;
				infraw=infraw+Engine.stakeholders.get(i).infraw;
				teamw=teamw+Engine.stakeholders.get(i).teamw;
				appsw=appsw+Engine.stakeholders.get(i).dappsw;
				backlinksw=backlinksw+Engine.stakeholders.get(i).backlinksw;
				jurisw=jurisw+Engine.stakeholders.get(i).jurisdictionw;
				geodensw=geodensw+Math.abs(Engine.stakeholders.get(i).geoDensityw);
				contvolw=contvolw+Engine.stakeholders.get(i).articlesw;
				followersw=followersw+Engine.stakeholders.get(i).followersw;
				communityw=communityw+Engine.stakeholders.get(i).communityw;
				popularityw=popularityw+Math.abs(Engine.stakeholders.get(i).popularityw);
				}
//				for (int j=0;j<Engine.stakeholders.get(i).approved.size();j++) {
//					infra=infra+Engine.stakeholders.get(i).approved.get(j).infra;
//					team=team+Engine.stakeholders.get(i).approved.get(j).team;
//					backlinks=backlinks+Engine.stakeholders.get(i).approved.get(j).backlinks;
//					juris=juris+Engine.stakeholders.get(i).approved.get(j).jurisdiction;
//					geodens=geodens+Engine.stakeholders.get(i).approved.get(j).geoDensity;
//					contvol=contvol+Engine.stakeholders.get(i).approved.get(j).contentVolume;
//					followers=followers+Engine.stakeholders.get(i).approved.get(j).followers;
//					apps=apps+Engine.stakeholders.get(i).approved.get(j).dappsTotal;
//					community=community+Engine.stakeholders.get(i).approved.get(j).communityBuilding;
//					popularity=popularity+Engine.stakeholders.get(i).approved.get(j).popularity;
//				}
			}
		}
		texte.append("<b>Voting for:</b> "+" "+texti.size()+ " - ");
		for (String aprobat:texti) {
			texte.append(aprobat+", ");
		}
		ArrayList<Double> valoriw=new ArrayList<Double>();
		Integer[] val= {infra,team,juris,geodens,contvol,apps,backlinks,community,followers,popularity};
		Double[] valw= {infraw,teamw,jurisw,geodensw,contvolw,appsw,backlinksw,communityw,followersw,popularityw};
		valori.addAll(Arrays.asList(val));valoriw.addAll(Arrays.asList(valw));
		setStyleName("toata");
		Label totalt=new Label("Total Stake: ");totalt.setStyleName("metrisus");
		Label tot=new Label(" "+total);tot.setStyleName("metrisus");
		Label totalsharet=new Label("Total Share: ");totalsharet.setStyleName("metrisus");
		Label vtotalt=new Label("Voting total: ");vtotalt.setStyleName("metrisus");
		Label vtot=new Label(" "+votingTotal);vtot.setStyleName("metrisus");
		Label vsharet=new Label("Voting Share: ");vsharet.setStyleName("metrisus");
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		percent=percent*2;
		votingPercent=votingPercent*2;
		String rezonabil=df.format(percent);
		Label totalshare=new Label(""+rezonabil+"%");totalshare.setStyleName("metrisus");
		String procentvotanti=df.format(votingPercent);
		Label vshare=new Label(procentvotanti+"%");vshare.setStyleName("metrisus");
		HorizontalLayout separare=new HorizontalLayout();separare.setStyleName("toata");
		HorizontalLayout metrisus=new HorizontalLayout();
		VerticalLayout prima=new VerticalLayout();VerticalLayout doua=new VerticalLayout();VerticalLayout treia=new VerticalLayout();
		separare.addComponents(prima,doua);separare.setWidth("90%");
		prima.setStyleName("toata");doua.setStyleName("toata");treia.setStyleName("toata");
		HorizontalLayout metrimij=new HorizontalLayout();
		HorizontalLayout mtrisharet=new HorizontalLayout();
		HorizontalLayout mtrishare=new HorizontalLayout();
		HorizontalLayout allosus=new HorizontalLayout();
		HorizontalLayout allomij=new HorizontalLayout();
		prima.addComponents(metrisus,metrimij);
		metrisus.addComponents(totalt,tot);metrimij.addComponents(totalsharet,totalshare);
		mtrisharet.addComponents(vtotalt,vtot);mtrishare.addComponents(vsharet,vshare);
		doua.addComponents(mtrisharet,mtrishare);
		addComponents(separare);setComponentAlignment(separare, Alignment.TOP_CENTER);
	if(selectati>0&&votatialesi.size()>0) {
		HorizontalLayout tabele=new HorizontalLayout();tabele.setWidth("100%");tabele.setHeight("100%");
		Placinta barili=new Placinta(valori);
		Placintaw bariliw=new Placintaw(valoriw);
		Component tabel=barili.getChart();Component tabelw=bariliw.getChart();
		tabel.setWidth("100%");tabelw.setWidth("100%");
		System.out.println(totalshare.getValue());
		boolean este;
		if (totalshare.getValue().equals("100%")) {este=true;}else {este=false;}
		Multidonut multi=new Multidonut(valori, valoriw,este);
		Component gog=multi.getChart();gog.setWidth("100%");
		tabele.addComponents(gog);tabele.setHeight("100%");
		setHeight("100%");
		Label pentrucine=new Label();pentrucine.setContentMode(ContentMode.HTML);
		VerticalLayout cucine=new VerticalLayout();cucine.setWidth("100%");
		pentrucine.setValue(texte.toString());pentrucine.setWidth("100%");cucine.addComponent(pentrucine);
		cucine.setStyleName("aprobati");
		HorizontalLayout delim=new HorizontalLayout();
		delim.setStyleName("toata");delim.setWidth("100%");delim.setHeight("100%");
		VerticalLayout st=new VerticalLayout();VerticalLayout dr=new VerticalLayout();
		st.setStyleName("toata");dr.setStyleName("toata");dr.setHeight("100%");
		dr.addComponent(cucine);st.setHeight("100%");
		delim.addComponents(tabele,dr);
		setStyleName("toata");
		addComponent(delim);setComponentAlignment(delim, Alignment.BOTTOM_CENTER);
		}
	}
}

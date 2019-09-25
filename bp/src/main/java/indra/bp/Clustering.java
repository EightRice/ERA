package indra.bp;
import java.awt.Checkbox;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.data.HasValue.ValueChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Slider;
import com.vaadin.ui.VerticalLayout;
import server.Engine;
public class Clustering extends VerticalLayout{
	int rank;Label pozitie=new Label();int stake=0;
	public int jurisdiction=0;
	public int geoDiversity=0;
	public int backlinks=0;
	public int dapps=0;
	public int followers=0;
	public int articles=0;
	public int team=0;
	public double percent=0;
	public int popularity=0;
	public int community=0;
	public int infra=0; 
<<<<<<< HEAD
	public long total=0;
	public Double setdist=8.0;
	DecimalFormat df2 = new DecimalFormat("#.###");
	ArrayList<Stakeholder>sortati=new ArrayList<Stakeholder>();
	int[] almeu;
	Label perc=new Label();
	ArrayList<Integer> eu;ArrayList<Integer> el;
	ArrayList<Stkview>stkviews=new ArrayList();
	Stakeholder fic;
	 HashMap<String,Integer>markup;
	 Panel lista;
	 Label totalStake=new Label("Total Stake: "+total);
	 VerticalLayout toti=new VerticalLayout();
	 ArrayList<Stakeholder>sels=new ArrayList<Stakeholder>();
	public Clustering() {
		Notification.show("After changing scores, please use both the Match button and the slider to refresh.",Notification.TYPE_ERROR_MESSAGE);
		for (Stakeholder stk:Engine.stakeholders) {if (stk.approved.size()>0){sortati.add(stk);}}
		setHeight("100%");
		toti.setHeight("100%");toti.setWidth("100%");
		lista=new Panel();lista.setHeight("100%");
		eu=new ArrayList<Integer>();el=new ArrayList<Integer>();
		setStyleName("toata");
		setHeight("100%");
		HorizontalLayout features=new HorizontalLayout();
		markup=new HashMap<String,Integer>();
		int[] noi= new int[10];
		features.addComponents(feature("Node Setup"),feature("Team Notoriety"),feature("Products"),
				feature("Content Creation"),feature("SMM Presence"),
				feature("Jurisdiction"),feature("Popularity"),
				feature("Community"),feature("Marketing Spend"));
		setWidth("100%");
		features.setWidth("100%");features.setHeight("100%");
		addComponent(features);
		setStyleName("casuta");setHeight("100%");
		Button get=new Button("MATCH");
		Slider slider=new Slider();
		slider.setWidth("80%");
		double per=0;
		slider.setMin(2.0);slider.setMax(25.0);
		slider.addValueChangeListener(new ValueChangeListener<Double>() {
			@Override
			public void valueChange(ValueChangeEvent<Double> event) {
				selectati.clear();total=0;
				setdist=event.getValue();System.out.println("distanta normala "+setdist);
				for (Stakeholder stk:sortati) {
					if(stk.distanta<=setdist) {
						selectati.add(stk);
						total=total+stk.stake/stk.aprobati.size();
						totalStake.setValue("Total Stake: "+total);
					}
				}
				refresh();
				toti.removeAllComponents();toti.addComponent(lista(noi));
			}
		});
		HorizontalLayout bara=new HorizontalLayout();bara.setWidth("100%");
		perc.setValue("Percent: ");
		int i=0;
		bara.addComponents(slider,perc,totalStake,pozitie,get);
		addComponent(bara);setComponentAlignment(bara,Alignment.MIDDLE_CENTER);
		addComponent(toti);
		get.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				toti.removeAllComponents();
				selectati.clear();total=0;
				for(Stakeholder stk:sortati){
					if(stk.distanta<=2.0) {
						selectati.add(stk);
						total=total+stk.stake/stk.aprobati.size();
						totalStake.setValue("Total Stake: "+total);
					}
				};
//				BP bp=new BP("indraeos","IN","4","0","0.00%","0.000");
//				bp.acct="indraeos";
//				bp.backlinks=backlinks;bp.team=team;bp.communityBuilding=community;
//				bp.infra=infra;bp.followers=followers;bp.contentVolume=articles;bp.jurisdiction=jurisdiction;
//				bp.popularity=popularity;bp.dappsTotal=dapps;
				noi[0]=jurisdiction;
				noi[1]= geoDiversity;
				noi[2]= backlinks;
				noi[3]= dapps;
				noi[4]= followers;
				noi[5]= articles;
				noi[6]= team;
				noi[7]= popularity;
				noi[8]= community;
				noi[9]= infra; 
				System.out.println("noi suntem "+ noi);
				ArrayList<String>aprobati=new ArrayList<String>();aprobati.add("indraeos");
				fic=new Stakeholder("unu", aprobati,"no", 4);
				lista=lista(noi);
				toti.addComponent(lista(noi));toti.setHeight("100%");
			}
		});
	}
	Panel lista(int[]noi) {
		Panel tot=new Panel();
		VerticalLayout cont=new VerticalLayout();cont.setHeight("100%");;;
		cont.removeAllComponents();
		cont.setStyleName("toata");
		ArrayList<Stakeholder>steici=new ArrayList<Stakeholder>();
		for(int i=0;i<Engine.stakeholders.size();i++) {
			int[] ei=new int[10];
			ei[0]=Engine.stakeholders.get(i).jurisdiction;
			ei[1]= Engine.stakeholders.get(i).geoDiversity;
			ei[2]= Engine.stakeholders.get(i).backlinks;
			ei[3]= Engine.stakeholders.get(i).dapps;
			ei[4]= Engine.stakeholders.get(i).followers;
			ei[5]= Engine.stakeholders.get(i).articles;
			ei[6]= Engine.stakeholders.get(i).team;
			ei[7]= Engine.stakeholders.get(i).popularity;
			ei[8]= Engine.stakeholders.get(i).community;
			ei[9]= Engine.stakeholders.get(i).infra; 
			Engine.stakeholders.get(i).distanta=getDistanceBetween(noi, ei);
		}
		for (Stakeholder stk:selectati) {
		CheckBox ck=new CheckBox();
		Stkview stkview=new Stkview(stk, null,selectati,ck, true,stk.distanta);
		stkviews.add(stkview);
		cont.addComponent(stkview);
		}
		tot.setContent(cont);
		return tot;
	}
	HorizontalLayout feature(String titlu) {
		HorizontalLayout acesta=new HorizontalLayout();
		List<String> data = IntStream.range(0, 10).mapToObj(i -> "" + i).collect(Collectors.toList());
        NativeSelect meniu = new NativeSelect<>(titlu, data);
        meniu.setEmptySelectionAllowed(false);
        meniu.setSelectedItem(data.get(0));
        meniu.addValueChangeListener(new ValueChangeListener() {
		@Override
			public void valueChange(ValueChangeEvent event) {
				int este=Integer.parseInt(event.getValue().toString());
				markup.put(titlu, este);
				if (titlu.equals("Node Setup")){infra=Integer.parseInt(event.getValue().toString());}
				if (titlu.equals("Team Notoriety")){team=Integer.parseInt(event.getValue().toString());}
				if (titlu.equals("Products")){dapps=Integer.parseInt(event.getValue().toString());}
				if (titlu.equals("Content Creation")){articles=Integer.parseInt(event.getValue().toString());}
				if (titlu.equals("SMM Presence")){followers=Integer.parseInt(event.getValue().toString());}
				if (titlu.equals("Jurisdiction")){jurisdiction=Integer.parseInt(event.getValue().toString());}
				if (titlu.equals("Popularity")){popularity=Integer.parseInt(event.getValue().toString());}
				if (titlu.equals("Community Dev")){community=Integer.parseInt(event.getValue().toString());}
				if (titlu.equals("Marketing Spend")){backlinks=Integer.parseInt(event.getValue().toString());}
			}
		});
        Label tit=new Label(titlu);
		acesta.addComponents(meniu);
		return acesta;
	}
	private Double getDistanceBetween(Stakeholder noi, Stakeholder ei) {
		int total=0;
		for (int i=0;i<ei.features.size();i++) {
			for (int j=0;j<noi.features.size();j++) {
				if(ei.features.get(i).name.equals(noi.features.get(j).name)) {
					total+=Math.pow(ei.features.get(i).value-noi.features.get(j).value, 2);
				}
			}
		}
	    String convertedSum = Integer.toString(total);
	    double convertedToDoubleSum = Double.parseDouble(convertedSum);
	    double distance = Math.abs (Math.sqrt (convertedToDoubleSum));
//	    return Float.parseFloat(convertedDistance);   
	    return distance;
	}
	private Double getDistanceBetween(int[] noi, int[] ei) {
		int total=0;
		for (int i=0;i<ei.length;i++) {
					total+=Math.pow(ei[i]-noi[i], 2);}
	    String convertedSum = Integer.toString(total);
	    double convertedToDoubleSum = Double.parseDouble(convertedSum);
	    double distance = Math.abs (Math.sqrt (convertedToDoubleSum));
	    String convertedDistance = Double.toString(distance); System.out.println("distanta e "+distance);
//	    return Float.parseFloat(convertedDistance);   
	    return distance;
	}
	ArrayList<Stakeholder> selectati=new ArrayList<Stakeholder>();
	void refresh(){
		percent=0;
		for (Stakeholder stk:selectati) {
				percent=percent+stk.percpervotes;
		}	
=======
	public int total=0;
	public Double setdist=8.0;
	DecimalFormat df2 = new DecimalFormat("#.###");
	ArrayList<Stakeholder>sortati=new ArrayList<Stakeholder>();
	int[] almeu;
	Label perc=new Label();
	ArrayList<Integer> eu;ArrayList<Integer> el;
	ArrayList<Stkview>stkviews=new ArrayList();
	Stakeholder fic;
	 HashMap<String,Integer>markup;
	 Panel lista;
	 Label totalStake=new Label("Total Stake: "+total);
	 VerticalLayout toti=new VerticalLayout();
	 ArrayList<Stakeholder>sels=new ArrayList<Stakeholder>();
	public Clustering() {
		Notification.show("After changing scores, please use both the Match button and the slider to refresh.",Notification.TYPE_ERROR_MESSAGE);
		for (Stakeholder stk:Engine.stakeholders) {if (stk.approved.size()>0){sortati.add(stk);}}
		setHeight("100%");
		toti.setHeight("100%");toti.setWidth("100%");
		lista=new Panel();lista.setHeight("100%");
		eu=new ArrayList<Integer>();el=new ArrayList<Integer>();
		setStyleName("toata");
		setHeight("100%");
		HorizontalLayout features=new HorizontalLayout();
		markup=new HashMap<String,Integer>();
		int[] noi= new int[10];
		features.addComponents(feature("Node Setup"),feature("Team Notoriety"),feature("Products"),
				feature("Content Creation"),feature("SMM Presence"),
				feature("Jurisdiction"),feature("Popularity"),
				feature("Community"),feature("Marketing Spend"));
		setWidth("100%");
		features.setWidth("100%");features.setHeight("100%");
		addComponent(features);
		setStyleName("casuta");setHeight("100%");
		Button get=new Button("MATCH");
		Slider slider=new Slider();
		slider.setWidth("80%");
		double per=0;
		slider.setMin(2.0);slider.setMax(25.0);
		slider.addValueChangeListener(new ValueChangeListener<Double>() {
			@Override
			public void valueChange(ValueChangeEvent<Double> event) {
				selectati.clear();total=0;
				setdist=event.getValue();System.out.println("distanta normala "+setdist);
				for (Stakeholder stk:sortati) {
					if(stk.distanta<=setdist) {
						selectati.add(stk);
						total=total+stk.stake/stk.aprobati.size();
						totalStake.setValue("Total Stake: "+total);
						
					}
				}
				refresh();
				toti.removeAllComponents();toti.addComponent(lista(noi));
			}
		});
		HorizontalLayout bara=new HorizontalLayout();bara.setWidth("100%");
		perc.setValue("Percent: ");
		int i=0;
		
		bara.addComponents(slider,perc,totalStake,pozitie,get);
		addComponent(bara);setComponentAlignment(bara,Alignment.MIDDLE_CENTER);
		addComponent(toti);
		get.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				toti.removeAllComponents();
				selectati.clear();total=0;
				for(Stakeholder stk:sortati){
					if(stk.distanta<=2.0) {
						selectati.add(stk);
						total=total+stk.stake/stk.aprobati.size();
						totalStake.setValue("Total Stake: "+total);
					}
					
				};
//				BP bp=new BP("indraeos","IN","4","0","0.00%","0.000");
//				bp.acct="indraeos";
//				bp.backlinks=backlinks;bp.team=team;bp.communityBuilding=community;
//				bp.infra=infra;bp.followers=followers;bp.contentVolume=articles;bp.jurisdiction=jurisdiction;
//				bp.popularity=popularity;bp.dappsTotal=dapps;
				noi[0]=jurisdiction;
				noi[1]= geoDiversity;
				noi[2]= backlinks;
				noi[3]= dapps;
				noi[4]= followers;
				noi[5]= articles;
				noi[6]= team;
				noi[7]= popularity;
				noi[8]= community;
				noi[9]= infra; 
				System.out.println("noi suntem "+ noi);
				ArrayList<String>aprobati=new ArrayList<String>();aprobati.add("indraeos");
				fic=new Stakeholder("unu", aprobati,"no", 4);
				lista=lista(noi);
				toti.addComponent(lista(noi));toti.setHeight("100%");
			}
		});
	}
	Panel lista(int[]noi) {
		Panel tot=new Panel();
		VerticalLayout cont=new VerticalLayout();cont.setHeight("100%");;;
		cont.removeAllComponents();
		cont.setStyleName("toata");
		ArrayList<Stakeholder>steici=new ArrayList<Stakeholder>();
		for(int i=0;i<Engine.stakeholders.size();i++) {
			int[] ei=new int[10];
			ei[0]=Engine.stakeholders.get(i).jurisdiction;
			ei[1]= Engine.stakeholders.get(i).geoDiversity;
			ei[2]= Engine.stakeholders.get(i).backlinks;
			ei[3]= Engine.stakeholders.get(i).dapps;
			ei[4]= Engine.stakeholders.get(i).followers;
			ei[5]= Engine.stakeholders.get(i).articles;
			ei[6]= Engine.stakeholders.get(i).team;
			ei[7]= Engine.stakeholders.get(i).popularity;
			ei[8]= Engine.stakeholders.get(i).community;
			ei[9]= Engine.stakeholders.get(i).infra; 
			Engine.stakeholders.get(i).distanta=getDistanceBetween(noi, ei);
		}
		
		
		for (Stakeholder stk:selectati) {
		CheckBox ck=new CheckBox();
		Stkview stkview=new Stkview(stk, null,selectati,ck, true,stk.distanta);
		stkviews.add(stkview);
		cont.addComponent(stkview);
		}
		tot.setContent(cont);
		return tot;
	}
	HorizontalLayout feature(String titlu) {
		HorizontalLayout acesta=new HorizontalLayout();
		List<String> data = IntStream.range(0, 10).mapToObj(i -> "" + i).collect(Collectors.toList());
        NativeSelect meniu = new NativeSelect<>(titlu, data);
        meniu.setEmptySelectionAllowed(false);
        meniu.setSelectedItem(data.get(0));
        meniu.addValueChangeListener(new ValueChangeListener() {
		@Override
			public void valueChange(ValueChangeEvent event) {
				int este=Integer.parseInt(event.getValue().toString());
				markup.put(titlu, este);
				if (titlu.equals("Node Setup")){infra=Integer.parseInt(event.getValue().toString());}
				if (titlu.equals("Team Notoriety")){team=Integer.parseInt(event.getValue().toString());}
				if (titlu.equals("Products")){dapps=Integer.parseInt(event.getValue().toString());}
				if (titlu.equals("Content Creation")){articles=Integer.parseInt(event.getValue().toString());}
				if (titlu.equals("SMM Presence")){followers=Integer.parseInt(event.getValue().toString());}
				if (titlu.equals("Jurisdiction")){jurisdiction=Integer.parseInt(event.getValue().toString());}
				if (titlu.equals("Popularity")){popularity=Integer.parseInt(event.getValue().toString());}
				if (titlu.equals("Community Dev")){community=Integer.parseInt(event.getValue().toString());}
				if (titlu.equals("Marketing Spend")){backlinks=Integer.parseInt(event.getValue().toString());}
			}
		});
        Label tit=new Label(titlu);
		acesta.addComponents(meniu);
		return acesta;
	}
	private Double getDistanceBetween(Stakeholder noi, Stakeholder ei) {
		int total=0;
		for (int i=0;i<ei.features.size();i++) {
			for (int j=0;j<noi.features.size();j++) {
				if(ei.features.get(i).name.equals(noi.features.get(j).name)) {
					total+=Math.pow(ei.features.get(i).value-noi.features.get(j).value, 2);
				}
			}
		}
	    String convertedSum = Integer.toString(total);
	    double convertedToDoubleSum = Double.parseDouble(convertedSum);
	    double distance = Math.abs (Math.sqrt (convertedToDoubleSum));
//	    return Float.parseFloat(convertedDistance);   
	    return distance;
	}
	private Double getDistanceBetween(int[] noi, int[] ei) {
		int total=0;
		for (int i=0;i<ei.length;i++) {
					total+=Math.pow(ei[i]-noi[i], 2);}
	    String convertedSum = Integer.toString(total);
	    double convertedToDoubleSum = Double.parseDouble(convertedSum);
	    double distance = Math.abs (Math.sqrt (convertedToDoubleSum));
	    String convertedDistance = Double.toString(distance); System.out.println("distanta e "+distance);
//	    return Float.parseFloat(convertedDistance);   
	    return distance;
	}
	ArrayList<Stakeholder> selectati=new ArrayList<Stakeholder>();
	void refresh(){
		percent=0;
		for (Stakeholder stk:selectati) {
			
				percent=percent+stk.percpervotes;
		}	
		
>>>>>>> branch 'master' of https://github.com/gsampathkumar/EOS-Electorate-Research-Model.git
		for (BP bp:Engine.producers) {
			if (percent<bp.procent+0.05&&percent>bp.procent-0.05) {
				rank=bp.rank;
				}	
			}
		perc.setValue("Percent: "+df2.format(percent)+"%");
		pozitie.setValue("Rank: "+rank);
		}
}

package charts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.DonutChartConfig;
import com.byteowls.vaadin.chartjs.data.Dataset;
import com.byteowls.vaadin.chartjs.data.PieDataset;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;

@UIScope
@SpringView
public class Multidonut extends AbstractChartView {
	ArrayList<String>locuri;
	ArrayList<Integer>valori1;
	ArrayList<Double>valori2;
	ArrayList<Double>procente;
	String titlu;boolean all;
	String [] features= {"Node Setup","Team Notoriety","Jurisdiction friendliness","Geographic Density","Content Creation","Developer Activity",
			"Backlinks to website","Community Building","Social Media Presence","Popularity"};
    private static final long serialVersionUID = 4894923343920891837L;

    public Multidonut(ArrayList<Integer>valori1,ArrayList<Double>valori2,boolean all) {
    	this.valori1=valori1;int	 total=0;
    	for (int i=0;i<valori1.size();i++) {
    		total=total+valori1.get(i);
    	}
    	this.valori2=valori2;
    	this.all=all;
    }
    
    @Override
    public Component getChart() {
        DonutChartConfig config = new DonutChartConfig();
        config
            .data()
                .labels(features)
                .addDataset(new PieDataset().label("Unweighted"))
                .addDataset(new PieDataset().label("Weighted by Stake"))
                
                .and();

        config.
            options()
                .responsive(true)
                .title()
                    .display(true)
                    .text("Voting Preferences")
                    .and()
                .animation()
                    .animateScale(true)
                    .animateRotate(true)
                    .and()
               .done();
        
        ArrayList<String>colors=new ArrayList<String>();
        List<String> labels = config.data().getLabels();
        Dataset ds = config.data().getDatasets().get(0);
            PieDataset lds = (PieDataset) ds;
            String[] culori= {"#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360","#F2913A", "#E1BFBD", "#5AB45C", "#1D9FB1", "#6A5360"};
            lds.backgroundColor(culori);
            List<Double> data = new ArrayList<>();
            for (int i = 0; i < labels.size(); i++) {
                data.add((double) (valori1.get(i)));
            }
            lds.dataAsList(data);
            Dataset ds2 = config.data().getDatasets().get(1);
            PieDataset lds2 = (PieDataset) ds2;
            String[] culori2 = {"#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360","#F2913A", "#E1BFBD", "#5AB45C", "#1D9FB1", "#6A5360"};
            lds2.backgroundColor(culori);
            List<Double> data2 = new ArrayList<>();
            for (int i = 0; i < labels.size(); i++) {
                data2.add((double) (valori2.get(i)));
            }
            System.out.println("iar aici avem "+all);
            if(all==true) {
            lds2.dataAsList(data2);
            }
        ChartJs chart = new ChartJs(config);
        chart.setJsLoggingEnabled(true);
        chart.addClickListener((a,b) -> DemoUtils.notification(a, b, config.data().getDatasets().get(a)));
        return chart;
    }
    static String getRandomColor() {
	    Random random = new Random();
	    String[] letters = "0123456789ABCDEF".split("");
	    String color = "#";
	    for (int i = 0; i < 6; i++) {
	        color += letters[Math.round(random.nextFloat() * 15)];
	    }
	    return color;
	}
}

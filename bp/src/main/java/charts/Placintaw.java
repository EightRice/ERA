package charts;



import java.util.ArrayList;
import java.util.List;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.PieChartConfig;
import com.byteowls.vaadin.chartjs.data.Dataset;
import com.byteowls.vaadin.chartjs.data.PieDataset;

import com.byteowls.vaadin.chartjs.utils.ColorUtils;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;

@UIScope
@SpringView
public class Placintaw extends AbstractChartView {
	ArrayList<String>locuri;ArrayList <Double>procente;
	ArrayList<Double>valori;
	String titlu;Double total=0.0;
	String [] features= {"Node Setup","Team Notoriety","Jurisdiction friendliness","Geographic Density","Content Creation","Developer Activity",
			"Backlinks to website","Community Building","Social Media Presence","Popularity"};
	
    private static final long serialVersionUID = 4894923343920891837L;

    public Placintaw(ArrayList<Double>valori) {
       	this.valori=valori;double total=0;
    	for (int i=0;i<valori.size();i++) {
    		total=total+valori.get(i);
    	}
    
    	
    }
    
    
    @Override
    public Component getChart() {
        PieChartConfig config = new PieChartConfig();
        config
            .data()
                .labels(features)
                .addDataset(new PieDataset().label(""))
                .and();

        config.
            options()
                .responsive(true)
                .title()
                    .display(true)
                    .text("Voting preferences weighted by stake")
                    .and()
                .animation()
                    //.animateScale(true)
                    .animateRotate(true)
                    .and()
               .done();

        List<String> labels = config.data().getLabels();
        for (Dataset<?, ?> ds : config.data().getDatasets()) {
            PieDataset lds = (PieDataset) ds;
            List<String> colors = new ArrayList<>();
            List<Double> data = new ArrayList<>();
            for (int i = 0; i < features.length; i++) {
                lds.addData(valori.get(i));
             	 data.add((double) (valori.get(i)));
             	colors.add(ColorUtils.randomColor(0.7));
             }
            lds.dataAsList(data);
            
            
            lds.backgroundColor(colors.toArray(new String[colors.size()]));
            lds.dataAsList(data);
        }
        
        ChartJs chart = new ChartJs(config);
        chart.setJsLoggingEnabled(true);
        chart.addClickListener((a,b) ->
            DemoUtils.notification(a, b, config.data().getDatasets().get(a)));

        return chart;
    }

}

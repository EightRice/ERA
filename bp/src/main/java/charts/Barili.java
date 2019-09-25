package charts;
import java.util.ArrayList;
import java.util.List;
import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.BarChartConfig;
import com.byteowls.vaadin.chartjs.data.BarDataset;
import com.byteowls.vaadin.chartjs.data.Dataset;
import com.byteowls.vaadin.chartjs.options.InteractionMode;
import com.byteowls.vaadin.chartjs.options.Position;
import com.byteowls.vaadin.chartjs.options.scale.Axis;
import com.byteowls.vaadin.chartjs.options.scale.LinearScale;
import com.byteowls.vaadin.chartjs.utils.ColorUtils;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;

@UIScope
@SpringView
public class Barili extends AbstractChartView {
	ArrayList<String>locuri;
	ArrayList<Integer>valori;
	String titlu;
	String [] features= {"Node Setup","Team Notoriety","Jurisdiction friendliness","Geographic Diversity","Content Creation","Developer Activity",
			"Backlinks to website","Community Building","Social Media Presence"};;
	
    private static final long serialVersionUID = 934342877200303954L;
    public Barili(ArrayList<Integer>valori, String titlu) {
    	this.locuri=locuri;
    	this.valori=valori;
    	this.titlu=titlu;
    	
    }
        
    @Override
    public Component getChart() {
    	
    	
    	
        BarChartConfig barConfig = new BarChartConfig();
        barConfig.
            data()
                .labels(features)
               
                .addDataset(
                        new BarDataset().backgroundColor(
                        		ColorUtils.randomColor(0.7), ColorUtils.randomColor(0.7), ColorUtils.randomColor(0.7),
                        		ColorUtils.randomColor(0.7), ColorUtils.randomColor(0.7), ColorUtils.randomColor(0.7),
                        		ColorUtils.randomColor(0.7)).label("Oldest value added on Jul 21, 2019 | Last updated on Aug 6, 2019").yAxisID("y-axis-1"))
                .and();
        barConfig.
            options()
                .responsive(true)
                .hover()
                    .mode(InteractionMode.INDEX)
                    .intersect(true)
                    .animationDuration(400)
                    .and()
                .title()
                    .display(true)
                    .text("Candidate feature scores: ")
                    .and()
                .scales()
                    .add(Axis.Y, new LinearScale().display(true).position(Position.LEFT).id("y-axis-1"))
                    
                    .and()
               .done();

        List<String> labels = barConfig.data().getLabels();
        for (Dataset<?, ?> ds : barConfig.data().getDatasets()) {
            BarDataset lds = (BarDataset) ds;
            
            List<Double> data = new ArrayList<>();
            for (int i = 0; i < features.length; i++) {
                lds.addData(valori.get(i));
             	 data.add((double) (valori.get(i)));
             }
            lds.dataAsList(data);
        }
        
        ChartJs chart = new ChartJs(barConfig);
        chart.setJsLoggingEnabled(true);
        chart.addClickListener((a,b) -> DemoUtils.notification(a, b, barConfig.data().getDatasets().get(a)));
        chart.addLegendClickListener(DemoUtils::legendNotification);
        return chart;
    }

}
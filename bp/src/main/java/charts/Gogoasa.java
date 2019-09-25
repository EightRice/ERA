package charts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.DonutChartConfig;
import com.byteowls.vaadin.chartjs.data.Dataset;
import com.byteowls.vaadin.chartjs.data.PieDataset;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;

@UIScope
@SpringView
public class Gogoasa extends AbstractChartView {
    private static final long serialVersionUID = 4894923343920891837L;
    public ArrayList<String> locuri;
    public ArrayList<Integer> valori;
    public String titlu;
    public Gogoasa(ArrayList<String> locuri,ArrayList<Integer>valori, String titlu) {
    	this.locuri=locuri;
    	this.valori=valori;
    	this.titlu=titlu;
    }
    @Override
    public Component getChart(){
    	System.out.println(locuri);
        DonutChartConfig config = new DonutChartConfig();
        String[]loci= new String[locuri.size()];
        for (int i=0;i<locuri.size();i++) {
        	loci[i]=locuri.get(i);
        }
        config
            .data()
                .labels(loci)
                .addDataset(new PieDataset().label("Dataset 1"))
                .and();
        config.
            options()
                .rotation(Math.PI)
                .circumference(Math.PI)
                .responsive(true)
                .title()
                    .display(true)
                    .text(titlu)
                    .and()
                .animation()
                    .animateScale(false)
                    .animateRotate(true)
                    .and()
               .done();
        String[] colors = new String[locuri.size()];
        for(int i=0;i<locuri.size();i++) {colors[i]=getRandomColor();
        System.out.println(colors[i]);}
        List<String> labels = config.data().getLabels();
        for (Dataset<?, ?> ds : config.data().getDatasets()) {
            PieDataset lds = (PieDataset) ds;
            lds.backgroundColor(colors);
            for (int i = 0; i < locuri.size(); i++) {
               lds.addData(valori.get(i));
            	// data.add((double) (valori.get(i)));
            }
           // lds.dataAsList(data);
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

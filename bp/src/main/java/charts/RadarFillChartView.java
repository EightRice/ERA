package charts;
import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.RadarChartConfig;
import com.byteowls.vaadin.chartjs.data.RadarDataset;
import com.byteowls.vaadin.chartjs.options.FillMode;
import com.byteowls.vaadin.chartjs.utils.ColorUtils;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;
import java.util.List;

@UIScope
@SpringView
public class RadarFillChartView extends AbstractChartView {
	String cine;
	
    private static final long serialVersionUID = -8575881820534087527L;  
    public RadarFillChartView(String cine) {
    	this.cine=cine;
    }
    
    @Override
    public Component getChart() {
        RadarChartConfig config = new RadarChartConfig();
        config
            .data()
                .labels("Openness", "Conscientiousness", "Extroversion", "Agreeableness", "Neuroticism")
                .addDataset(new RadarDataset().fill(FillMode.START))
                .addDataset(new RadarDataset().hidden(true).fill(1))
                .and();

        config.
            options()
                .maintainAspectRatio(true)
                .elements()
                    .line()
                        .tension(0.000001d)
                        .and()
                    .and()
                .title()
                    .display(true)
                    .text(cine)
                    .and()
               .done();

        SampleDataConfig sampleConfig = new SampleDataConfig().min(8).max(16).count(5).decimals(2).continuity(1);
        
            RadarDataset lds = (RadarDataset) config.data().getDatasetAtIndex(0);
            lds.label("D");
            int[] rgb = DemoUtils.getRgbColor(0);
            lds.borderColor(ColorUtils.toRgb(rgb));
            lds.backgroundColor(ColorUtils.toRgba(rgb, 0.5));
            // generate data
            List<Double> data = DemoUtils.generateSampleData(sampleConfig);
            sampleConfig.from(data);
            lds.dataAsList(data);
            

        ChartJs chart = new ChartJs(config);
        chart.setJsLoggingEnabled(true);
        chart.setWidth(480, Unit.PIXELS);
        chart.addClickListener((a,b) ->
            DemoUtils.notification(a, b, config.data().getDatasets().get(a)));
        return chart;
    }

}

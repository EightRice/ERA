package charts;

import java.util.ArrayList;
import java.util.List;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.LineChartConfig;
import com.byteowls.vaadin.chartjs.data.LineDataset;
import com.byteowls.vaadin.chartjs.options.InteractionMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import charts.AbstractChartView;
import charts.DemoUtils;

@UIScope
@SpringView
public class CuBuneSiCuRele extends AbstractChartView {
    private static final long serialVersionUID = -1977315515493155463L;
   double[] valoriB;
   double[] valoriR;
   double[] valoriC={1.0,2.1,4.5,6.0,7.1,9.0,11.0};
   public CuBuneSiCuRele(double[] vb,double[] vr) {
	   this.valoriB=vb;this.valoriR=vr;}
    @Override
    public Component getChart() {
        VerticalLayout layout = new VerticalLayout();	
 //       layout.setSizeFull();
        List<Boolean> intersects = new ArrayList<>();
        intersects.add(true);
        intersects.add(false);
//        for (PositionMode positionMode : PositionMode.values()) {
            LineChartConfig config = new LineChartConfig();
            config.data()
                .labels("...", "1-7 Jul", "8-15 Jul", "16-22 Jul", "23-28 Jul", "Last Week", "This Week")
                .addDataset(new LineDataset().label("Comments")
                        .borderColor(DemoUtils.RGB_GREEN)
                        .backgroundColor(DemoUtils.RGB_GREEN)
                        .data(valoriB[6],valoriB[5],valoriB[4],valoriB[3],valoriB[2],valoriB[1],valoriB[0])
                        .fill(false))
                .addDataset(new LineDataset().label("Likes")
                        .borderColor(DemoUtils.RGB_BLUE)
                        .backgroundColor(DemoUtils.RGB_BLUE)
                        .data(valoriR[6],valoriR[5],valoriR[4],valoriR[3],valoriR[2],valoriR[1],valoriR[0])
                        .fill(false))
                .and()
            .options()
                .responsive(true)
                .title()
                    .display(true)
                    
                    .and()
                .tooltips()
//                    .position(positionMode)
                    .mode(InteractionMode.INDEX)
                    .intersect(false)
                    .and()
                .done();
            ChartJs chart = new ChartJs(config);
            //chart.addStyleName("toti");
            chart.setStyleName("toti");
            chart.setJsLoggingEnabled(true);
            chart.setWidth("100%");
            layout.setWidth("100%");layout.setStyleName("toti");
            layout.addComponent(chart);
//        }
        Panel p = new Panel();
        p.setContent(layout);
        p.setSizeFull();
        return p;
    }

}

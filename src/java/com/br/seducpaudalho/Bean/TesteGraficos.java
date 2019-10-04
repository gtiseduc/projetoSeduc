/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.seducpaudalho.Bean;

import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.chartistjsf.model.chart.AspectRatio;
import org.chartistjsf.model.chart.Axis;
import org.chartistjsf.model.chart.AxisType;
import org.chartistjsf.model.chart.BarChartModel;
import org.chartistjsf.model.chart.BarChartSeries;
import org.chartistjsf.model.chart.LineChartModel;
import org.chartistjsf.model.chart.LineChartSeries;

/**
 *
 * @author SEC-EDUC02
 */
@ManagedBean
@SessionScoped
public class TesteGraficos {

    private LineChartModel lineModel;
    
    private BarChartModel barChartModel;

    public void gerarGrafico() {

        barChartModel = new BarChartModel();
        barChartModel.setAspectRatio(AspectRatio.GOLDEN_SECTION);
        barChartModel.addLabel("Measure1");
        barChartModel.addLabel("Measure2");
        barChartModel.addLabel("Measure3");
        barChartModel.addLabel("Measure4");
        barChartModel.addLabel("Measure5");
        BarChartSeries series1 = new BarChartSeries();
        series1.setName("First Series");
        series1.set(19);
        series1.set(27);
        series1.set(12);
        series1.set(33);
        series1.set(40);
        BarChartSeries series2 = new BarChartSeries();
        series2.setName("Second Series");
        series2.set(13);
        series2.set(61);
        series2.set(16);
        series2.set(28);
        series2.set(11);
        BarChartSeries series3 = new BarChartSeries();
        series3.setName("Third Series");
        series3.set(18);
        series3.set(11);
        series3.set(21);
        series3.set(53);
        series3.set(48);
        Axis xAxis = barChartModel.getAxis(AxisType.X);
        xAxis.setShowGrid(false);
        barChartModel.addSeries(series1);
        barChartModel.addSeries(series2);
        barChartModel.addSeries(series3);
        barChartModel.setShowTooltip(true);
        barChartModel.setSeriesBarDistance(15);
        barChartModel.setAnimateAdvanced(true);
    }

    public LineChartModel getLineModel() {
        return lineModel;
    }

    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }

    public BarChartModel getBarChartModel() {
        return barChartModel;
    }

    public void setBarChartModel(BarChartModel barChartModel) {
        this.barChartModel = barChartModel;
    }
    
    

}

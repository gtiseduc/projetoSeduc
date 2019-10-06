/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.seducpaudalho.Bean;

import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;

import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

/**
 *
 * @author SEC-EDUC02
 */
@ManagedBean
@SessionScoped
public class TesteGraficos {

    
    
    private HorizontalBarChartModel horizontalBarModel;

    public void gerarGrafico() {

        
        
        horizontalBarModel = new HorizontalBarChartModel();
        
        
         ChartSeries boys = new ChartSeries();
        ChartSeries girls = new ChartSeries();
        ChartSeries test = new ChartSeries();
        ChartSeries tes = new ChartSeries();
    
        boys.setLabel("Boys");
        girls.setLabel("Girls");
        test.setLabel("Test");
        tes.setLabel("Tes");
      
        String a = "A";
        
        for (int i = 0; i < 4; i++) {
            a = a+a;
         
        
        
        boys.set(a, 40);
        girls.set(a, 60);
        test.set(a, 80);
         tes.set(a, 80);
       
       }
 
      
        
        
        
        
        //}
       
       horizontalBarModel.addSeries(boys);
        horizontalBarModel.addSeries(girls);
        horizontalBarModel.addSeries(test);
        horizontalBarModel.addSeries(tes);
 
 
        horizontalBarModel.setTitle("Horizontal and Stacked");
        horizontalBarModel.setSeriesColors("0000ff,66ff33,ff0000,ffff00");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
 
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Births");
        xAxis.setMin(0);
        xAxis.setMax(100);
 
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Gender");
        
      
    }

   

    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }

    public void setHorizontalBarModel(HorizontalBarChartModel horizontalBarModel) {
        this.horizontalBarModel = horizontalBarModel;
    }
    
    

}

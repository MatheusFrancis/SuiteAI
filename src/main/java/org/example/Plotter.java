package org.example;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class Plotter extends JFrame {

    public void ScatterPlot(double[] firstDim, double[] secondDim) {




        XYSeries series = new XYSeries("Data Points");

        // Add data points from the two 1D arrays (xData, yData)
        for (int i = 0; i < firstDim.length; i++) {
            series.add(firstDim[i], secondDim[i]);
        }

        // Create a dataset and add the series to it
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        // Create a scatter plot (XYPlot is used for scatter plots)
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Scatter Plot Example",  // Title
                "X-Axis",               // X-Axis Label
                "Y-Axis",               // Y-Axis Label
                dataset                 // Dataset
        );

        // Create a chart panel and set the chart as content
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }
    public void LinearPlot(double[] firstDim, double[] secondDim) {

        XYSeries series = new XYSeries("Data Points");

        // Add data points from the arrays X and Y
        for (int i = 0; i < firstDim.length; i++) {
            series.add(firstDim[i], secondDim[i]);
        }

        // Add the series to the dataset
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        // Create a line chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Line Plot from Arrays", // Chart Title
                "X-Axis",               // X-Axis Label
                "Y-Axis",               // Y-Axis Label
                dataset                 // Dataset
        );

        // Display the chart in a JPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

}

package org.myorg;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class chart extends JFrame{
	ChartPanel chartPanel;
	public chart(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        // This will create the dataset 
        PieDataset dataset = createDataset();
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle);
        
        // we put the chart into a panel
        chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(Color.WHITE);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(300, 300));
       
        // add it to our application
        setContentPane(chartPanel);
        
    }
	public ChartPanel retchart()
	{
		return chartPanel;
	}
    
    
/** * Creates a sample dataset */

    private  PieDataset createDataset() {
    	String t="";
        DefaultPieDataset result = new DefaultPieDataset();
        try{
        	int create=0,delete=0,resume=0,rebuild=0,snapshot=0;
        	FileReader f10 =  new FileReader("/home/hduser/res.txt");
    		BufferedReader f12 = new BufferedReader(f10);
    		for(int j=0;(t = f12.readLine()) != null;j++)
    		{
    			
    			
    			
    			if(t.contains("Create"))
    			{
    				
    				create++;
    				
    			}
    			else if(t.contains("Delete"))
    			{
    				
    				delete++;
    				
    			}
    			else if(t.contains("Snapshot"))
    			{
    				
    				snapshot++;
    			}
    			else if(t.contains("Resume"))
    			{
    				resume++;
    			}
    			else
    			{
    				rebuild++;
    			}
    			result.setValue("Launch Instance", create);
    			result.setValue("Terminate Instance", delete);
    			result.setValue("Snapshot Instance", snapshot);
    			result.setValue("Resume Instance", resume);
    			result.setValue("Rebuild Instance", rebuild);
    		
    		}
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" );	
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file ");	
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        
       
        return result;
        
    }
    
 private JFreeChart createChart(PieDataset dataset, String title) {
        
        JFreeChart chart = ChartFactory.createPieChart3D(title,          // chart title
            dataset,                // data
            true,                   // include legend
            true,
            false);
        chart.setBackgroundPaint(Color.WHITE);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
        
    }
 
 public static void main(String[] args) {
     chart demo = new chart("Flows", "Use Cases");
     
     demo.pack();
     demo.setVisible(true);
 }

}

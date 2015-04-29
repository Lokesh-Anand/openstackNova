
package org.myorg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RefineryUtilities;

import com.orsoncharts.util.TextAnchor;

/**
 * A simple demonstration application showing how to create a bar chart.
 *
 */
public class BarChartDemo extends ApplicationFrame {
	String p[][]=new String[10][50];
    /**
     * Creates a new demo instance.
     *
     * @param title  the frame title.
     * @throws IOException 
     */
    public BarChartDemo(final String title) throws IOException {

        super(title);
        
        
        final CategoryDataset dataset1 = createDataset1();
        final CategoryDataset dataset2 = createDataset2();
       
        
        final JFreeChart chart1 = createChart(dataset1);
        final JFreeChart chart2 = createChart1(dataset2);
        //final ChartPanel chartPanel = new ChartPanel(chart);
        //chartPanel.setPreferredSize(new Dimension(800, 600));
        JFrame frame = new JFrame("Chart");
        frame.getContentPane().add(new ChartPanel(chart1), BorderLayout.WEST);
        frame.getContentPane().add(new ChartPanel(chart2), BorderLayout.EAST);
        frame.setPreferredSize(new Dimension(1600,900));
        frame.pack();
        frame.setVisible(true);
        
       // JScrollPane p=new JScrollPane();
        //p.setPreferredSize(new Dimension(800,600));
        //p.add(chartPanel);
       // setContentPane(chartPanel);

    }

    /**
     * Returns a sample dataset.
     * 
     * @return The dataset.
     * @throws IOException 
     **/
    
    public  BarChartDemo() throws IOException
    
    {	super("");
    	//createDataset1();
    	
    }
    private CategoryDataset createDataset1() throws IOException {
        
        // row keys...
        final String series1 = "First";
        final String series2 = "Second";
        final String series3 = "Third";
        JavaTokenizer j=new JavaTokenizer();
        tok g=new tok();
        String tmp[][]={};String series[]=new String[26];
        String tmp1[][]={};
           tmp=j.main(null);
           tmp1=g.main(null);
           for(int i=0;i<26;i++)
           for(int u=1;u<tmp[i].length;u++)
           {
        	 if(tmp[i][u]!=null)  
        	{String t=tmp[i][u].replaceAll(":","");//String s=t.replace(".","");
       		
       		tmp[i][u]=t;
       		System.out.println(tmp[i][u]);
        	}  
           }
           for(int i=0;i<26;i++)
               for(int u=1;u<tmp1[i].length;u++)
               {
            	 if(tmp1[i][u]!=null)  
            	{String t=tmp1[i][u].replaceAll(":","");//String s=t.replace(".","");
           		
           		tmp1[i][u]=t;
           		//System.out.println(tmp[i][u]);
            	}  
               }
           //System.out.println(tmp[0][0]);
        // column keys...
           String y[][]=new String[5][50];
        final String category1 = "CREATE VM";
        final String category2 = "DELETE VM";
        final String category3 = "RESUME VM";
        final String category4 = "REBUILD VM";
        final String category5 = "SNAPSHOT VM";
        String t="";
        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try{FileReader f10 =  new FileReader("/home/hduser/res.txt");
		BufferedReader f12 = new BufferedReader(f10);
		int a=0,b=0,c=0,d=0,e=0;
		int k=0,l=0,m=0,n=0,o=0;
		int q=0,r=0,s=0,w=0,z=0;
		for(int v=0;(t = f12.readLine()) != null;v++)
		{	
			
				 if(t.contains("Create"))
				 {
					y[0][a++]="flow"+ (a);
					for(int h=0;h<26;h++)
					{	if(t.contains(tmp[h][0]))
							{
							p[0][k]=tmp[h][1];
							//System.out.println(p[0][k]);
							k++;
							
							p[5][q]=tmp1[h][1];q++;
							break;
							}
					}
				 }
			if(t.contains("Delete"))
					{
					y[1][b++]="flow"+ (b);
					for(int h=0;h<26;h++)
					{	if(t.contains(tmp[h][0]))
							{
							p[1][l]=tmp[h][1];
							//System.out.println(p[0][k]);
							l++;
							p[6][r]=tmp1[h][1];r++;
							break;
							}
					}
					
					}
				if(t.contains("Resume"))
				{	
					y[2][c++]="flow"+ (c);  
					for(int h=0;h<26;h++)
					{	if(t.contains(tmp[h][0]))
							{
							p[2][m]=tmp[h][1];
							
							//System.out.println(p[0][k]);
							m++;
							p[7][s]=tmp1[h][1];s++;
							break;
							}
					}
				
				
				}
					//dataset.addValue(3.0, series[o], category3);
				if(t.contains("Rebuild"))
				{
				y[3][d++]="flow"+ (d);  
				for(int h=0;h<26;h++)
				{	if(t.contains(tmp[h][0]))
						{
						p[3][n]=tmp[h][1];
						//System.out.println(p[0][k]);
						n++;
						p[8][w]=tmp1[h][1];w++;
						break;
						}
				}
				
				}
					
					//dataset.addValue(4.0, series[o], category4);
				if(t.contains("Snapshot"))
					{
					y[4][e++]="flow"+ (e);  
					for(int h=0;h<26;h++)
					{	if(t.contains(tmp[h][0]))
							{
							p[4][o]=tmp[h][1];
							//System.out.println(p[0][k]);
							o++;
							p[9][z]=tmp1[h][1];z++;
							break;
							}
					}
					
					}
					//dataset.addValue(5.0, series[o], category5);

			
			
			
		}
         
		for(String[] str:y) {
			
			   for(String value:str) {
			      System.out.println(value);
			   }
			}
		/*for(String[] str:p) {
			
			   for(String value:str) {
			      System.out.println(value);
			   }
			}
     */
		List<String> list1 = new ArrayList<String>();
		//int i=0;
		

		for(int a1=5,i=0;a1<10;a1++,i++) {
			
			   for(int b1=0;b1<50;b1++) {
			      if(p[a1][b1]!=null)
				  {
			    	 //System.out.println("true");
				  list1.add(p[a1][b1]+"#"+tmp1[i][0]);
			      }
			   
			   }
			   
				}
			Collections.sort(list1);
			   
			   
		for(String s1:list1)
			System.out.println(s1);
		
        
        }
		catch(Exception e){}
       
			
        	
		
		
		
		
			for(int u=0;y[0][u]!=null;u++)
            dataset.addValue(Double.parseDouble(p[5][u]), y[0][u], category1);
            
            for(int u=0;y[1][u]!=null;u++)
                dataset.addValue(Double.parseDouble(p[6][u]), y[1][u], category2);
            for(int u=0;y[2][u]!=null;u++)
                dataset.addValue(Double.parseDouble(p[7][u]), y[2][u], category3);
            for(int u=0;y[3][u]!=null;u++)
                dataset.addValue(Double.parseDouble(p[8][u]), y[3][u], category4);
            for(int u=0;y[4][u]!=null;u++)
                dataset.addValue(Double.parseDouble(p[9][u]), y[4][u], category5);
        
        //System.out.println(dataset.getRowIndex(p[1][1]));

        /*dataset.addValue(5.0, series2, category1);
        dataset.addValue(7.0, series2, category2);
        dataset.addValue(3.0, series3, category2);
        dataset.addValue(2.0, series3, category3);
        dataset.addValue(3.0, series3, category4);
        dataset.addValue(6.0, series3, category5);
        */
        
        return dataset;
        
    }

 private CategoryDataset createDataset2() throws IOException {
        
        // row keys...
        final String series1 = "First";
        final String series2 = "Second";
        final String series3 = "Third";
        JavaTokenizer j=new JavaTokenizer();
        tok g=new tok();
        String tmp[][]={};String series[]=new String[26];
        String tmp1[][]={};
           tmp=j.main(null);
           tmp1=g.main(null);
           for(int i=0;i<26;i++)
           for(int u=1;u<tmp[i].length;u++)
           {
        	 if(tmp[i][u]!=null)  
        	{String t=tmp[i][u].replaceAll(":","");//String s=t.replace(".","");
       		
       		tmp[i][u]=t;
       		//System.out.println(tmp[i][u]);
        	}  
           }
           for(int i=0;i<26;i++)
               for(int u=1;u<tmp1[i].length;u++)
               {
            	 if(tmp1[i][u]!=null)  
            	{String t=tmp1[i][u].replaceAll(":","");//String s=t.replace(".","");
           		
           		tmp1[i][u]=t;
           		//System.out.println(tmp[i][u]);
            	}  
               }
           //System.out.println(tmp[0][0]);
        // column keys...
           String y[][]=new String[5][50];String p[][]=new String[10][50];
        final String category1 = "CREATE VM";
        final String category2 = "DELETE VM";
        final String category3 = "RESUME VM";
        final String category4 = "REBUILD VM";
        final String category5 = "SNAPSHOT VM";
        String t="";
        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try{FileReader f10 =  new FileReader("/home/hduser/res.txt");
		BufferedReader f12 = new BufferedReader(f10);
		int a=0,b=0,c=0,d=0,e=0;
		int k=0,l=0,m=0,n=0,o=0;
		int q=0,r=0,s=0,w=0,z=0;
		for(int v=0;(t = f12.readLine()) != null;v++)
		{	
			
				 if(t.contains("Create"))
				 {
					y[0][a++]="flow"+ (a);
					for(int h=0;h<26;h++)
					{	if(t.contains(tmp[h][0]))
							{
							p[0][k]=tmp[h][1];
							//System.out.println(p[0][k]);
							k++;
							
							p[5][q]=tmp1[h][1];q++;
							break;
							}
					}
				 }
			if(t.contains("Delete"))
					{
					y[1][b++]="flow"+ (b);
					for(int h=0;h<26;h++)
					{	if(t.contains(tmp[h][0]))
							{
							p[1][l]=tmp[h][1];
							//System.out.println(p[0][k]);
							l++;
							p[6][r]=tmp1[h][1];r++;
							break;
							}
					}
					
					}
				if(t.contains("Resume"))
				{	
					y[2][c++]="flow"+ (c);  
					for(int h=0;h<26;h++)
					{	if(t.contains(tmp[h][0]))
							{
							p[2][m]=tmp[h][1];
							
							//System.out.println(p[0][k]);
							m++;
							p[7][s]=tmp1[h][1];s++;
							break;
							}
					}
				
				
				}
					//dataset.addValue(3.0, series[o], category3);
				if(t.contains("Rebuild"))
				{
				y[3][d++]="flow"+ (d);  
				for(int h=0;h<26;h++)
				{	if(t.contains(tmp[h][0]))
						{
						p[3][n]=tmp[h][1];
						//System.out.println(p[0][k]);
						n++;
						p[8][w]=tmp1[h][1];w++;
						break;
						}
				}
				
				}
					
					//dataset.addValue(4.0, series[o], category4);
				if(t.contains("Snapshot"))
					{
					y[4][e++]="flow"+ (e);  
					for(int h=0;h<26;h++)
					{	if(t.contains(tmp[h][0]))
							{
							p[4][o]=tmp[h][1];
							//System.out.println(p[0][k]);
							o++;
							p[9][z]=tmp1[h][1];z++;
							break;
							}
					}
					
					}
					//dataset.addValue(5.0, series[o], category5);

			
			
			
		}
         
	/*	for(String[] str:y) {
			
			   for(String value:str) {
			      System.out.println(value);
			   }
			}
		for(String[] str:p) {
			
			   for(String value:str) {
			      System.out.println(value);
			   }
			}*/
     
        
        }
		catch(Exception e){}
       
        	
        	for(int u=0;y[0][u]!=null;u++)
            dataset.addValue(Double.parseDouble(p[0][u]), y[0][u], category1);
            
            for(int u=0;y[1][u]!=null;u++)
                dataset.addValue(Double.parseDouble(p[1][u]), y[1][u], category2);
            for(int u=0;y[2][u]!=null;u++)
                dataset.addValue(Double.parseDouble(p[2][u]), y[2][u], category3);
            for(int u=0;y[3][u]!=null;u++)
                dataset.addValue(Double.parseDouble(p[3][u]), y[3][u], category4);
            for(int u=0;y[4][u]!=null;u++)
                dataset.addValue(Double.parseDouble(p[4][u]), y[4][u], category5);
        
        //System.out.println(dataset.getRowIndex(p[1][1]));

        /*dataset.addValue(5.0, series2, category1);
        dataset.addValue(7.0, series2, category2);
        dataset.addValue(3.0, series3, category2);
        dataset.addValue(2.0, series3, category3);
        dataset.addValue(3.0, series3, category4);
        dataset.addValue(6.0, series3, category5);
        */
        
        return dataset;
        
    }
 
    
    /**
     * Creates a sample chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return The chart.
     */
    
  
    
    
    private JFreeChart createChart(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            "Start Instances",         // chart title
            "Category",               // domain axis label
            "Value",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createStandardTickUnits());
        rangeAxis.setLowerBound(122000);
        rangeAxis.setUpperBound(155000);
        rangeAxis.setLabel("timestamp");
       /* ValueMarker marker0 = new ValueMarker(132940.039);//marker.setValue(132940.039);
        ValueMarker marker1 = new ValueMarker(133045.868);
        ValueMarker marker2 = new ValueMarker(132838.188);
        ValueMarker marker3 = new ValueMarker(132915.461);
        ValueMarker marker4 = new ValueMarker(133014.044);
        ValueMarker marker5 = new ValueMarker(153858.335);//marker.setValue(132940.039);
        ValueMarker marker6 = new ValueMarker(153851.601);
        ValueMarker marker7 = new ValueMarker(153854.805);
        ValueMarker marker8 = new ValueMarker(153909.279);
        ValueMarker marker9 = new ValueMarker(153907.606);
        ValueMarker marker10 = new ValueMarker(122839.079);
        ValueMarker marker11 = new ValueMarker(122807.281);
        ValueMarker marker12= new ValueMarker(152808.806);//marker.setValue(132940.039);
        ValueMarker marker13 = new ValueMarker(122822.989);
        ValueMarker marker14= new ValueMarker(122857.182);
        ValueMarker marker15 = new ValueMarker(153909.279);
        ValueMarker marker16 = new ValueMarker(153907.606);

        // position is the value on the axis
        marker0.setPaint(Color.blue);
        marker1.setPaint(Color.green);
        marker2.setPaint(Color.red);marker3.setPaint(Color.yellow);marker4.setPaint(Color.cyan);
        //marker.setLabel("here"); // see JavaDoc for labels, colors, strokes

        CategoryPlot plot1 = chart.getCategoryPlot();
        
        plot1.addRangeMarker(marker0);
        plot1.addRangeMarker(marker1);
        plot1.addRangeMarker(marker2);
        plot1.addRangeMarker(marker3);
        plot1.addRangeMarker(marker4);plot1.addRangeMarker(marker5);
        plot1.addRangeMarker(marker6);
        plot1.addRangeMarker(marker7);
        plot1.addRangeMarker(marker8);
        plot1.addRangeMarker(marker9);
        
       */
        DecimalFormat newFormat = new DecimalFormat("0.000");
        rangeAxis.setNumberFormatOverride(newFormat);
        rangeAxis.setTickUnit(new NumberTickUnit(600));
        //rangeAxis.setTickMarksVisible(true); 
        //rangeAxis.setTickMarkInsideLength(3f);
        //rangeAxis.
        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        //GroupedStackedBarRenderer renderer1 = new GroupedStackedBarRenderer();
		//KeyToGroupMap map = new KeyToGroupMap("G1");
        /*final IntervalMarker target = new IntervalMarker(129000,131000);
        final CategoryPlot plot1 = chart.getCategoryPlot();
        plot1.setBackgroundPaint(Color.lightGray);
        plot1.setDomainGridlinePaint(Color.white);
        plot1.setRangeGridlinePaint(Color.white);
        target.setLabel("Target Range");
       // target.setLabelFont(new Font("SansSerif", Font.ITALIC, 11));
        target.setLabelAnchor(RectangleAnchor.LEFT);
        //target.setLabelTextAnchor(TextAnchor.CENTER_LEFT);
        target.setPaint(new Color(222, 222, 255, 128));
        plot1.addRangeMarker(target, Layer.BACKGROUND)*/
        
        // set up gradient paints for series...
        final GradientPaint gp0 = new GradientPaint(
           0.0f, 0.0f, Color.blue, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp1 = new GradientPaint(
            0.0f, 0.0f, Color.green, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp2 = new GradientPaint(
            0.0f, 0.0f, Color.red, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp3 = new GradientPaint(
                0.0f, 0.0f, Color.yellow, 
                 0.0f, 0.0f, Color.lightGray
             );
             final GradientPaint gp4 = new GradientPaint(
                 0.0f, 0.0f, Color.cyan, 
                 0.0f, 0.0f, Color.lightGray
             );
             final GradientPaint gp5 = new GradientPaint(
                 0.0f, 0.0f, Color.pink,
                 0.0f, 0.0f, Color.lightGray
             );
             final GradientPaint gp6= new GradientPaint(
                     0.0f, 0.0f, Color.MAGENTA ,
                     0.0f, 0.0f, Color.lightGray
                 );
             final GradientPaint gp7 = new GradientPaint(
                     0.0f, 0.0f, Color.lightGray, 
                      0.0f, 0.0f, Color.lightGray
                  );
                  final GradientPaint gp8 = new GradientPaint(
                      0.0f, 0.0f, Color.lightGray, 
                      0.0f, 0.0f, Color.lightGray
                  );
                  final GradientPaint gp9 = new GradientPaint(
                      0.0f, 0.0f, Color.lightGray, 
                      0.0f, 0.0f, Color.lightGray
                  );
                  final GradientPaint gp10 = new GradientPaint(
                          0.0f, 0.0f, Color.lightGray, 
                           0.0f, 0.0f, Color.lightGray
                       );
                       final GradientPaint gp11 = new GradientPaint(
                           0.0f, 0.0f, Color.lightGray, 
                           0.0f, 0.0f, Color.lightGray
                       );
                       final GradientPaint gp12 = new GradientPaint(
                           0.0f, 0.0f, Color.lightGray,
                           0.0f, 0.0f, Color.lightGray
                       );
                       final GradientPaint gp13= new GradientPaint(
                               0.0f, 0.0f, Color.lightGray ,
                               0.0f, 0.0f, Color.lightGray
                           );
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);
        renderer.setSeriesPaint(3, gp3);
        renderer.setSeriesPaint(4, gp4);
        renderer.setSeriesPaint(5, gp5);
        renderer.setSeriesPaint(6, gp6);
        /*renderer.setSeriesPaint(0, gp7);
        renderer.setSeriesPaint(1, gp8);
        renderer.setSeriesPaint(2, gp9);
        renderer.setSeriesPaint(3, gp10);
        renderer.setSeriesPaint(4, gp11);
        renderer.setSeriesPaint(5, gp12);
        renderer.setSeriesPaint(6, gp13);
        renderer.setSeriesPaint(7, gp7);
        renderer.setSeriesPaint(8, gp8);
        renderer.setSeriesPaint(9, gp9);
        renderer.setSeriesPaint(10, gp10);
        renderer.setSeriesPaint(11, gp11);
        renderer.setSeriesPaint(12, gp12);
        renderer.setSeriesPaint(13, gp13);*/

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
    }
 private JFreeChart createChart1(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            "End Instances",         // chart title
            "Category",               // domain axis label
            "Value",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createStandardTickUnits());
        rangeAxis.setLowerBound(122000);
        rangeAxis.setUpperBound(155000);
        rangeAxis.setLabel("timestamp");
       /* ValueMarker marker0 = new ValueMarker(132940.039);//marker.setValue(132940.039);
        ValueMarker marker1 = new ValueMarker(133045.868);
        ValueMarker marker2 = new ValueMarker(132838.188);
        ValueMarker marker3 = new ValueMarker(132915.461);
        ValueMarker marker4 = new ValueMarker(133014.044);
        ValueMarker marker5 = new ValueMarker(153858.335);//marker.setValue(132940.039);
        ValueMarker marker6 = new ValueMarker(153851.601);
        ValueMarker marker7 = new ValueMarker(153854.805);
        ValueMarker marker8 = new ValueMarker(153909.279);
        ValueMarker marker9 = new ValueMarker(153907.606);
        ValueMarker marker10 = new ValueMarker(122839.079);
        ValueMarker marker11 = new ValueMarker(122807.281);
        ValueMarker marker12= new ValueMarker(152808.806);//marker.setValue(132940.039);
        ValueMarker marker13 = new ValueMarker(122822.989);
        ValueMarker marker14= new ValueMarker(122857.182);
        ValueMarker marker15 = new ValueMarker(153909.279);
        ValueMarker marker16 = new ValueMarker(153907.606);

        // position is the value on the axis
        marker0.setPaint(Color.blue);
        marker1.setPaint(Color.green);
        marker2.setPaint(Color.red);marker3.setPaint(Color.yellow);marker4.setPaint(Color.cyan);
        //marker.setLabel("here"); // see JavaDoc for labels, colors, strokes

        CategoryPlot plot1 = chart.getCategoryPlot();
        
        plot1.addRangeMarker(marker0);
        plot1.addRangeMarker(marker1);
        plot1.addRangeMarker(marker2);
        plot1.addRangeMarker(marker3);
        plot1.addRangeMarker(marker4);plot1.addRangeMarker(marker5);
        plot1.addRangeMarker(marker6);
        plot1.addRangeMarker(marker7);
        plot1.addRangeMarker(marker8);
        plot1.addRangeMarker(marker9);
        
       */
        DecimalFormat newFormat = new DecimalFormat("0.000");
        rangeAxis.setNumberFormatOverride(newFormat);
        rangeAxis.setTickUnit(new NumberTickUnit(600));
        //rangeAxis.setTickMarksVisible(true); 
        //rangeAxis.setTickMarkInsideLength(3f);
        //rangeAxis.
        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        //GroupedStackedBarRenderer renderer1 = new GroupedStackedBarRenderer();
		//KeyToGroupMap map = new KeyToGroupMap("G1");
        /*final IntervalMarker target = new IntervalMarker(129000,131000);
        final CategoryPlot plot1 = chart.getCategoryPlot();
        plot1.setBackgroundPaint(Color.lightGray);
        plot1.setDomainGridlinePaint(Color.white);
        plot1.setRangeGridlinePaint(Color.white);
        target.setLabel("Target Range");
       // target.setLabelFont(new Font("SansSerif", Font.ITALIC, 11));
        target.setLabelAnchor(RectangleAnchor.LEFT);
        //target.setLabelTextAnchor(TextAnchor.CENTER_LEFT);
        target.setPaint(new Color(222, 222, 255, 128));
        plot1.addRangeMarker(target, Layer.BACKGROUND)*/
        
        // set up gradient paints for series...
        final GradientPaint gp0 = new GradientPaint(
           0.0f, 0.0f, Color.blue, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp1 = new GradientPaint(
            0.0f, 0.0f, Color.green, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp2 = new GradientPaint(
            0.0f, 0.0f, Color.red, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp3 = new GradientPaint(
                0.0f, 0.0f, Color.yellow, 
                 0.0f, 0.0f, Color.lightGray
             );
             final GradientPaint gp4 = new GradientPaint(
                 0.0f, 0.0f, Color.cyan, 
                 0.0f, 0.0f, Color.lightGray
             );
             final GradientPaint gp5 = new GradientPaint(
                 0.0f, 0.0f, Color.pink,
                 0.0f, 0.0f, Color.lightGray
             );
             final GradientPaint gp6= new GradientPaint(
                     0.0f, 0.0f, Color.MAGENTA ,
                     0.0f, 0.0f, Color.lightGray
                 );
             final GradientPaint gp7 = new GradientPaint(
                     0.0f, 0.0f, Color.lightGray, 
                      0.0f, 0.0f, Color.lightGray
                  );
                  final GradientPaint gp8 = new GradientPaint(
                      0.0f, 0.0f, Color.lightGray, 
                      0.0f, 0.0f, Color.lightGray
                  );
                  final GradientPaint gp9 = new GradientPaint(
                      0.0f, 0.0f, Color.lightGray, 
                      0.0f, 0.0f, Color.lightGray
                  );
                  final GradientPaint gp10 = new GradientPaint(
                          0.0f, 0.0f, Color.lightGray, 
                           0.0f, 0.0f, Color.lightGray
                       );
                       final GradientPaint gp11 = new GradientPaint(
                           0.0f, 0.0f, Color.lightGray, 
                           0.0f, 0.0f, Color.lightGray
                       );
                       final GradientPaint gp12 = new GradientPaint(
                           0.0f, 0.0f, Color.lightGray,
                           0.0f, 0.0f, Color.lightGray
                       );
                       final GradientPaint gp13= new GradientPaint(
                               0.0f, 0.0f, Color.lightGray ,
                               0.0f, 0.0f, Color.lightGray
                           );
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);
        renderer.setSeriesPaint(3, gp3);
        renderer.setSeriesPaint(4, gp4);
        renderer.setSeriesPaint(5, gp5);
        renderer.setSeriesPaint(6, gp6);
        /*renderer.setSeriesPaint(0, gp7);
        renderer.setSeriesPaint(1, gp8);
        renderer.setSeriesPaint(2, gp9);
        renderer.setSeriesPaint(3, gp10);
        renderer.setSeriesPaint(4, gp11);
        renderer.setSeriesPaint(5, gp12);
        renderer.setSeriesPaint(6, gp13);
        renderer.setSeriesPaint(7, gp7);
        renderer.setSeriesPaint(8, gp8);
        renderer.setSeriesPaint(9, gp9);
        renderer.setSeriesPaint(10, gp10);
        renderer.setSeriesPaint(11, gp11);
        renderer.setSeriesPaint(12, gp12);
        renderer.setSeriesPaint(13, gp13);*/

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
    }

    
    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    * 
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     * @throws IOException 
     */
    public static void main(final String[] args) throws IOException {

        final BarChartDemo demo = new BarChartDemo("Bar Chart Demo");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
       // demo.setVisible(true);

    }

    public String[][] getP()
    {
    	
    	return p;
    }


}
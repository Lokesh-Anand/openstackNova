package org.myorg;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.IntervalBarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.DefaultIntervalCategoryDataset;
import org.jfree.ui.TextAnchor;

/**
 * An interval bar chart.
 *
 * @author Jeremy Bowman
 */
public class IntervalBarChartDemo1 {

    /** The categories. */
    private static final String[] CATEGORIES = {"Create Vm", "Delete Vm", "Resume", "Rebuild", "Snapshot"};

    /** The label font. */
    private static Font labelFont = null;

    /** The title font. */
    private static Font titleFont = null;

    /** The chart. */
    private JFreeChart chart = null;

    static {
        labelFont = new Font("Helvetica", Font.PLAIN, 10);
        titleFont = new Font("Helvetica", Font.BOLD, 14);
    }

    /**
     * Creates a new demo.
     * @throws IOException 
     */
    public IntervalBarChartDemo1() throws IOException {

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
           String p[][]=new String[10][50];
        String t="";
        // create the dataset...
        //final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
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
					
					}}
        }
    	catch(Exception e){}
    	DefaultIntervalCategoryDataset data = null;
        final double[][] lows = {{Double.parseDouble(p[5][0]),Double.parseDouble(p[6][0]),Double.parseDouble(p[7][0]),Double.parseDouble(p[8][0]),Double.parseDouble(p[9][0])}};
        final double[][] highs = {{Double.parseDouble(p[0][0]),Double.parseDouble(p[1][0]),Double.parseDouble(p[2][0]),Double.parseDouble(p[3][0]),Double.parseDouble(p[4][0])}};
        data = new DefaultIntervalCategoryDataset(lows, highs);
        data.setCategoryKeys(CATEGORIES);

        final String title = "Graph";
        final String xTitle = "flows";
        final String yTitle = "timestamp";
        final CategoryAxis xAxis = new CategoryAxis(xTitle);
        xAxis.setLabelFont(titleFont);
        xAxis.setTickLabelFont(labelFont);
        xAxis.setTickMarksVisible(false);
        final NumberAxis yAxis = new NumberAxis(yTitle);
        yAxis.setLabelFont(titleFont);
        yAxis.setTickLabelFont(labelFont);
        yAxis.setRange(122400,165000);
        final DecimalFormat formatter = new DecimalFormat("0.000");
        yAxis.setTickUnit(new NumberTickUnit(700));

        final IntervalBarRenderer renderer = new IntervalBarRenderer();
        renderer.setSeriesPaint(0,Color.RED);
//        renderer.setLabelGenerator(new IntervalCategoryLabelGenerator());
        renderer.setItemLabelsVisible(true);
        renderer.setItemLabelPaint(Color.white);
        final ItemLabelPosition p1 = new ItemLabelPosition(
            ItemLabelAnchor.CENTER, TextAnchor.CENTER
        );
        renderer.setPositiveItemLabelPosition(p1);
        
        final CategoryPlot plot = new CategoryPlot(data, xAxis, yAxis, renderer);
        plot.setBackgroundPaint(Color.YELLOW);
        plot.setOutlinePaint(Color.white);
        plot.setOrientation(PlotOrientation.VERTICAL);
        
        this.chart = new JFreeChart(title, titleFont, plot, false);
        this.chart.setBackgroundPaint(Color.white);
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
     * Returns the chart.
     *
     * @return the chart.
     */
    public JFreeChart getChart() {
        return this.chart;
    }

    /**
     * Starting point for the demo.
     *
     * @param args  ignored.
     * @throws IOException 
     */
    public static void main(final String[] args) throws IOException {
        final IntervalBarChartDemo1 sample = new IntervalBarChartDemo1();
        final JFreeChart chart = sample.getChart();
        final ChartFrame frame = new ChartFrame("Interval Bar Chart Demo", chart);
        frame.pack();
        frame.setVisible(true);
    }
}

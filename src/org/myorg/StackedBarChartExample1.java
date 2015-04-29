package org.myorg;
 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
/**
 * Stacked Bar Example, the data display on chart is dummy data not real data
 * @author putukus
 *
 */
public class StackedBarChartExample1 extends ApplicationFrame {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	/**
	 * Constructor
	 * @param titel
	 */
	StackedBarChartExample1(String titel) {
		super(titel);
 
		final CategoryDataset dataset = createDataset();
		final JFreeChart sbchart = createChart(dataset);
		final ChartPanel pnl = new ChartPanel(sbchart);
		pnl.setPreferredSize(new java.awt.Dimension(450, 350));
		setContentPane(pnl);
 
	}
 
 
	/**
	 * Create chart
	 * @param dataset
	 * @return
	 */
	private JFreeChart createChart(final CategoryDataset dataset) {
 
		final JFreeChart stackedChart = ChartFactory.createStackedBarChart("Stacked Bar Chart", "Category", "Value",
				dataset, PlotOrientation.VERTICAL, true, true, false);
 
		//create group 
		GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();
		KeyToGroupMap map = new KeyToGroupMap("G1");
		map.mapKeyToGroup("Toyota (US)", "G1");
		map.mapKeyToGroup("Toyota (Europe)", "G1");
		map.mapKeyToGroup("Toyota (Asia)", "G1");
 
		map.mapKeyToGroup("Ford (US)", "G2");
		map.mapKeyToGroup("Ford (Europe)", "G2");
		map.mapKeyToGroup("Ford (Asia)", "G2");
 
		map.mapKeyToGroup("BMW (US)", "G3");
		map.mapKeyToGroup("BMW (Europe)", "G3");
		map.mapKeyToGroup("BMW (Asia)", "G3");
		
		map.mapKeyToGroup("BMW (US)", "G4");
		map.mapKeyToGroup("BMW (Europe)", "G4");
		map.mapKeyToGroup("BMW (Asia)", "G4");
		
		
		
		map.mapKeyToGroup("BMW (US)", "G5");
		map.mapKeyToGroup("BMW (Europe)", "G5");
		map.mapKeyToGroup("BMW (Asia)", "G5");
		renderer.setSeriesToGroupMap(map);
		//margin between bar.
		renderer.setItemMargin(0.03);
		//end
 
		SubCategoryAxis dom_axis = new SubCategoryAxis("Car Production / Month");
		//Margin between group
		dom_axis.setCategoryMargin(0.06);
		//end
 
		dom_axis.addSubCategory("Toyota");
		dom_axis.addSubCategory("Ford");
		dom_axis.addSubCategory("BMW");
 
		CategoryPlot plot = (CategoryPlot) stackedChart.getPlot();
		plot.setDomainAxis(dom_axis);
		plot.setRenderer(renderer);
 
		return stackedChart;
	}
 
	public static void main(final String[] args) {
		final StackedBarChartExample1 example = new StackedBarChartExample1("Stacked Bar Chart");
		example.pack();
		RefineryUtilities.centerFrameOnScreen(example);
		example.setVisible(true);
	}
 
	/**
	 * Create dataset for chart in application usually get data from database
	 * with JDBC or collection
	 * 
	 * @return
	 */
	private CategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
 
		dataset.addValue(18.4, "Toyota (US)", "Jan 2011");
		dataset.addValue(22.3, "Toyota (US)", "Feb 2011");
		dataset.addValue(18.6, "Toyota (US)", "Mar 2011");
 
		dataset.addValue(16.5, "Toyota (Europe)", "Jan 2011");
		dataset.addValue(17.8, "Toyota (Europe)", "Feb 2011");
		dataset.addValue(19.5, "Toyota (Europe)", "Mar 2011");
		
		
	/*	dataset.addValue(15.3, "Toyota (Asia)", "Jan 2011");
		dataset.addValue(18.6, "Toyota (Asia)", "Feb 2011");
		dataset.addValue(14.4, "Toyota (Asia)", "Mar 2011");*/
 
		dataset.addValue(24.7, "Ford (US)", "Jan 2011");
		dataset.addValue(18.4, "Ford (US)", "Feb 2011");
		dataset.addValue(23.5, "Ford (US)", "Mar 2011");
 
		dataset.addValue(16.6, "Ford (Europe)", "Jan 2011");
		dataset.addValue(14.8, "Ford (Europe)", "Feb 2011");
		dataset.addValue(17.4, "Ford (Europe)", "Mar 2011");
 
		/*dataset.addValue(16.5, "Ford (Asia)", "Jan 2011");
		dataset.addValue(22.8, "Ford (Asia)", "Feb 2011");
		dataset.addValue(12.3, "Ford (Asia)", "Mar 2011");*/
 
		dataset.addValue(14.7, "BMW (US)", "Jan 2011");
		dataset.addValue(35.5, "BMW (US)", "Feb 2011");
		dataset.addValue(23.4, "BMW (US)", "Mar 2011");
 
		dataset.addValue(16.5, "BMW (Europe)", "Jan 2011");
		dataset.addValue(17.3, "BMW (Europe)", "Feb 2011");
		dataset.addValue(26.6, "BMW (Europe)", "Mar 2011");
		
		dataset.addValue(1.5, "BMW (Europe)", "Jan 2011");
		dataset.addValue(177.3, "BMW (Europe)", "Feb 2011");
		dataset.addValue(296.6, "BMW (Europe)", "Mar 2011");
 
/*		dataset.addValue(24.5, "BMW (Asia)", "Jan 2011");
		dataset.addValue(18.4, "BMW (Asia)", "Feb 2011");
		dataset.addValue(11.8, "BMW (Asia)", "Mar 2011");*/
 
		return dataset;
	}
 
}
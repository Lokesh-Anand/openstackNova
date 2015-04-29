package org.myorg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.JFileChooser;

import org.jfree.chart.ChartPanel;
import org.myorg.*;



public class gui {

private JFrame mainFrame;
  private JLabel headerLabel;
  private JLabel statusLabel;
  private JPanel controlPanel;
  String fname="";
  Font fnt = new Font("Times New Roman", Font.BOLD,20);
  public gui(){
     prepareGUI();
  }
  public static void main(String[] args){
     gui swingControlDemo = new gui();  
     swingControlDemo.showEventDemo();       
  }
  
  private void prepareGUI(){
     mainFrame = new JFrame("Log Analysis of Openstack");
     mainFrame.setSize(700,700);
     mainFrame.setLayout(new GridLayout(3, 1));
     
     
     headerLabel = new JLabel("",JLabel.CENTER );
     headerLabel.setFont(fnt);
     statusLabel = new JLabel("",JLabel.CENTER);        

     statusLabel.setSize(350,100);
     mainFrame.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent windowEvent){
       System.exit(0);
        }        
     });    
     controlPanel = new JPanel();
     controlPanel.setLayout(null);
     //controlPanel.setBackground(Color.WHITE);

     mainFrame.add(headerLabel);
     mainFrame.add(controlPanel);
     mainFrame.add(statusLabel);
     mainFrame.setVisible(true);  
  }

  private void showEventDemo(){
     headerLabel.setText("Log Analysis of Openstack"); 
     //headerLabel.setBounds(0, 0,175, 40);
     headerLabel.setLocation(10, 10);

     JButton okButton = new JButton("Display reference File");     
     okButton.setActionCommand("Display reference File");
     okButton.addActionListener(new ButtonClickListener()); 
     okButton.setBounds(220, 0, 250, 40);
      controlPanel.add(okButton);
      
      JButton okButton1 = new JButton("Browse and Upload Log FILE");     
     okButton1.setActionCommand("Browse and Upload");
     okButton1.addActionListener(new ButtonClickListener()); 
     okButton1.setBounds(220, 60, 250, 40);
      controlPanel.add(okButton1);
      
      JButton okButton2 = new JButton("Analyse");     
     okButton2.setActionCommand("Cluster and Analyse");
     okButton2.addActionListener(new ButtonClickListener()); 
     okButton2.setBounds(220, 120, 250, 40);
      controlPanel.add(okButton2);
      
      JButton okButton3 = new JButton("Results");     
     okButton3.setActionCommand("Statistics");
     okButton3.addActionListener(new ButtonClickListener()); 
     okButton3.setBounds(220, 180, 250, 40);
      controlPanel.add(okButton3);
           mainFrame.setVisible(true);  
  }
  
  

  private class ButtonClickListener implements ActionListener{
     public void actionPerformed(ActionEvent e) {
   	
        String command = e.getActionCommand();  
        if( command.equals( "Display reference File" ))  {
           //statusLabel.setText("Display reference File");
           
          
        // Create columns names
   	String columnNames[] = { "Filename", "Method", "Level", "Message Signature", "Unique ID" };
   	try
   	{
   	String dataValues[][] = new String [2000][5];
   	
   	FileReader f = new FileReader("/home/hduser/Downloads/FINAL_REFERENCE8.csv");
           BufferedReader b = new BufferedReader(f);
           String t="";
for(int j=0;(t = b.readLine()) != null;j++)
{
String tmp[]=t.split(",");
for(int i=0;i<tmp.length;i++)
{
if(i!=4)
{
if(i==5)
dataValues[j][i-1] = tmp[i];
else
dataValues[j][i] = tmp[i];	
}
}
}
   	
   	
   	
   	// Create a JTable and tell it to display our model
           //JTable table = new JTable(model);
   	JTable  table = new JTable( dataValues, columnNames );
   	JTableHeader header = table.getTableHeader();
	   header.setBackground(Color.black);
	   header.setForeground(Color.LIGHT_GRAY);
	   
	   header.setFont(new Font("Times New Roman", Font.BOLD,15));
	table.setForeground(Color.black);
	table.getColumn("Level").setCellRenderer(new Setcolor());
           // Display it all in a scrolling window and make the window appear
           JFrame frame = new JFrame("Parsed Code Reference File");
           
           //frame.getContentPane().setLayout( new BorderLayout() );
           frame.getContentPane().add(new JScrollPane(table));
         
           frame.setSize(600, 400);
           frame.setVisible(true);
   	
   	
   	}
   	catch(FileNotFoundException ex) {
               	
           }
           catch(IOException ex) {
               
           }
           
           
           
        }
        else if( command.equals( "Browse and Upload" ) )  {
       	 
       	JFileChooser fileChooser = new JFileChooser();
       	fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
       	int result = fileChooser.showOpenDialog(fileChooser);
       	if (result == JFileChooser.APPROVE_OPTION) {
       	    File selectedFile = fileChooser.getSelectedFile();
       	    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
       	    fname=selectedFile.getAbsolutePath();
       	    //fname=fname.replaceAll("\\","\\\\");
       	    statusLabel.setText("Following file selected: " +fname);
       	}
           
        }
        else if( command.equals( "Cluster and Analyse" ) )  {
        	
        	String arg[]={fname,"hdfs://localhost:54310/user/noutput/85"};
        	String arg1[]={"hdfs://localhost:54310/user/noutput/85/part-r-00000","/home/hduser/sample/85/"};
        	String arg2[]={"/home/hduser/sample/85/part-r-00000",fname};
        	Wordcount wc = new Wordcount();
        	match mt=new match();
        	cosineprepro cs= new cosineprepro();
        	
        	try
        	{
        	wc.main(arg);
        	mt.main(arg1);
        	cs.main(arg2);
        	JOptionPane.showMessageDialog(null," Map Reduce Jobs Successfully Executed");
        	}
        	catch(Exception ex)
        	{
        		
        	}
        	
           
        }
        else  {
        	String columnNames[] = { "Request ID","Flow","Status","Details"};
           	String dataValues[][]= new String[125][4];
           	String line="";
          	try{
	        	FileReader f10 =  new FileReader("/home/hduser/res.txt");
	    		BufferedReader f12 = new BufferedReader(f10);
	    		for(int i=0;(line=f12.readLine()) != null ;i++)
	            {
	    			String tmp[]=line.split(",");
	    			for(int j=0;j<tmp.length;j++)
	    			{
	    				tmp[j]=tmp[j].replaceAll("suc", "");
	    				tmp[j]=tmp[j].replaceAll("fail", "");
	    			dataValues[i][j]=tmp[j];
	    			}
	            }
           	}
           	catch(Exception ex)
           	{
           		
           	}
           	
           	
           	final	JTable  table = new JTable( dataValues, columnNames );
       		JTableHeader header = table.getTableHeader();
       	   header.setBackground(Color.black);
       	   header.setForeground(Color.LIGHT_GRAY);
       	   Font fnt = new Font("Times New Roman", Font.BOLD,15);
       	   header.setFont(fnt);
       	   table.setForeground(Color.black);
       	
       	table.getColumn("Details").setCellRenderer(new ButtonRenderer());
       	table.getColumn("Status").setCellRenderer(new Setcolor());
       	
       	table.addMouseListener(new java.awt.event.MouseAdapter()
       	{
       		public void mouseClicked(java.awt.event.MouseEvent e)
       		{

       			int row=table.rowAtPoint(e.getPoint());

       			int col= table.columnAtPoint(e.getPoint());
       			
       			if(col==3 && table.getValueAt(row, col-1).toString().trim().contains("Fail"))
       			{
       			//JOptionPane.showMessageDialog(null," Value in the cell clicked :"+table.getValueAt(row, 0));
       			
       	       	JFrame frame1 = new JFrame("Results");
                 frame1.getContentPane().setBackground(Color.WHITE); 
                frame1.setSize(600, 400);
                frame1.setVisible(true);
       			System.out.println(" Value in the cell clicked :");
       			Font fnt = new Font("Times New Roman", Font.BOLD,15);
       			
       			String ht="";
       			try{
       				FileReader f = new FileReader("/home/hduser/res13.html");
                    BufferedReader b = new BufferedReader(f);
                    ht = b.readLine();
                    //ht=ht.replaceAll("\\n"," ");
             	  System.out.println(ht);
       				
       			}
       			catch(Exception ex)
       			{
       				
       			}
       			JLabel l = new JLabel(ht,JLabel.CENTER);
       			//JLabel l2 = new JLabel("<html>Stages completed:<br/>Claiming Resources<br/>Ensuring static filters<br/>Filtering<br/>Weighing<br/></html>",JLabel.CENTER);
       			//JLabel l1= new JLabel("<html>Host (param) fails. Previously tried hosts:  (param)<br/>Filter <param> returned  (param) host(s)<br/>Setting instance to (param) state.</html>",JLabel.CENTER);
       			l.setSize(200, 40);
       			//l1.setSize(200, 150);
       			//l2.setSize(200, 100);
       			
       			
       			l.setLocation(100,40);
       			
       			//l1.setLocation(20, 340);
       			//l2.setLocation(100, 70);
       			l.setFont(fnt);
       			l.setBackground(Color.LIGHT_GRAY);
       			l.setForeground(Color.BLACK);
       			//l1.setForeground(Color.RED);
       			//l2.setForeground(Color.green);
       			JScrollPane scroller = new JScrollPane(l, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       			frame1.getContentPane().add(scroller); 
       			//frame1.getContentPane().add(l2);
       			//frame1.getContentPane().add(l1);
       			}
       	}});
       	
       	
               // Display it all in a scrolling window and make the window appear
               JFrame frame = new JFrame("FileTableDemo");
              
               chart demo = new chart("Flows", "Use Cases");
               ChartPanel chartPanel=demo.retchart();
               BorderLayout bdr = new BorderLayout();
               //bdr.CENTER;
               frame.getContentPane().add(new JScrollPane(table),bdr.CENTER);
               frame.getContentPane().add(chartPanel,bdr.PAGE_START);
               frame.setSize(500,500);
               frame.setVisible(true);
           
        }  	
     }	
  }
  
  public class Setcolor
  extends DefaultTableCellRenderer {
public Component getTableCellRendererComponent(JTable table,
                                            Object value,
                                            boolean isSelected,
                                            boolean hasFocus,
                                            int row,
                                            int column) {
Component c = 
 super.getTableCellRendererComponent(table, value,
                                     isSelected, hasFocus,
                                     row, column);

// Only for specific cell
Font fnt = new Font("Times New Roman", Font.BOLD,12);
c.setFont(fnt);
if (table.getValueAt(row, column).toString().trim().contains("Fail")) 
  c.setForeground(Color.RED);
  else if(table.getValueAt(row, column).toString().trim().contains("warn"))
c.setForeground(Color.ORANGE);  
  else if(table.getValueAt(row, column).toString().trim().contains("debug"))
	  c.setForeground(Color.BLUE);
  else if(table.getValueAt(row, column).toString().trim().contains("error"))
	  c.setForeground(Color.RED);
  else
	  c.setForeground(Color.GREEN);  
  

return c;
}
}
  
  public class ButtonRenderer extends JButton implements TableCellRenderer {
	  
	  public ButtonRenderer() {
	    setOpaque(true);
	  }
	   JLabel l = new JLabel("-");
	  public Component getTableCellRendererComponent(JTable table, Object value,
	                   boolean isSelected, boolean hasFocus, int row, int column) {
	    if (isSelected) {
	      setForeground(table.getSelectionForeground());
	      setBackground(table.getSelectionBackground());
	    } else{
	      setForeground(table.getForeground());
	      setBackground(UIManager.getColor("Button.background"));
	    }
	    if(table.getValueAt(row, column-1).toString().trim().contains("Fail"))
	    {
	    	setText("Show");
	    	
		    return this;
	    	
	    
	    }
	    else
	    {
	    	return l;
	    }
	   
	  }
	}
 
  
  
  
}
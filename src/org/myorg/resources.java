package org.myorg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class resources {

public static void main(String[] args) {

    JFrame frame = new JFrame("RESOURCE");
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setLocation(430, 100);

    JPanel panel = new JPanel();

    frame.add(panel);

    JLabel lbl = new JLabel("Select one of the possible choices and click OK");
    lbl.setVisible(true);

    panel.add(lbl);

    String[] choices = { "MEMORY","CPU"};

    final JComboBox<String> cb = new JComboBox<String>(choices);
    
    //System.out.println(t);
    cb.setVisible(true);
    panel.add(cb);

    JButton btn = new JButton("OK");
    panel.add(btn);
    
    btn.addActionListener(new ActionListener(){
        @Override
        
        public void actionPerformed(ActionEvent ev) {
        	int t=cb.getSelectedIndex();
        	if(t==0)
        	{JFrame frame = new JFrame("RESOURCE USAGE");
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);
            frame.setLocation(430, 100);
            JPanel panel = new JPanel();
            residentifier i=new residentifier();
            List<String> list1 = new ArrayList<String>();
            try {
				list1=i.main(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            frame.add(panel);
            JLabel lbl = new JLabel("FLOWS USING THIS RESOURCE ARE\n");
            lbl.setVisible(true);
            panel.add(lbl);
            for(String z:list1)
            {JLabel lbl1 = new JLabel(z+"\n");
            lbl1.setVisible(true);
            panel.add(lbl1);
            }
            
            }
        }

    });
}
}
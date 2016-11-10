import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Event extends Calendar{
	private JPanel o;
	private JFrame frm;
	private JComboBox months;
	private String[] monthStrings = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	public static final int PROGRAM_WIDTH = 480;
	public static final int PROGRAM_HEIGHT = 640;
	
	public void drawPanel(){ 
		o.setPreferredSize(new Dimension(PROGRAM_WIDTH, PROGRAM_HEIGHT));
		months = new JComboBox(monthStrings);
		months.setSelectedIndex(12);
		months.addActionListener((ActionListener) this);
		o.add(months, BorderLayout.EAST);
	}
	

}

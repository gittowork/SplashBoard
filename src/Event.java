import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Event extends Calendar{
	private JPanel o;
	private JFrame frm;
	private JComboBox months;
	private JComboBox days;
	private JComboBox year;
	private GButton back;
	private GButton add;
	private String title = new String("Event");
	private String[] monthStrings = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	private String[] dayints = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	public static final int PROGRAM_WIDTH = 480;
	public static final int PROGRAM_HEIGHT = 640;
	
	public void drawPanel(){ 
		o.setPreferredSize(new Dimension(PROGRAM_WIDTH, PROGRAM_HEIGHT));
		months = new JComboBox(monthStrings);
		months.setSelectedIndex(12);
		months.addActionListener((ActionListener) this);
		days = new JComboBox(dayints);
		days.setSelectedIndex(10);
		days.addActionListener((ActionListener) this);
		o.add(months, BorderLayout.EAST);
		o.add(days, BorderLayout.EAST);
		o.add(title, BorderLayout.BEFORE_FIRST_LINE);
		o.add(years, BorderLayout.WEST);
		
	}
	

}

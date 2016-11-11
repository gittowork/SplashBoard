import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Event extends Calendar{
	private JPanel o;
	private JFrame frm;
	private JComboBox months;
	private JComboBox<Integer> days;
	private JComboBox year;
	private JLabel title = new JLabel("Event");
	private String[] monthStrings = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	public static final int PROGRAM_WIDTH = 480;
	public static final int PROGRAM_HEIGHT = 640;
	
	public static void main(String[] args){
		java.awt.EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				Event t = new Event();
				t.drawPanel();
			}
		});

	}
	
	public void drawPanel(){ 
		for(int i = 1; i < 31; i++){
			days.addItem(i);
		}
		frm.add(o, BorderLayout.CENTER);
		o.setPreferredSize(new Dimension(PROGRAM_WIDTH, PROGRAM_HEIGHT));
		months = new JComboBox(monthStrings);
		months.setSelectedIndex(12);
		months.addActionListener((ActionListener) this);
		days.setSelectedIndex(10);
		days.addActionListener((ActionListener) this);
		/*o.add(months, BorderLayout.EAST);
		o.add(days, BorderLayout.EAST);
		o.add(title, BorderLayout.BEFORE_FIRST_LINE);*/
		frm.setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		frm.pack();
		frm.setVisible(true);
	}
	

}

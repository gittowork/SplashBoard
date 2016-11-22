import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Event extends CalendarClass{
	private JPanel o;
	private JPanel m;
	private JPanel s;
	private JPanel t;
	private JFrame frm;
	private JComboBox months;
	private JComboBox days;
	private JComboBox years;
	private JTextArea text;
	private JTextArea ta;
	private JButton back;
	private JButton confirm;
	private JComboBox hour;
	private JComboBox min;
	//private JTextField 
	private JLabel title = new JLabel("Event:");
	private JLabel Description = new JLabel("Description");
	private String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
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
		days = new JComboBox();	
		days.addItem("Days");;
		for(int i= 1; i < 32; i++){
			days.addItem(i);
		}
		years = new JComboBox();
		years.addItem("Year");
		for(int i = 2016; i < 2022; i++){
			years.addItem(i);
		}
		hour = new JComboBox();
		hour.addItem("Hr");
		for(int i = 1; i < 13; i++){
			hour.addItem(i);
		}
		min = new JComboBox();
		min.addItem("Min");
		for(int i = 1; i < 61; i++){
			min.addItem(i);
		}
		o = new JPanel();
		o.setPreferredSize(new Dimension(480, 120));
		s =  new JPanel();
		s.setPreferredSize(new Dimension(480, 120));
		//m = new JPanel();
		//m.setPreferredSize(new Dimension(480, 400));
		t = new JPanel();
		t.setPreferredSize(new Dimension(480, 50));
		months = new JComboBox();
		months.addItem("Month");
		for(int i = 0; i < 12; i++){
			months.addItem(month[i]);
		}
		title.setForeground(Color.BLUE);
		//Description.setForeground(Color.blue);
		//Description.setHorizontalAlignment(JLabel.CENTER);
		text = new JTextArea(5, 20);
		//ta = new JTextArea(5, 20);
		//ta.setPreferredSize(new Dimension(450, 300));
		JScrollPane scrollpane = new JScrollPane(t);
		//ta.setLineWrap(true);
		back = new JButton("Back");
		back.setVerticalTextPosition(AbstractButton.CENTER);
		back.setForeground(Color.BLUE);
		confirm = new JButton("Confirm");
		confirm.setVerticalTextPosition(AbstractButton.CENTER);
		confirm.setForeground(Color.BLUE);
		o.add(title, BorderLayout.WEST);
		o.add(text, BorderLayout.CENTER);
		s.add(days, BorderLayout.WEST);
		s.add(months, BorderLayout.CENTER);
		s.add(years, BorderLayout.EAST);
		s.add(hour, BorderLayout.SOUTH);
		s.add(min, BorderLayout.SOUTH);
		t.add(back, BorderLayout.WEST);
		t.add(confirm, BorderLayout.EAST);
		//m.add(Description, BorderLayout.NORTH);
		//m.add(ta, BorderLayout.CENTER);
		//m.add(t, BorderLayout.SOUTH);
		//m.setBackground(Color.CYAN);
		t.setBackground(Color.GRAY);
		s.setBackground(Color.GRAY);
		frm = new JFrame("Add Event");
		frm.add(o, BorderLayout.NORTH);
		frm.add(s, BorderLayout.CENTER);
		frm.add(t, BorderLayout.SOUTH);
		//frm.add(back, BorderLayout.SOUTH);
		frm.setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		frm.pack();
		frm.setVisible(true);
	}
	

}


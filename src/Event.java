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
		o = new JPanel();
		o.setPreferredSize(new Dimension(200, 50));
		s =  new JPanel();
		s.setPreferredSize(new Dimension(200, 50));
		m = new JPanel();
		m.setPreferredSize(new Dimension(200, 100));
		t = new JPanel();
		t.setPreferredSize(new Dimension(50, 50));
		months = new JComboBox();
		months.addItem("Month");
		for(int i = 0; i < 12; i++){
			months.addItem(month[i]);
		}
		title.setForeground(Color.BLUE);
		Description.setForeground(Color.blue);
		text = new JTextArea(1, 20);
		ta = new JTextArea(5, 20);
		JScrollPane scrollpane = new JScrollPane(ta);
		back = new JButton("Back");
		back.setVerticalTextPosition(AbstractButton.CENTER);
		back.setForeground(Color.BLUE);
		back.setBounds(40, 20, PROGRAM_WIDTH - 1, 0);
		o.add(title, BorderLayout.WEST);
		o.add(text, BorderLayout.CENTER);
		s.add(days, BorderLayout.WEST);
		s.add(months, BorderLayout.CENTER);
		s.add(years, BorderLayout.EAST);
		//t.add(back, BorderLayout.WEST);
		m.add(Description, BorderLayout.NORTH);
		m.add(ta, BorderLayout.CENTER);
		m.add(back, BorderLayout.SOUTH);
		m.setBackground(Color.MAGENTA);
		frm = new JFrame("Add Event");
		frm.add(o, BorderLayout.NORTH);
		frm.add(s, BorderLayout.CENTER);
		frm.add(m, BorderLayout.SOUTH);
		//frm.add(back, BorderLayout.SOUTH);
		frm.setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		frm.pack();
		frm.setVisible(true);
	}
	

}


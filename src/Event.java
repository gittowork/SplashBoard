import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

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

public class Event implements ActionListener{
	private JPanel o;
	private JPanel m;
	private JPanel s;
	private JPanel t;
	private JFrame frm;
	private JFrame pop1;
	private int filecount = 1;
	protected JComboBox months;
	protected JComboBox days;
	protected JComboBox years;
	protected JTextArea text;
	protected JTextArea ta;
	protected JButton back;
	protected JButton confirm;
	protected JComboBox hour;
	protected JComboBox min;
	protected JComboBox meridium;
	private CalSave w = new CalSave();
	private HashMap<String, String> hm;
	private int y;
	private int h;
	private String mi;
	private String md;
	private int d;
	private String mt;
	private String f;
	String z = null;
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
		//adding the days to the combo box
		days = new JComboBox();	
		days.addItem("Day");;
		for(int i= 1; i < 32; i++){
			days.addItem(i);
		}
		//adding 5 years to the combo box
		years = new JComboBox();
		years.addItem("Year");
		for(int i = 2016; i < 2022; i++){
			years.addItem(i);
		}
		//adding the hours to the combo box
		hour = new JComboBox();
		hour.addItem("Hr");
		for(int i = 1; i < 13; i++){
			hour.addItem(i);
		}
		//adding the minutes to the combo box
		min = new JComboBox();
		min.addItem("Min");
		for(int i = 0; i < 60; i++){
			if(i < 10){
				String l = "0" + i;
				min.addItem(l);
			}
			else{
				String l = "" + i;
				min.addItem(i);
			}
		}
		meridium = new JComboBox();
		meridium.addItem("AM");
		meridium.addItem("PM");
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
		JScrollPane scrollpane = new JScrollPane(text);
		text.setLineWrap(true);
		back = new JButton("Cancel");
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
		s.add(meridium, BorderLayout.SOUTH);
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
		
		months.addActionListener(this);
		days.addActionListener(this);
		years.addActionListener(this);
		hour.addActionListener(this);
		min.addActionListener(this);
		meridium.addActionListener(this);
		
		confirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
		        mt = (String)months.getSelectedItem();
		        d = (int)days.getSelectedItem();
		        y = (int)years.getSelectedItem();
		        h = (int)hour.getSelectedItem();
		        mi = (String)min.getSelectedItem();
		        md = (String)meridium.getSelectedItem();
		        
		        f = text.getText();
		        
		        w.month = mt;
		        w.day = d;
		        w.year = y;
		        w.hr = h;
		        w.min = mi;
		        w.meridium = md;
		        w.event = f;
				save();
				modify();
				frm.dispose();
			}
		});
		
		
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frm.dispose();
			}
		});
	}

	public String event(){
		return f;
	}
		
	public void save(){
		hm = new HashMap<String, String>();
		String n = filecount + ".ser";
		hm.put(f, n);
		
		
		try{
			FileOutputStream fileOut = new FileOutputStream(n);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(w);
		out.close();
		fileOut.close();
		System.out.println("Serialized data saved");
		}catch(IOException i){
			i.printStackTrace();
		}
		filecount++;
	}

	
	public void popwindow(){
		JFrame pop1 = new JFrame();
		pop1.setPreferredSize(new Dimension(400, 200));
		JPanel p4 = new JPanel();
		JLabel saved = new JLabel("Event Saved!");
		saved.setFont(new Font("Calibri", Font.PLAIN, 40));
		p4.add(saved);
		JButton confirm = new JButton("OK");
		JPanel p5 = new JPanel();
		p5.add(confirm);
		pop1.getContentPane().add(p5, BorderLayout.SOUTH);
		pop1.getContentPane().add(p4, BorderLayout.CENTER);
		pop1.pack();
		pop1.setVisible(true);
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pop1.dispose();
				
			}
			
		});
		
	}
	
	public void deserialize(){
		hm.get(f);
		String file = hm.get(f);
		w = null;
		try{
			FileInputStream fileIn =  new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			w = (CalSave) in.readObject();
			in.close();
			fileIn.close();
		}catch(IOException i){
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c){
			System.out.println("CalSave class not found");
			c.printStackTrace();
			return;
		}
		System.out.println("event: " + w.event);
		System.out.println("day: " + w.day);
		f = w.event;
		d = w.day;
		h = w.hr;
		y = w.year;
		mi = w.min;
		md = w.meridium;
		mt = w.month;
		
	}
	
	public void modify(){
		deserialize();
		JFrame pop2 = new JFrame();
		pop2.setPreferredSize(new Dimension(450, 450));
		JPanel p4 = new JPanel();
		p4.setPreferredSize(new Dimension(200, 200));
		JLabel load = new JLabel("Event:" + f);
		load.setFont(new Font("Calibri", Font.PLAIN, 40));
		p4.add(load);
		JButton ok = new JButton("OK");
		JButton modify = new JButton("Edit");
		JPanel p5 = new JPanel();
		p5.setPreferredSize(new Dimension(50, 50));
		p5.add(modify);
		p5.add(ok);
		JPanel p6 = new JPanel();
		p6.setPreferredSize(new Dimension(200, 200));
		JLabel d1 = new JLabel("Date: " + mt + d + ", " + y);
		JLabel d2 = new JLabel("Time: " + h + ":" + mi);
		p6.add(d1, BorderLayout.SOUTH);
		p6.add(d2, BorderLayout.CENTER);
		pop2.getContentPane().add(p5, BorderLayout.SOUTH);
		pop2.getContentPane().add(p6, BorderLayout.CENTER);
		pop2.getContentPane().add(p4, BorderLayout.NORTH);
		pop2.pack();
		pop2.setVisible(true);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pop2.dispose();
				
			}
			
		});
		modify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pop2.dispose();
				
			}
			
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}


	
}


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
	//CalendarClass c = new CalendarClass();;
	String z = null;
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
				//t.drawPanel();
			}
		});

	}
	
	public void drawPanel(int day, int year, int m1){ 
		String num = "" + day;
		int num2 = m1;
		String m2 = month[num2];
		String num3 = "" + year;
		JLabel t1 = new JLabel(num + ", ");
		JLabel t2 = new JLabel(m2);
		JLabel t3 = new JLabel(num3);
		t1.setForeground(Color.WHITE);
		t2.setForeground(Color.WHITE);
		t3.setForeground(Color.WHITE);
		
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

		title.setForeground(Color.BLUE);
		text = new JTextArea(5, 20);
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
		s.add(t2, BorderLayout.WEST);
		s.add(t1, BorderLayout.CENTER);
		s.add(t3, BorderLayout.EAST);
		s.add(hour, BorderLayout.SOUTH);
		s.add(min, BorderLayout.SOUTH);
		s.add(meridium, BorderLayout.SOUTH);
		t.add(back, BorderLayout.WEST);
		t.add(confirm, BorderLayout.EAST);
		t.setBackground(Color.GRAY);
		s.setBackground(Color.GRAY);
		frm = new JFrame("Add Event");
		frm.add(o, BorderLayout.NORTH);
		frm.add(s, BorderLayout.CENTER);
		frm.add(t, BorderLayout.SOUTH);
		frm.setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		frm.pack();
		frm.setVisible(true);
		
		
		hour.addActionListener(this);
		min.addActionListener(this);
		meridium.addActionListener(this);
		
		confirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
		        h = (int)hour.getSelectedItem();
		        mi = (String)min.getSelectedItem();
		        md = (String)meridium.getSelectedItem();
		        
		        f = text.getText();
		        
		        w.month = m2;
		        w.day = day;
		        w.year = year;
		        w.hr = h;
		        w.min = mi;
		        w.meridium = md;
		        w.event = f;
				save();
				eventScreen(f);
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
	
	public void deserialize(String event){
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
	
	public void eventScreen(String event){
		deserialize(event);
		JFrame pop2 = new JFrame();
		pop2.setPreferredSize(new Dimension(450, 450));
		JPanel p4 = new JPanel();
		p4.setPreferredSize(new Dimension(200, 200));
		JLabel load = new JLabel("Event:" + f);
		load.setFont(new Font("Calibri", Font.PLAIN, 40));
		p4.add(load);
		JButton ok = new JButton("OK");
		//JButton modify = new JButton("Edit");
		JPanel p5 = new JPanel();
		p5.setPreferredSize(new Dimension(50, 50));
		//p5.add(modify);
		p5.add(ok);
		JPanel p6 = new JPanel();
		p6.setPreferredSize(new Dimension(200, 200));
		JLabel d1 = new JLabel("Date: " + mt + " " + d + ", " + y);
		d1.setFont(new Font("Calibri", Font.PLAIN, 40));
		JLabel d2 = new JLabel("Time: " + h + ":" + mi);
		d2.setFont(new Font("Calibri", Font.PLAIN, 40));
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

		
	}
	
	public void delete(String event){
		JFrame pop3 = new JFrame();
		pop3.setPreferredSize(new Dimension(100, 100));
		JLabel q = new JLabel("Do you wish to delete this event permenantly?");
		JPanel b = new JPanel();
		b.add(back);
		b.add(confirm);
		pop3.add(q, BorderLayout.CENTER);
		pop3.add(b, BorderLayout.SOUTH);
		pop3.pack();
		pop3.setVisible(true);
		confirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				hm.remove(event);
				pop3.dispose();
				JFrame n = new JFrame();
				n.setPreferredSize(new Dimension(100, 100));
				JLabel r = new JLabel("The event (" + event + ") was permenantly deleted.");
				JButton c = new JButton("Ok");
				n.add(r, BorderLayout.NORTH);
				n.add(c, BorderLayout.SOUTH);
				n.pack();
				n.setVisible(true);
				c.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						n.dispose();
						
					}
					
				});
		}
		});
		
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pop3.dispose();
		
		}
		});
		
	}
	
	public void Screen(String event){
		eventScreen(event);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}


	
}


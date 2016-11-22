import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;


public class CalendarClass  extends GraphicsProgram{

protected int month;
protected int day;
private int year; 
protected int startmin;
protected int starthour;
protected int endmin;
protected int endhour;
//protected String back;
protected String title;
protected String description;
protected Boolean allday;
protected Boolean meridian;
protected int ysHeight = 600;
protected int ysWidth = 600;
protected int msHeight = 600;
protected int msWidth = 600;
protected int dsHeight = 600;
protected int dsWidth = 600;
protected int PROGRAM_HEIGHT = 600;
protected int PROGRAM_WIDTH = 800;
private static final int subdivisionsYyear = 3;
private static final int subdivisionsXyear = 3;
private static final int subdivisionsYmonth = 3;
private static final int subdivisionsXmonth = 4;
private static final int subdivisionsYday = 5;
private static final int subdivisionsXday = 6;
private JFrame frame;

private JButton back;
private JButton add;
private JButton go2; //when clicking here on yearScreen, will open up month and day panels of that year 
private GLine newline;


public static void main(String[] args){
	java.awt.EventQueue.invokeLater(new Runnable(){
	@Override
	public void run(){
	CalendarClass c = new CalendarClass();
//	c.yearScreen();
	c.monthScreen();
//	c.dayScreen();


	}});
}

public void addPanel(){	//wanted to see if this created a grid of JLabel
	int i = 3;
	int j = 4;
	JPanel[][] panelHolder = new JPanel[i][j];
	setLayout(new GridLayout(i,j));
	
	for(int m = 0; m < i; m++){
		for(int n = 0; n < j; n++){
			add(panelHolder[m][n]);
		}
	}
	panelHolder[2][3].add(new JLabel("Test"));
}

public void testGrid(){ // another test to try a grid layout
	JFrame frame = new JFrame("Test");
	JPanel panel = new JPanel();
	panel.setPreferredSize(new Dimension(ysHeight, ysWidth));
	panel.setLayout(new GridLayout(3,3,1,1));
	JLabel component = new JLabel("Test");
	panel.add(component, 0, 0);
	
	frame.pack();
	frame.setVisible(true);
}

public void yearScreen(){
	JFrame frame = new JFrame("Year");
	
	
	
	JPanel panel = new JPanel(){
	
	@Override public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 1; i < subdivisionsXyear; i++) {
            int x = i * ysHeight/subdivisionsXyear;
            g2.drawLine(x, 0, x, getSize().height);
         }
		for (int i = 1; i < subdivisionsYyear; i++) {
            int y = i * ysHeight/subdivisionsYyear;
            g2.drawLine(0, y, getSize().width, y);
         }	
	}	// add sequencing of the days
	};	// look for date class, gives current day
	
	panel.setPreferredSize(new Dimension(ysHeight, ysWidth));
	panel.setLayout(new GridLayout(3,3,150,150));
	JLabel component = new JLabel("2016");
	JLabel component1 = new JLabel("2017");
	JLabel component2 = new JLabel("2018");
	JLabel component3 = new JLabel("2019");
	JLabel component4 = new JLabel("2020");
	JLabel component5 = new JLabel("2021");
	JLabel component6 = new JLabel("2022");
	JLabel component7 = new JLabel("2023");
	JLabel component8 = new JLabel("2024");
	panel.add(component8, 0, 0);			//the reason these are out of order is due to the way I ordered the row and columns, and also how the GridLayout function works
	panel.add(component7, 1, 0);
	panel.add(component, 2, 0);
	panel.add(component5, 0, 1);
	panel.add(component6, 0, 2);
	panel.add(component3, 1, 1);
	panel.add(component4, 1, 2);
	panel.add(component1, 2, 1);
	panel.add(component2, 2, 2);
	
	frame.getContentPane().add(panel ,BorderLayout.CENTER);
	//newline = new GLine(0, 0, 100, 100);
	//panel.add(newline);
	//g.drawLine(0, 0, 100, 100);
	//newline.setVisible(true);
	addActionListeners();
	addButtons();
	frame.pack();
	frame.setVisible(true);
	
	
	
	
	
	


	//pop up for displaying the year on separate screen
	
}
//Empty Square first
// Draw circle, make circle move in a larger circle
// Draw another circle, have it move in a larger radius circle





public int getData(){
	// unsure of what this is going to return as of now
	return 0;
}

public void monthScreen(){
	
	//appears simultaneously with dayScreen on identical panels
	JFrame frame = new JFrame("Month");
	
	
	
	JPanel panel = new JPanel(){
	
	@Override public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 1; i < subdivisionsXmonth; i++) {
            int x = i * ysHeight/subdivisionsXmonth;
            g2.drawLine(x, 0, x, getSize().height);
         }
		for (int i = 1; i < subdivisionsYmonth; i++) {
            int y = i * ysHeight/subdivisionsYmonth;
            g2.drawLine(0, y, getSize().width, y);
         }	
	}	// add sequencing of the days
	};	// look for date class, gives current day
	
	frame.setPreferredSize(new Dimension(msHeight, msWidth));
	frame.getContentPane().add(panel ,BorderLayout.CENTER);
	panel.setLayout(new GridLayout(3,4,100,100));
	JLabel component = new JLabel("January");
	JLabel component1 = new JLabel("February");
	JLabel component2 = new JLabel("March");
	JLabel component3 = new JLabel("April");
	JLabel component4 = new JLabel("May");
	JLabel component5 = new JLabel("June");
	JLabel component6 = new JLabel("July");
	JLabel component7 = new JLabel("August");
	JLabel component8 = new JLabel("September");
	JLabel component9 = new JLabel("October");
	JLabel component10 = new JLabel("November");
	JLabel component11 = new JLabel("December");
	panel.add(component11, 0, 0);
	panel.add(component10, 1, 0);
	panel.add(component3, 2, 0);
	panel.add(component8, 0, 1);
	panel.add(component9, 0, 2);
	panel.add(component6, 1, 1);
	panel.add(component7, 1, 2);
	panel.add(component4, 2, 1);
	panel.add(component5, 2, 2);
	panel.add(component, 3, 0);
	panel.add(component1, 3, 1);
	panel.add(component2, 3, 2);
	
	
	addActionListeners();
	addButtons();
	frame.pack();
	frame.setVisible(true);
	
	
}

public void removeEvent(){
	
	// going to remove an event from our method of storing events
}

public void dayScreen(){
	
	//appears simultaneously with dayScreen on identical panels
	JFrame frame = new JFrame("Day");
	JLabel label = new JLabel("String");
	
	
	JPanel panel = new JPanel(){
	
	@Override public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 1; i < subdivisionsXday; i++) {
            int x = i * ysHeight/subdivisionsXday;
            g2.drawLine(x, 0, x, getSize().height);
         }
		for (int i = 1; i < subdivisionsYday; i++) {
            int y = i * ysHeight/subdivisionsYday;
            g2.drawLine(0, y, getSize().width, y);
         }	
	}	// add sequencing of the days
	};	// look for date class, gives current day
	
	frame.setPreferredSize(new Dimension(dsHeight, dsWidth));
	frame.getContentPane().add(panel ,BorderLayout.CENTER);
	panel.setLayout(new GridLayout(3,3,150,150));

	addActionListeners();
	addButtons();
	frame.pack();
	frame.setVisible(true);
	
}

public void addImages(){
	
	//at this point, unknown as to what images will be added
}

public void addButtons(){
	add = new JButton("add", null);
	add.setActionCommand("add");
	add.addActionListener((ActionListener) this);
	back = new JButton("back", null);
	back.setActionCommand(null);
	back.addActionListener((ActionListener) this);
}

public void actionPerformed(ActionEvent e) {
    if ("add".equals(e.getActionCommand())) {
     //add event
    } else {
        //go back
    }
} 




}

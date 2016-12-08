import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import javafx.scene.layout.Border;

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
private static int realDay, realMonth, realYear, currentMonth, currentYear;
protected int ysHeight = 600;
protected int ysWidth = 700;
protected int msHeight = 600;
protected int msWidth = 600;
protected int dsHeight = 600;
protected int dsWidth = 600;
protected static int PROGRAM_HEIGHT = 1280;
protected static int PROGRAM_WIDTH = 1024;
private static final int subdivisionsYyear = 3;
private static final int subdivisionsXyear = 3;
private static final int subdivisionsYmonth = 3;
private static final int subdivisionsXmonth = 4;
private static final int subdivisionsYday = 6;
private static final int subdivisionsXday = 6; //change to 7 later
private int gridwidth = 80;
private int gridbase = 25;
private JFrame frame;
private JFrame frm;
private static JLabel labelM, labelY, labelSun, labelMon, labelTue, labelWed, labelThu, labelFri, labelSat;
private static JComboBox yearBox;
private static DefaultTableModel calendarTableDefault;
private JPanel panelCalendar;
private JTable tableCalendar;
private JButton back, add;
private static JButton prev;
private static JButton next;
private JButton go2; //when clicking here on yearScreen, will open up month and day panels of that year 
private GLine newline;

private Event ab = new Event();
private String event = null;

static int numDays;
static int monthDays;

private Notes n;



public static void main(String[] args){
	java.awt.EventQueue.invokeLater(new Runnable(){
	@Override
	public void run(){
	CalendarClass c = new CalendarClass();
	//c.dayScreen();
	//c.monthScreen();
	//c.yearScreen();
	c.testMain();


	}});
}


public void testMain(){
	frm = new JFrame("Calendar");
	frm.setPreferredSize(new Dimension(ysHeight, ysWidth));
	frm.getContentPane().setLayout(null);
	frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	labelM = new JLabel("Default");
	labelY = new JLabel("Change Year:");
	labelSun = new JLabel("Sunday");
	labelMon = new JLabel("Monday");
	labelTue = new JLabel("Tuesday");
	labelWed = new JLabel("Wednesday");
	labelThu = new JLabel("Thursday");
	labelFri = new JLabel("Friday");
	labelSat = new JLabel("Saturday");
	yearBox = new JComboBox();
		for (int i = 2016; i <= 2016 + 10; i++){
			//yearBox.addItem(String.valueOf(i));
			yearBox.addItem(i);
		}
	yearBox.addActionListener(new yearBoxListener());  //new yearBoxListener()
	prev = new JButton ("Back");
	prev.setEnabled(true);
	prev.addActionListener(new buttonPrev());
	next = new JButton ("Next");
	next.setEnabled(true);
	next.addActionListener(new buttonNext());
	calendarTableDefault = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int colIndex){return false;}};
	tableCalendar = new JTable(calendarTableDefault);
	panelCalendar = new JPanel(null);

	GregorianCalendar calendar = new GregorianCalendar(); //aligns the calendar with a real calendar
	realDay = calendar.get(GregorianCalendar.DAY_OF_MONTH);
	realMonth = calendar.get(GregorianCalendar.MONTH);
	realYear = calendar.get(GregorianCalendar.YEAR);
	currentMonth = realMonth;
	currentYear = realYear;
	
	// Add note panel to south region of frame:
	n = new Notes();
	frm.setLayout(new BorderLayout());
	frm.getContentPane().add(n.noteMain(), BorderLayout.SOUTH);
	
	panelCalendar.add(labelM);
	panelCalendar.add(labelY);
	panelCalendar.add(labelSun);
	panelCalendar.add(labelMon);
	panelCalendar.add(labelTue);
	panelCalendar.add(labelWed);
	panelCalendar.add(labelThu);
	panelCalendar.add(labelFri);
	panelCalendar.add(labelSat);
	panelCalendar.add(yearBox);
	panelCalendar.add(prev);
	panelCalendar.add(next);
	panelCalendar.add(tableCalendar);
	panelCalendar.setBounds(0,0,ysHeight, ysWidth);
	frm.getContentPane().add(panelCalendar, BorderLayout.CENTER);
	
	labelM.setBounds(240+labelM.getPreferredSize().width/2,20,100,25);
	labelY.setBounds(10,525,80,20);
	labelSun.setBounds(gridbase,50,80,20);
	labelMon.setBounds(gridbase+ gridwidth,50,80,20);
	labelTue.setBounds(gridbase+ (2*gridwidth)-5,50,80,20);
	labelWed.setBounds(gridbase+ (3*gridwidth)-13,50,80,20);
	labelThu.setBounds(gridbase+ (4*gridwidth)-6,50,80,20);
	labelFri.setBounds(gridbase+ (5*gridwidth),50,80,20);
	labelSat.setBounds(gridbase+ (6*gridwidth)-13,50,80,20);
	yearBox.setBounds(480, 525, 80, 20);
	prev.setBounds(10, 20, 75, 25);
	next.setBounds(485, 20, 75, 25);
	tableCalendar.setBounds(10,70,550,550);
	
	tableCalendar.getParent().setBackground(tableCalendar.getBackground());
	

	
	tableCalendar.setRowHeight(76);
	calendarTableDefault.setColumnCount(7);
	calendarTableDefault.setRowCount(6);
	
	tableCalendar.addMouseListener(new MouseAdapter(){
		public void mousePressed(MouseEvent e){
			JTable selected = (JTable)e.getSource();
			int row = selected.getSelectedRow();
			int column = selected.getSelectedColumn();
			//go to add event
				
			
				ab.drawPanel();
				event = ab.event();
			
			
		}
		
	});	
		
	tableCalendar.setColumnSelectionAllowed(false);
	tableCalendar.setRowSelectionAllowed(false);
	
	frm.setResizable(false);
	frm.pack();
	frm.setVisible(true);
	

	newCalendarScreen(currentMonth, currentYear);
	

}

public static void newCalendarScreen(int month, int year){

	
	prev.setEnabled(true);
	next.setEnabled(true);
	if(month == 0 && year == 2016){
		prev.setEnabled(false);
	}
	if(month == 11 && year == 2026){
		next.setEnabled(false);
	}
	
	
	String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	labelM.setText(months[month]);

	yearBox.setSelectedItem(String.valueOf(year));
	
	
	for (int i=0; i<6; i++){
		for (int j=0; j<7; j++){
			calendarTableDefault.setValueAt(null, i, j);
		}
	}
	 
	
	GregorianCalendar calScreen = new GregorianCalendar(year, month, 1);
	numDays = calScreen.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
	monthDays = calScreen.get(GregorianCalendar.DAY_OF_WEEK);
	
	for(int i = 1; i <=numDays; i++){
		int row = new Integer((i+monthDays-2)/7);
		int col = (i+monthDays-2)%7;
		calendarTableDefault.setValueAt(i, row, col);
	}
	
	labelSun.setText("Sunday");
	labelMon.setText("Monday");
	labelTue.setText("Tuesday");
	labelWed.setText("Wednesday");
	labelThu.setText("Thursday");
	labelFri.setText("Friday");
	labelSat.setText("Saturday");
	
}

int getCurrentMonth(){
	return currentMonth;		//returns current month for event class
}

int getCurrentYear(){  
	return currentYear;			//returns current year for event class
}

int getNumDays(){
	return numDays;				//returns current day for event class
}

int getRealDay(){
	return realDay;
}




class buttonPrev implements ActionListener{
	public void actionPerformed (ActionEvent e){
		if (currentMonth == 0){
			currentMonth = 11;
			currentYear -= 1;
			int j = yearBox.getSelectedIndex();
			j--;
			yearBox.setSelectedIndex(j);
			
		}
		else{
			currentMonth -= 1;
		}
		newCalendarScreen(currentMonth, currentYear);
	}
	
}

class buttonNext implements ActionListener{
	public void actionPerformed (ActionEvent e){
		if (currentMonth == 11){
			currentMonth = 0;
			currentYear += 1;
			
			int j = yearBox.getSelectedIndex();
			j++;
			yearBox.setSelectedIndex(j);
			
		}
		else{
			currentMonth += 1;
		}
		newCalendarScreen(currentMonth, currentYear);
	}
	
}

class yearBoxListener implements ActionListener{
	public void actionPerformed (ActionEvent e){
		
		String boxYear = yearBox.getSelectedItem().toString();
		currentYear = Integer.parseInt(boxYear);

	 	
		newCalendarScreen(currentMonth, currentYear);
	}
}



public void yearScreen(){
	JFrame frame = new JFrame("Year");
	GregorianCalendar cal = new GregorianCalendar();
	realDay = cal.get(GregorianCalendar.DAY_OF_MONTH);
	realMonth = cal.get(GregorianCalendar.MONTH);
	realYear = cal.get(GregorianCalendar.YEAR);
	currentMonth = realMonth;
	currentYear = realYear;
	
	
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
	JLabel component = new JLabel("");
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
	panel.add(component11, 0, 0); //see yearscreen for explanation
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
	panel.setLayout(new GridLayout(6,6,80,80));
	JLabel component = new JLabel("1");
	JLabel component1 = new JLabel("2");
	JLabel component2 = new JLabel("3");
	JLabel component3 = new JLabel("4");
	JLabel component4 = new JLabel("5");
	JLabel component5 = new JLabel("6");
	JLabel component6 = new JLabel("7");
	JLabel component7 = new JLabel("8");
	JLabel component8 = new JLabel("9");
	JLabel component9 = new JLabel("10");
	JLabel component0 = new JLabel("11");
	JLabel component11 = new JLabel("12");
	JLabel component12 = new JLabel("13");
	JLabel component13 = new JLabel("14");
	JLabel component14 = new JLabel("15");
	JLabel component15 = new JLabel("16");
	JLabel component16 = new JLabel("17");
	JLabel component17 = new JLabel("18");
	JLabel component18 = new JLabel("19");
	JLabel component19 = new JLabel("20");
	JLabel component20 = new JLabel("21");
	JLabel component21 = new JLabel("22");
	JLabel component22 = new JLabel("23");
	JLabel component23 = new JLabel("24");
	JLabel component24 = new JLabel("25");
	JLabel component25 = new JLabel("26");
	JLabel component26 = new JLabel("27");
	JLabel component27 = new JLabel("28");
	JLabel component28 = new JLabel("29");
	JLabel component29 = new JLabel("30");
	JLabel component30 = new JLabel("31");
	panel.add(component30, 0, 0); //push comment
	panel.add(component29, 1, 0);
	panel.add(component28, 2, 0);
	panel.add(component27, 3, 0);
	panel.add(component26, 4, 0);
	panel.add(component25, 5, 0);
	panel.add(component, 6, 0);
	panel.add(component24, 0, 1);
	panel.add(component23, 1, 1);
	panel.add(component22, 2, 1);
	panel.add(component21, 3, 1);
	panel.add(component20, 4, 1);
	panel.add(component19, 5, 1);
	panel.add(component1, 6, 1);
	panel.add(component18, 0, 2);
	panel.add(component17, 1, 2);
	panel.add(component16, 2, 2);
	panel.add(component15, 3, 2);
	panel.add(component14, 4, 2);
	panel.add(component13, 5, 2);
	panel.add(component2, 6, 2);
	panel.add(component12, 0, 3);
	panel.add(component11, 1, 3);
	panel.add(component0, 2, 3);
	panel.add(component9, 3, 3);
	panel.add(component8, 4, 3);
	panel.add(component7, 5, 3);
	panel.add(component3, 6, 3);
	panel.add(component6, 0, 4);
	panel.add(component5, 1, 4);
	panel.add(component4, 2, 4);
	

	
	

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





}

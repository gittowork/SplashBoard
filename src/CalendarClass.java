import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;


public class CalendarClass extends GraphicsProgram{

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
protected int ysWidth = 800;
protected int msHeight = 300;
protected int msWidth = 400;
protected int dsHeight = 300;
protected int dsWidth = 400;
protected int PROGRAM_HEIGHT = 600;
protected int PROGRAM_WIDTH = 800;
private JFrame frame;
private JPanel p;
private JButton back;
private JButton add;
private JButton go2; //when clicking here on yearScreen, will open up month and day panels of that year 
private GLine newline;


public static void main(String[] args){
	java.awt.EventQueue.invokeLater(new Runnable(){
	@Override
	public void run(){
	CalendarClass c = new CalendarClass();
	c.yearScreen();

	}});
}



public void yearScreen(Graphics g){
	JFrame frame = new JFrame("Calendar");
	p = new JPanel();
	p.setPreferredSize(new Dimension(ysHeight, ysWidth));
	frame.getContentPane().add(p ,BorderLayout.CENTER);
	//newline = new GLine(0, 0, 100, 100);
	//p.add(newline);
	g.drawLine(0, 0, 100, 100);
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
	frame.setPreferredSize(new Dimension(msHeight, msWidth));
	//appears simultaneously with dayScreen on identical panels

}

public void removeEvent(){
	
	// going to remove an event from our method of storing events
}

public void dayScreen(){
	frame.setPreferredSize(new Dimension(dsHeight, dsWidth));
	//appears simultaneously with dayScreen on identical panels
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

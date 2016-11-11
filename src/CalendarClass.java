import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class CalendarClass {

protected int month;
protected int day;
protected int year; 
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


public static void main(String[] args){
	java.awt.EventQueue.invokeLater(new Runnable(){
	@Override
	public void run(){
	CalendarClass c = new CalendarClass();

	}});
}

public void yearScreen(){
	frame.setPreferredSize(new Dimension(ysHeight, ysWidth));


	//pop up for displaying the year on separate screen
	
}



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
	add = new JButton("add");
	add.addActionListener((ActionListener) this);
	back = new JButton("back");
	back.addActionListener((ActionListener) this);
}


}

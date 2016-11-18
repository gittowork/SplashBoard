import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Notes {
	protected int month;
	protected int day;
	protected int year;
	protected String back;
	protected JFrame frm = new JFrame();
	protected static int PROGRAM_HEIGHT = 1280;
	protected static int PROGRAM_WIDTH = 1024;
	
	public static void main(String[] args) {
		// This is equivalent to "run".
		java.awt.EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				Notes n = new Notes();
				n.addNoteScreen();
			}
		});
	}
	
	/*public Notes (String t, String n, int m, int d, int y, String b) {
		month = m;
		day = d;
		year = y;
		back = b;
	}*/
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public int getYear() {
		return year;
	}
	public String getBack() {
		return back;
	}
	public void setMonth() {
		this.month = month;
	}
	public void setDay() {
		this.day = day;
	}
	public void setYear() {
		this.year = year;
	}
	public void setBack() {
		this.back = back;
	}
	public void saveNote() { //To add completed note on screen.
		
		
	}
	
	public void folderScreen() {
		
	}
	
	public void noteScreen() {
		
	}
	
	public void addNoteScreen() {
	frm.setPreferredSize(new Dimension(PROGRAM_HEIGHT, PROGRAM_WIDTH)); //Screen dimension.
	JTextField title = new JTextField("Note Title");
	title.setEditable(true);
	title.setLocation(683, 384);
	title.setFont(new Font("Serif",Font.PLAIN,60)); // Sets font style and size of font. 
	frm.getContentPane().add(title, BorderLayout.CENTER);
	frm.pack(); // Packs all content onto screen; this is necessary in order for your content to appear when you run. 
	frm.setVisible(true);
	//
	}
	
}

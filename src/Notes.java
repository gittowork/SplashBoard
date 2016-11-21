import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.color.ColorSpace;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;

import com.sun.corba.se.impl.orb.ParserTable.TestORBInitializer1;
import com.sun.org.apache.bcel.internal.generic.NEW;

import javafx.geometry.Point3D;
import javafx.scene.shape.Shape3D;
import sun.net.www.content.audio.x_aiff;
import sun.util.resources.cldr.aa.CalendarData_aa_ER;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Notes {
	protected int month;
	protected int day;
	protected int year;
	protected String back;
	private JFrame frm = new JFrame();
	protected static int PROGRAM_HEIGHT = 1280; // Standard largest preferred size of screen.
	protected static int PROGRAM_WIDTH = 1024;
	private JPanel p1;
	private JPanel p2;
	private JButton save;
	private JButton backButton;
	
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
	
	// Note Title:
	p1 = new JPanel();
	JTextArea title = new JTextArea(1, 15);
	title.setLineWrap(true); // Wraps text to new line if it exceeds spec. width.
	title.setEditable(true);
	title.setFont(new Font("Calibri",Font.PLAIN,60)); // Sets font style and size of font. 
	JButton b1 = new JButton();
	TextFieldHint h1 = new TextFieldHint(title, "Note Title"); // Sets the text field hint. 
	p1.add(title);
	b1.setContentAreaFilled(false); // Make button transparent. 
	b1.setBorderPainted(false);
	p1.add(b1);
	frm.getContentPane().add(p1, BorderLayout.NORTH);
	
	// Note Body:
	JTextArea body = new JTextArea(100, 100);
	body.setLineWrap(true); // Wraps text to new line if it exceeds spec. width.
	body.setEditable(true);
	body.setFont(new Font("Calibri", Font.PLAIN, 28));
	JButton b2 = new JButton();
	TextFieldHint h2 = new TextFieldHint(body, "Start typing..."); // Sets text field hint.
	b2.setContentAreaFilled(false); // Make button transparent.
	b2.setBorderPainted(false);
	frm.getContentPane().add(body, BorderLayout.CENTER); // Adds body to the center of frame.
	
	// Save Button:
	p2 = new JPanel();
	save = new JButton("Save");
	p2.add(save);
	p1.add(p2, BorderLayout.EAST); // Adds save button to East side of the North panel.
	
	// Back Button:
	
	
	frm.pack(); // Packs all content onto screen; this is necessary in order for your content to appear when you run. 
	frm.setVisible(true);
	frm.getContentPane().setForeground(Color.WHITE); // Still doesn't work?? What the heck.........
	b1.grabFocus();
	b2.grabFocus();
	}
	
}

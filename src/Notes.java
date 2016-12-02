import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;

import org.junit.Before;
import org.omg.CORBA.SystemException;
import org.omg.PortableServer.POAPackage.AdapterAlreadyExists;

import com.sun.corba.se.impl.orb.ParserTable.TestORBInitializer1;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

import javafx.geometry.Point3D;
import javafx.scene.shape.Shape3D;
import jdk.internal.dynalink.beans.StaticClass;
import sun.net.www.content.audio.x_aiff;
import sun.util.resources.cldr.aa.CalendarData_aa_ER;

import javax.imageio.ImageTypeSpecifier;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Notes {
	protected String back;
	private JFrame frm = new JFrame();
	protected static int PROGRAM_HEIGHT = 1280; // Standard largest preferred size of screen.
	protected static int PROGRAM_WIDTH = 1024;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JButton save;
	private JButton backButton;
	protected JTextArea title = new JTextArea(1, 15);
	protected JTextArea body = new JTextArea(100, 100);
	private JFrame pop1 = new JFrame();
	protected static int POP_HEIGHT = 400;
	protected static int POP_WIDTH = 200;
	private JPanel p4;
	private JPanel p5;
	protected String t;
	protected String b;
	private NoteSave s;
	private JFrame pop2 = new JFrame();
	private JPanel p6;
	private JPanel p7;
	private JButton yes = new JButton("Yes, definitely!");
	private JButton no = new JButton("No, forget it.");
	private JPanel p8;
	protected HashMap<String, NoteSave> hmap = new HashMap<String, NoteSave>();
	private static String bHint = "Start typing...";
	private static String tHint = "Note Title";
	private JPanel main;
	private JFrame pop3 = new JFrame();
	private JPanel p9;
	private JPanel p10;
	private JFrame pop4 = new JFrame();
	private JPanel p11;
	private JPanel p12;

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

	public String getBack() {
		return back;
	}
	public void setBack() {
		this.back = back;
	}
	public void saveNote() { //To add completed note on screen.
		t = title.getText();
		b = body.getText();
		s = new NoteSave(t, b);
		
		// PUT THIS IN SAVE ACTION LISTENER!!!!!!!!!!!!!!!!!!!!!
		try {
			FileInputStream fileIn = new FileInputStream(t + ".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			hmap = (HashMap)in.readObject();
			in.close();
			fileIn.close();
		}catch(IOException ioe) {
			ioe.printStackTrace();
			return;
		}catch(ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}
		Set set = hmap.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry)iterator.next();
			if(mentry.getKey().equals(t)) {
				pop4.setPreferredSize(new Dimension(POP_HEIGHT, POP_WIDTH));
				p11 = new JPanel();
				p12 = new JPanel();
				JLabel exists = new JLabel("<html>A note with this title already exists.<br>Would you like to save this note anyway?</html>");
				exists.setFont(new Font("Calibri", Font.PLAIN, 20));
				p11.add(exists);
				p12.add(yes, BorderLayout.WEST);
				p12.add(no, BorderLayout.EAST);

				pop4.getContentPane().add(p11, BorderLayout.NORTH);
				pop4.getContentPane().add(p12, BorderLayout.SOUTH);
				pop4.pack();
				pop4.setVisible(true);

				yes.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						pop4.dispose();
					}
				});

				no.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						pop4.dispose();
					}
				});

			}
		}
		hmap.put(t, s);

		try { // Serializing object from hashmap.
			FileOutputStream fileOut = new FileOutputStream(t + ".ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(hmap);
			out.close();
			fileOut.close();
			System.out.print("Serialized data is saved in" + " " + t + ".ser");
		}catch(IOException i) {
			i.printStackTrace();
		}
		editNote(); // Testing de-serialization. 
	}

	public void noteMain() {
		main = new JPanel(); // Note main screen is a JPanel that is located below the calendar.
		JPanel north = new JPanel(); // North Panel.
		JLabel nTitle = new JLabel("Notes"); // "Notes" goes in the North panel > center.
		JPanel addNote = new JPanel(); // "Add Note" goes in the North panel > east.
		JButton addN = new JButton("Add Note"); // Goes in addNote JPanel.

		north.add(nTitle, BorderLayout.CENTER);
		north.add(addNote, BorderLayout.EAST);



		main.add(north, BorderLayout.NORTH);


	}

	public void addNoteScreen() {
		frm.setPreferredSize(new Dimension(PROGRAM_HEIGHT, PROGRAM_WIDTH)); //Screen dimension.

		// Note Title:
		p1 = new JPanel();
		title.setLineWrap(true); // Wraps text to new line if it exceeds spec. width.
		title.setEditable(true);
		title.setFont(new Font("Calibri",Font.PLAIN,60)); // Sets font style and size of font. 
		JButton b1 = new JButton();
		TextFieldHint h1 = new TextFieldHint(title, tHint); // Sets the text field hint. 
		p1.add(title);
		b1.setContentAreaFilled(false); // Make button transparent. 
		b1.setBorderPainted(false);
		p1.add(b1);
		frm.getContentPane().add(p1, BorderLayout.NORTH);

		// Note Body:
		body.setLineWrap(true); // Wraps text to new line if it exceeds spec. width.
		body.setEditable(true);
		body.setFont(new Font("Calibri", Font.PLAIN, 28));
		JButton b2 = new JButton();
		TextFieldHint h2 = new TextFieldHint(body, bHint); // Sets text field hint.
		b2.setContentAreaFilled(false); // Make button transparent.
		b2.setBorderPainted(false);
		frm.getContentPane().add(body, BorderLayout.CENTER); // Adds body to the center of frame.

		// Save Button:
		p2 = new JPanel();
		save = new JButton("Save");
		p2.add(save);
		p1.add(p2, BorderLayout.EAST); // Adds save button to East side of the North panel.
		save.addActionListener(new ActionListener() { //When button is clicked.

			@Override
			public void actionPerformed(ActionEvent e) {
				if(title.getText().equals(tHint)) { // Tells user to input title if there is not title before save.
					pop3.setPreferredSize(new Dimension(POP_HEIGHT, POP_WIDTH));
					p9 = new JPanel();
					JLabel needTitle = new JLabel("Please input a note title before saving.");
					needTitle.setFont(new Font("Calibri", Font.PLAIN, 20));
					p9.add(needTitle);
					p10 = new JPanel();
					JButton ok = new JButton("OK");
					p10.add(ok);
					pop3.getContentPane().add(p9, BorderLayout.CENTER);
					pop3.getContentPane().add(p10, BorderLayout.SOUTH);
					pop3.pack();
					pop3.setVisible(true);

					ok.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							pop3.dispose();

						}
					});
				}

				else {
					saveNote(); // Calls saveNote() method.

					// Save confirmation pop-up:
					pop1.setPreferredSize(new Dimension(POP_HEIGHT, POP_WIDTH));
					p4 = new JPanel();
					JLabel saved = new JLabel("Note Saved!");
					saved.setFont(new Font("Calibri", Font.PLAIN, 40));
					p4.add(saved);
					JButton confirm = new JButton("OK");
					p5 = new JPanel();
					p5.add(confirm);
					pop1.getContentPane().add(p5, BorderLayout.SOUTH);
					pop1.getContentPane().add(p4, BorderLayout.CENTER);
					pop1.pack();
					pop1.setVisible(true);

					confirm.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							pop1.dispose(); // When the "OK" button is clicked, the window disappears.
						}

					});
				}
			}
		});


		// Back Button:
		p3 = new JPanel(); 
		backButton = new JButton("Back");
		p3.add(backButton);
		p1.add(p3); // Add back button icon and reformat button layout.
		backButton.addActionListener(new ActionListener() { // When user clicks on "Back":
			@Override
			public void actionPerformed(ActionEvent e) { 
				pop2.setPreferredSize(new Dimension(POP_HEIGHT, POP_WIDTH));
				p6 = new JPanel();
				p7 = new JPanel();
				p8 = new JPanel();

				// Save-before-exit confirmation message pop-up:
				JLabel q = new JLabel("<html>Would you like to save your<br>note before exiting?<html>");
				q.setFont(new Font("Calibri", Font.PLAIN, 20));
				p6.add(q);
				p7.add(yes, BorderLayout.WEST);
				p7.add(no, BorderLayout.EAST);
				pop2.getContentPane().add(p7, BorderLayout.SOUTH);
				pop2.getContentPane().add(p6, BorderLayout.NORTH);
				pop2.pack();
				pop2.setVisible(true);

				yes.addActionListener(new ActionListener() { // When user clicks "Yes":

					@Override
					public void actionPerformed(ActionEvent e) {
						saveNote(); // The note is saved.
						System.out.print("Saved before closing"); // Test message!!
						pop2.dispose();
						frm.dispose();
						// Both frames are disposed.
					}
				});

				no.addActionListener(new ActionListener() { // When user clicks "No":

					@Override
					public void actionPerformed(ActionEvent e) {
						pop2.dispose();
						frm.dispose(); // Both frames are disposed.
					}
				});
			}
		});

		frm.pack(); // Packs all content onto screen; this is necessary in order for your content to appear when you run. 
		frm.setVisible(true);
		frm.getContentPane().setForeground(Color.WHITE); 
		b1.grabFocus();
		b2.grabFocus();

	}

	public void editNote() {
		// Method that is called when user wants to edit an existing note.
		try {
			FileInputStream fileIn = new FileInputStream(t + ".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			hmap = (HashMap)in.readObject();
			in.close();
			fileIn.close();
		}catch(IOException ioe) {
			ioe.printStackTrace();
			return;
		}catch(ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}
		Set set = hmap.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry)iterator.next();
			System.out.print("key: "+ mentry.getKey() + " & Value: ");
			System.out.println(mentry.getValue());
		}
	}

	public void deleteNote() {
		// Method that is called when user wants to delete an existing note.
	}
}

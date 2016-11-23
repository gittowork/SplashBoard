import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
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

public class CalSave {
	private int month;
	private int day;
	private boolean meridium;
	private int year;
	private int hr;
	private int min;
	private String event;
	
	public void CalSave(int m, int d, boolean md, int y, int h, int mi, String e){
		month = m;
		day = d;
		meridium = md;
		year = y;
		hr = h; 
		min = mi;
		event = e;
	}
	
	public void setMonth(int m){
		month = m;
	}
	
	public void setDay(int d){
		day = d;
	}
	
	public void setMeridium(boolean md){
		meridium = md;
	}
	
	public void setYear(int y){
		year = y;
	}
	
	public void setHr(int h){
		hr = h;
	}
	
	public void setMin(int mi){
		min =mi;
	}
	
	public void setEvent(String e){
		event = e;
	}

	public int getMonth(){
		return month;
	}
	
	public int getDay(){
		return day;
	}
	
	public boolean getMeridium(){
		return meridium;
	}
	
	public int getYear(){
		return year;
	}
	
	public int getHr(){
		return hr;
	}
	
	public int getMin(){
		return min;
	}
	
	public String getEvent(){
		return event;
	}
	
}

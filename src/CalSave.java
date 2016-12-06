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

public class CalSave implements java.io.Serializable{
	public String month;
	public int day;
	public String meridium;
	public int year;
	public int hr;
	public String min;
	public String event;
	
	/*public CalSave(String m, int d, String md, int y, int h, int mi, String e){
		month = m;
		day = d;
		meridium = md;
		year = y;
		hr = h; 
		min = mi;
		event = e;
	}*/
	
	public void setMonth(String m){
		month = m;
	}
	
	public void setDay(int d){
		day = d;
	}
	
	public void setMeridium(String md){
		meridium = md;
	}
	
	public void setYear(int y){
		year = y;
	}
	
	public void setHr(int h){
		hr = h;
	}
	
	public void setMin(String mi){
		min =mi;
	}
	
	public void setEvent(String e){
		event = e;
	}

	public String getMonth(){
		return month;
	}
	
	public int getDay(){
		return day;
	}
	
	public String getMeridium(){
		return meridium;
	}
	
	public int getYear(){
		return year;
	}
	
	public int getHr(){
		return hr;
	}
	
	public String getMin(){
		return min;
	}
	
	public String getEvent(){
		return event;
	}
	
}

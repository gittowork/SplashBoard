import java.util.Scanner;

public class Notes {
	protected String title;
	protected String note;
	protected int month;
	protected int day;
	protected int year;
	protected String back;
	
	public Notes (String t, String n, int m, int d, int y, String b) {
		title = t;
		note = n;
		month = m;
		day = d;
		year = y;
		back = b;
	}
	public String getTitle() {
		return title;
	}
	public String getNote() {
		return note;
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
	public void setTitle() {
		this.title = title;
	}
	public void setNote() {
		this.note = note;
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
	public void addNote() { // Function to add note.
		Scanner s = new Scanner(System.in);
		title = s.nextLine(); // Continue addNote function;
		
	}
	
	
}

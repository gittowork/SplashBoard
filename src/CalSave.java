public class CalSave implements java.io.Serializable{
	public String month;
	public int day;
	public String meridium;
	public int year;
	public int hr;
	public int min;
	public String event;

	public CalSave(String m, int d, String md, int y, int h, int mi, String e){
		month = m;
		day = d;
		meridium = md;
		year = y;
		hr = h; 
		min = mi;
		event = e;
	}

	public String toString() {
		return getEvent();
	}

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

	public void setMin(int mi){
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

	public int getMin(){
		return min;
	}

	public String getEvent(){
		return event;
	} 

}

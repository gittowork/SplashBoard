public class NoteSave {
		private int month;
		private int day;
		private int year;
		private String t;
		private String b;
		
		public NoteSave(int m, int d, int y, String title, String body){
			month = m;
			day = d;
			year = y;
			t = title;
			b = body;
		}
		
		public void setMonth(int m){
			month = m;
		}
		
		public void setDay(int d){
			day = d;
		}
		
		public void setYear(int y){
			year = y;
		}
		
		public void setTitle(String title) {
			t = title;
		}
		
		public void setBody(String body) {
			b = body;
		}

		public int getMonth(){
			return month;
		}
		
		public int getDay(){
			return day;
		}
		
		public int getYear(){
			return year;
		}
		
		public String getTitle() {
			return t;
		}
		
		public String getBody() {
			return b;
		}
		
	}


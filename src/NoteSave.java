public class NoteSave {
		private String t;
		private String b;
		
		public NoteSave(String title, String body){
			t = title;
			b = body;
		}
		
		public void setTitle(String title) {
			t = title;
		}
		
		public void setBody(String body) {
			b = body;
		}
		
		public String getTitle() {
			return t;
		}
		
		public String getBody() {
			return b;
		}
		
	}


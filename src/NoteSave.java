public class NoteSave implements java.io.Serializable {
		public String t;
		public String b;
		
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
		
		@Override // Returns the body as a string.
		public String toString() {
			return getBody();
		}
		
		
	}


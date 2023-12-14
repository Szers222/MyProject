	package core;
	
	public class Product {
	    public int getId() {
			return id;
		}
	
	
	
		public void setId(int id) {
			this.id = id;
		}
	
	
	
		public String getTitle() {
			return title;
		}
	
	
	
		public void setTitle(String title) {
			this.title = title;
		}
	
		private int id;
	    private String title;
	    private String base64Image;
	         
	    private byte[] image;  
	 
	    
	    public byte[] getImage() {
	        return this.image;
	    }
	 
	    
	     
	    public String getBase64Image() {
	        return base64Image;
	    }
	 
	    public void setBase64Image(String base64Image) {
	        this.base64Image = base64Image;
	    }
	
	
	
		
	 
	}

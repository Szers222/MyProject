package core;

public class Watch {
	// fields
	private String watchName, watchDescription;
	private int watchId, watchCategoryId, quantity;
	private double watchPrice;
	private byte[] imageBytes;
	private String base64Image;

	
	
	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public byte[] getImageBytes() {
		return imageBytes;
	}

	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
	}

	// Properties
	public String getWatchName() {
		return watchName;
	}

	public void setWatchName(String watchName) {
		this.watchName = watchName;
	}

	public int getWatchCategoryId() {
		return watchCategoryId;
	}

	public void setWatchCategoryId(int watchCategoryId) {
		this.watchCategoryId = watchCategoryId;
	}

	public double getWatchPrice() {
		return watchPrice;
	}

	public void setWatchPrice(double watchPrice) {
		this.watchPrice = watchPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getWatchDescription() {
		return watchDescription;
	}

	public void setWatchDescription(String watchDescription) {
		this.watchDescription = watchDescription;
	}

	public int getWatchId() {
		return watchId;
	}

	public void setWatchId(int watchId) {
		this.watchId = watchId;
	}

	// Constructor


	public Watch(int id, String watchName, double watchPrice, String watchDescription, byte[] imageBytes,
			int watchCategoryId) {
		super();
		this.watchId = id;
		this.watchName = watchName;
		this.watchPrice = watchPrice;
		this.watchDescription = watchDescription;
		this.imageBytes = imageBytes;
		this.watchCategoryId = watchCategoryId;
	}
	public Watch() {
		super();
		
		this.watchName = "";
		this.watchPrice = 0;
		this.watchDescription = "";
		this.imageBytes = null;
		this.watchCategoryId = 0 ;
	}

	public Watch( String name, double price, String description, byte[] image,
			int categoryId) {
		super();
		this.watchName = name;
		this.watchPrice = price;
		this.watchDescription = description;
		this.imageBytes = image;
		this.watchCategoryId = categoryId;
	}

	public double getTotal() {
		return quantity * watchPrice;
	}

	public double setTotal(double total) {
		return total = total;
	}

	public double getAllTotal() {
		double all = 0;

		return all += getTotal();
	}

	// method
	@Override
	public String toString() {
		return "Watch [watchId=" + watchId + ", watchName=" + watchName + ", watchDescription=" + watchDescription
				+ ", imageBytes=" + imageBytes + ", watchPrice=" + watchPrice + ", watchCategoryId=" + watchCategoryId
				+ "";
	}

}

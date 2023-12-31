package core;

public class Watch {
	//fields
	private String watchName,  watchDescription,watchImage;
	private int watchId,watchCategoryId,quantity;
	private double watchPrice;
	//Properties
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



	public String getWatchImage() {
		return watchImage;
	}



	public void setWatchImage(String watchImage) {
		this.watchImage = watchImage;
	}



	public int getWatchId() {
		return watchId;
	}



	public void setWatchId(int watchId) {
		this.watchId = watchId;
	}



	//Constructor
	public Watch( int id, String watchName, double watchPrice, int quantity, String watchDescription,  String watchImage,
			int watchCategoryId) {
		super();
		this.watchId = id;
		this.watchName = watchName;
		this.watchPrice = watchPrice;
		this.watchDescription = watchDescription;
		this.watchImage = watchImage;
		this.watchCategoryId = watchCategoryId;
	}



	public Watch( String watchName, double watchPrice, int quantity, String watchDescription,  String watchImage,
			int watchCategoryId) {
		super();
		this.watchName = watchName;
		this.watchPrice = watchPrice;
		this.watchDescription = watchDescription;
		this.watchImage = watchImage;
		this.watchCategoryId = watchCategoryId;
	}
	public double getTotal() {
		return quantity * watchPrice;
	}
	public double getAllTotal() {
		double all = 0;
		
		return all += getTotal();
	}

	//method
	@Override
	public String toString() {
		return "Watch [watchId=" + watchId + ", watchName=" + watchName + ", watchDescription=" + watchDescription
				+ ", watchImage=" + watchImage + ", watchPrice=" + watchPrice + ", watchCategoryId=" + watchCategoryId
				+ "]";
	}
		
}

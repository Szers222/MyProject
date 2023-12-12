package core;

public class Category {
	//Fields
	private String nameCategory;
	private  int idCatogery;
	private String descriptionCategory; 
	public String getNameCategory() {
		return nameCategory;
	}
	public String getDescriptionCategory() {
		return descriptionCategory;
	}
	public void setDescriptionCategory(String descriptionCategory) {
		this.descriptionCategory = descriptionCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	public int getIdCatogery() {
		return idCatogery;
	}
	public void setIdCatogery(int idCatogery) {
		this.idCatogery = idCatogery;
	}

	//Constructor
	public Category(int idCatogery, String nameCategory, String descriptionCategory) {
		super();
		this.idCatogery = idCatogery;
		this.nameCategory = nameCategory;
		this.descriptionCategory = descriptionCategory;
	}
	public Category(String nameCategory, String descriptionCategory) {
		super();
		this.idCatogery = 0;
		this.nameCategory = nameCategory;
		this.descriptionCategory = descriptionCategory;
	}
	public Category() {
		super();
		this.idCatogery = 0;
		this.nameCategory = "";
		this.descriptionCategory = "";
	}
	
	@Override
	public String toString() {
		return "Category [idCatogery=" + idCatogery + ", nameCategory=" + nameCategory + ", descriptionCategorydescriptionCategory=" + descriptionCategory + "]";
	}
	
	
}

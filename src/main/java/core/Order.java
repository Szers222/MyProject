package core;
import java.io.Serializable;
import java.util.ArrayList;
public class Order implements Serializable  {
	    private String firstName;
	    public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCreditCard() {
			return creditCard;
		}

		public void setCreditCard(String creditCard) {
			this.creditCard = creditCard;
		}

		private String lastName;
	    private String username;
	    private String address;
	    private String creditCard;
	    private ArrayList<Watch> cart;
	    
	    
	    

	    public Order(String firstName, String lastName, String username, String address, String creditCard) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = username;
			this.address = address;
			this.creditCard = creditCard;
			this.cart = new ArrayList<Watch>();
		}

		// Constructors, getters, setters...

	    public void setCart(ArrayList<Watch> cart) {
	        this.cart = cart;
	    }

	    public ArrayList<Watch> getCart() {
	        return cart;
	    }

	    public double getTotal() {
	        double total = 0;
	        for (Watch item : cart) {
	            total += item.getTotal();
	        }
	        return total;
	    }
	}


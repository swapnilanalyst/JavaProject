package relation;

public class Address {
	String city;
	String state;
	String country;

	// Constructor
	public Address(String city, String state, String country) {
		this.city = city;
		this.state = state;
		this.country = country;
	}

	// Method to print Address
	 public String toString() {
	        return city + ", " + state + ", " + country;
	}
}

package tn.micro.service.cloud.response;

public class AddressResponse {
 
	
	  private Long id;
	    private String street;
	    private String city;

	    // Constructeurs
	    public AddressResponse() {
	    }

	    public AddressResponse(Long id, String street, String city) {
	        this.id = id;
	        this.street = street;
	        this.city = city;
	    }

	    // Getters et Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getStreet() {
	        return street;
	    }

	    public void setStreet(String street) {
	        this.street = street;
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }

	    @Override
	    public String toString() {
	        return "AddressResponse{" +
	                "id=" + id +
	                ", street='" + street + '\'' +
	                ", city='" + city + '\'' +
	                '}';
	    }
}

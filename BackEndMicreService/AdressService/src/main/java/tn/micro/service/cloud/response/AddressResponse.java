package tn.micro.service.cloud.response;

import java.util.ArrayList;
import java.util.List;

import tn.micro.service.cloud.entity.Address;


public class AddressResponse {
    private long id;
    private String street;
    private String city;

    // Constructeur à partir d'une entité Address
    public AddressResponse(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.city = address.getCity();
    }

    // Getters et Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

	public static List<AddressResponse> toArrayList(List<Address> findAll) {
		List<AddressResponse> list = new ArrayList<>();
		for (Address address : findAll) {
			list.add( new AddressResponse(address));
		}
		return list;
}
}

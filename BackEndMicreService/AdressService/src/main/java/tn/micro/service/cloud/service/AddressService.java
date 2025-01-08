package tn.micro.service.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.micro.service.cloud.entity.Address;
import tn.micro.service.cloud.repository.AddressRepository;
import tn.micro.service.cloud.request.CreateAddressRequest;
import tn.micro.service.cloud.response.AddressResponse;


@Service
public class AddressService implements IAddressService {

	@Autowired
	private AddressRepository addressRepository;

	// Récupérer une adresse par ID
	@Override
	public Address getById(long id) {
		// TODO Auto-generated method stub
		return addressRepository.findById(id).get();
	}

	// Créer une nouvelle adresse
	@Override
	public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
		Address address = new Address();
		address.setCity(createAddressRequest.getCity());
		address.setStreet(createAddressRequest.getStreet());
		return new AddressResponse(addressRepository.save(address));
	}
	@Override
	public List<AddressResponse> getAllAddress() {
		return AddressResponse.toArrayList(addressRepository.findAll());
	}

}

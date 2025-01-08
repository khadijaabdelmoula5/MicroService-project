package tn.micro.service.cloud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.micro.service.cloud.entity.Address;
import tn.micro.service.cloud.request.CreateAddressRequest;
import tn.micro.service.cloud.response.AddressResponse;

@Service
public interface IAddressService {

	AddressResponse createAddress(CreateAddressRequest createAddressRequest);

	Address getById(long id);

	List<AddressResponse> getAllAddress();

}

package tn.micro.service.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.micro.service.cloud.entity.Address;
import tn.micro.service.cloud.request.CreateAddressRequest;
import tn.micro.service.cloud.response.AddressResponse;
import tn.micro.service.cloud.service.AddressService;

@RestController
@RequestMapping("/api/address") // Préfixe des endpoints
@CrossOrigin(origins = "http://localhost:4200")

public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@Value("${server.port}")  // Inject server port using @Value annotation
	private String port;

	// Endpoint pour récupérer une adresse par ID
	@GetMapping("/getById/{id}")
	public ResponseEntity<AddressResponse> getAddressById(@PathVariable long id) {
		// Log the port number when handling the request
				System.out.println("Request for /getById/{id} handled by instance running on port: " + port);
		Address address = addressService.getById(id);
		if (address == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new AddressResponse(address));
	}

	// Endpoint pour créer une nouvelle adresse
	@PostMapping("/create")
	public ResponseEntity<AddressResponse> createAddress(@RequestBody CreateAddressRequest request) {
		// Log the port number when handling the request
				System.out.println("Request for /create handled by instance running on port: " + port);
//        Address address = new Address();
//        address.setStreet(request.getStreet());
//        address.setCity(request.getCity());

//        Address savedAddress = addressService.createAddress(request);
//        return ResponseEntity.ok(new AddressResponse(savedAddress));
		return ResponseEntity.ok(addressService.createAddress(request));
	}
	@GetMapping("/getAllAddress")
    public List<AddressResponse> getAll() {
        // Log the port number
        System.out.println("Request for /getAllAddress handled by instance running on port: " + port);
        
        // Handle the request and return the response
        return addressService.getAllAddress();
    }
}

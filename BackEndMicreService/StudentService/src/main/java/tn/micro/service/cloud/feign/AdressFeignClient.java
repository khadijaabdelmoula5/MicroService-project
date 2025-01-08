package tn.micro.service.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tn.micro.service.cloud.request.CreateAddressRequest;
import tn.micro.service.cloud.response.AddressResponse;

@FeignClient(name = "address-service", url = "http://localhost:9090/address-service/api/address")
public interface AdressFeignClient {

    // Endpoint to get an address by ID (GET method)
    @GetMapping("/getById/{id}")
    public AddressResponse getById(@PathVariable long id);

    // Endpoint to create a new address (POST method)
    @PostMapping("/create")
    public AddressResponse createAddress(@RequestBody CreateAddressRequest createAddressRequest);
}
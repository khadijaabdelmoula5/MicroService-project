package tn.micro.service.cloud.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

import tn.micro.service.cloud.entity.Student;
import tn.micro.service.cloud.feign.AdressFeignClient;
import tn.micro.service.cloud.repository.StudentRepository;
import tn.micro.service.cloud.request.CreateAddressRequest;
import tn.micro.service.cloud.request.CreateStudentRequest;
import tn.micro.service.cloud.response.AddressResponse;
import tn.micro.service.cloud.response.StudentResponse;

@Service
public class StudentService implements IStudentService {

	@Autowired
	StudentRepository studentRepository;

	/*@Autowired
	AddressRepository addressRepository;*/
	
	@Autowired
	AdressFeignClient client;
	//WebClient webClient;

	@Override
	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
	    System.out.println("Received CreateStudentRequest: " + createStudentRequest);

	    CreateAddressRequest addressRequest = new CreateAddressRequest();
	    addressRequest.setStreet(createStudentRequest.getStreet());
	    addressRequest.setCity(createStudentRequest.getCity());
	    System.out.println("Prepared CreateAddressRequest: " + addressRequest);

	    AddressResponse addressResponse = client.createAddress(addressRequest);
	    if (addressResponse == null || addressResponse.getId() == null) {
	        throw new IllegalStateException("AddressResponse is null or invalid");
	    }
	    System.out.println("Received AddressResponse: " + addressResponse);

	    Student student = new Student();
	    student.setFirstName(createStudentRequest.getFirstName());
	    student.setLastName(createStudentRequest.getLastName());
	    student.setEmail(createStudentRequest.getEmail());
	    student.setAddress(addressResponse.getId());
	    System.out.println("Prepared Student entity: " + student);

	    student = studentRepository.save(student);
	    System.out.println("Saved Student entity: " + student);

	    return new StudentResponse(student, addressResponse);
	}


//	// Appeler le microservice Adresse pour récupérer une adresse par ID
//    public AddressResponse getAddressById(long addressId) {
//        Mono<AddressResponse> addressResponse = webClient.get().uri("/getById/" + addressId).retrieve().bodyToMono(AddressResponse.class);  // Endpoint dans le microservice Adresse
//                
//
//        return addressResponse.block(); // Bloquer pour obtenir le résultat immédiatement (option à éviter si réactivité demandée)
//    }
//
//    // Appeler le microservice Adresse pour créer une nouvelle adresse
//    private AddressResponse createAddressWithWebClient(CreateAddressRequest request) {
//        return webClient.post().uri("/create").contentType(MediaType.APPLICATION_JSON).bodyValue(request).retrieve().bodyToMono(AddressResponse.class).block(); // Bloquer pour obtenir le résultat immédiatement  // Endpoint dans le microservice Adresse
//                
//                
//                
//                
//                
//    }

	@Override
	public StudentResponse getById(long id) {
		return new StudentResponse(studentRepository.findById(id).get());
	}

	@Override
	public List<StudentResponse> getAllStudents() {
		return StudentResponse.toArrayList(studentRepository.findAll());
	}
	
	
	
	}


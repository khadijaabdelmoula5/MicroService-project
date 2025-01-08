package tn.micro.service.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import tn.micro.service.cloud.entity.Address;
import tn.micro.service.cloud.repository.AddressRepository;

@SpringBootApplication
// @ComponentScan({"tn.micro.service.cloud.controller",
// "tn.micro.service.cloud.service"})
// @EntityScan("tn.micro.service.cloud.entity")
// @EnableJpaRepositories("tn.micro.service.cloud.repository")
public class AddressServiceApplication {

	private static AddressRepository addressRepository;

	public static void main(String[] args) {
		System.out.println("---------Démarrage----------");
		// Commencer par réaliser les injections de dépendances pour les objets de type
		// Repository
		// référencer le contexte
		ConfigurableApplicationContext contexte = SpringApplication.run(AddressServiceApplication.class, args);
		// Récupérer une implémentation de l'interface "ProduitRepository" par injection
		// de dépendance

		addressRepository = contexte.getBean(AddressRepository.class);
		Address address = new Address();
		address.setStreet("Rte Mehdia Km 05");
		address.setCity("Sfax");

		address = addressRepository.save(address);

		Address address1 = new Address();
		address1.setStreet("Rte Menzel Chaker Km 04");
		address1.setCity("Sfax");

		address1 = addressRepository.save(address1);

		address.setStreet("ElManzal 9");
		address.setCity("Tunis");

	}

	@Bean
	public CorsFilter corsFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOrigin("http://localhost:4200"); // Allow origin for Angular app
	    config.addAllowedHeader("*"); // Allow all headers
	    config.addAllowedMethod("*"); // Allow all HTTP methods (GET, POST, PUT, DELETE, etc.)
	    source.registerCorsConfiguration("/**", config);
	    return new CorsFilter(source);
	}


}
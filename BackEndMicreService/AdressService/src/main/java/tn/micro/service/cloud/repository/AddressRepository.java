package tn.micro.service.cloud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.micro.service.cloud.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	   // Rechercher toutes les adresses dans une ville donnée
    List<Address> findByCity(String city);

    // Rechercher les adresses dont la rue contient un mot clé
    List<Address> findByStreetContaining(String keyword);

    // Rechercher les adresses par ville et rue
    List<Address> findByCityAndStreet(String city, String street);

    // Rechercher les adresses dont l'ID est supérieur à une valeur donnée
    List<Address> findByIdGreaterThan(Long id);
}

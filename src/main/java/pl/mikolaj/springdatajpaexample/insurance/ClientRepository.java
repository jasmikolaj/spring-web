package pl.mikolaj.springdatajpaexample.insurance;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.mikolaj.springdatajpaexample.insurance.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

	List<Client> findByFirstName(String firstName);


	@Query("SELECT c FROM Client c WHERE c.birthday = ?1 AND c.firstName = ?2")
	List<Client> findByStats(LocalDateTime birthday, String firstName);


}
package pl.mikolaj.springdatajpaexample;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import pl.mikolaj.springdatajpaexample.insurance.ClientRepository;
import pl.mikolaj.springdatajpaexample.insurance.InsuranceRepository;
import pl.mikolaj.springdatajpaexample.insurance.model.Client;
import pl.mikolaj.springdatajpaexample.insurance.model.Offer;

@SpringBootApplication
public class SpringDataJpaExampleApplication implements CommandLineRunner {

	private final InsuranceRepository insuranceRepository;
	private final ClientRepository clientRepository;

	@Autowired
	public SpringDataJpaExampleApplication(InsuranceRepository insuranceRepository,
										   ClientRepository clientRepository) {
		this.insuranceRepository = insuranceRepository;
		this.clientRepository = clientRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaExampleApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Client cl = new Client();
		cl.setFirstName("Miki");
		clientRepository.save(cl);

		System.out.println(findClientOffers());
	}

	@Transactional
	public Set<Offer> findClientOffers() {
		List<Client> clients = clientRepository.findByFirstName("Miki");
		return clients.get(0).getOffers();
	}
}


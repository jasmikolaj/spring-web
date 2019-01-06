package pl.mikolaj.springdatajpaexample;

import java.io.IOException;
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
import pl.mikolaj.springdatajpaexample.offer.OfferRepository;

@SpringBootApplication
public class SpringDataJpaExampleApplication implements CommandLineRunner {

	private final InsuranceRepository insuranceRepository;
	private final ClientRepository clientRepository;
	private final OfferRepository offerRepository;

	@Autowired
	public SpringDataJpaExampleApplication(InsuranceRepository insuranceRepository,
										   ClientRepository clientRepository,
										   OfferRepository offerRepository) {
		this.insuranceRepository = insuranceRepository;
		this.clientRepository = clientRepository;
		this.offerRepository = offerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaExampleApplication.class, args);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void run(String... args) {
		Client client = new Client();
		client.setFirstName("Miki");
		clientRepository.save(client);

		Offer offer = new Offer();
		offer.setName("Super stuff");
		offerRepository.save(offer);

		client.getOffers().add(offer);
		clientRepository.save(client);

//		System.out.println(findClientOffers());
	}

	@Transactional
	public Set<Offer> findClientOffers() {
		List<Client> clients = clientRepository.findByFirstName("Miki");
		return clients.get(0).getOffers();
	}
}


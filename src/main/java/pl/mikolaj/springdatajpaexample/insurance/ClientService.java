package pl.mikolaj.springdatajpaexample.insurance;

import org.springframework.stereotype.Service;
import pl.mikolaj.springdatajpaexample.client.ClientRepository;
import pl.mikolaj.springdatajpaexample.error.ObjectNotFoundException;
import pl.mikolaj.springdatajpaexample.insurance.model.Client;

@Service
public class ClientService {

	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public Client findClient(Long id) {
		return clientRepository.findById(id).orElseThrow(() ->
				new ObjectNotFoundException(id.toString()));
	}


}

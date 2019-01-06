package pl.mikolaj.springdatajpaexample.insurance;

import org.springframework.stereotype.Component;
import pl.mikolaj.springdatajpaexample.insurance.model.Client;
import pl.mikolaj.springdatajpaexample.insurance.model.Insurance;
import pl.mikolaj.springdatajpaexample.insurance.web.CreateInsuranceDto;
import pl.mikolaj.springdatajpaexample.insurance.web.InsuranceResponse;

@Component
public class InsuranceMapper {

	private final ClientService clientService;

	public InsuranceMapper(ClientService clientService) {
		this.clientService = clientService;
	}

	public InsuranceResponse map(Insurance insuranceEntity) {
		return new InsuranceResponse(insuranceEntity.getId(), insuranceEntity.getPrice());
	}

	public Insurance createNew(CreateInsuranceDto insuranceDto) {
		Insurance insurance = new Insurance();
		insurance.setPrice(insuranceDto.getPrice());
		insurance.setClient(clientService.findClient(insuranceDto.getClientId()));
		return insurance;
	}
}

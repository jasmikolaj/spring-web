package pl.mikolaj.springdatajpaexample.insurance;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mikolaj.springdatajpaexample.error.ObjectNotFoundException;
import pl.mikolaj.springdatajpaexample.insurance.model.Insurance;
import pl.mikolaj.springdatajpaexample.insurance.web.CreateInsuranceDto;
import pl.mikolaj.springdatajpaexample.insurance.web.InsuranceResponse;

import static java.util.stream.Collectors.toList;

@Service
public class InsuranceService {

	private final InsuranceRepository insuranceRepository;
	private final ClientService clientService;
	private final InsuranceMapper insuranceMapper;

	public InsuranceService(InsuranceRepository insuranceRepository,
							ClientService clientService,
							InsuranceMapper insuranceMapper) {
		this.insuranceRepository = insuranceRepository;
		this.clientService = clientService;
		this.insuranceMapper = insuranceMapper;
	}

	public List<InsuranceResponse> getAll() {
		return insuranceRepository.findAll().stream()
				.map(insuranceMapper::map)
				.collect(toList());
	}

	@Transactional
	public void add(CreateInsuranceDto insuranceDto) {
		Insurance insurance = insuranceMapper.createNew(insuranceDto);
		insuranceRepository.save(insurance);
	}

	public InsuranceResponse getOne(Long id) {
		Insurance insurance = insuranceRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException(id.toString()));
		return insuranceMapper.map(insurance);
	}

	public List<InsuranceResponse> findByPrice(Double price) {
		return insuranceRepository.findByPrice(price).stream()
				.map(insuranceMapper::map)
				.collect(toList());
	}
}

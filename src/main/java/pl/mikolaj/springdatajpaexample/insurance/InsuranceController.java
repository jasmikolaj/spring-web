package pl.mikolaj.springdatajpaexample.insurance;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.mikolaj.springdatajpaexample.error.ObjectNotFoundException;
import pl.mikolaj.springdatajpaexample.insurance.web.CreateInsuranceDto;
import pl.mikolaj.springdatajpaexample.insurance.web.InsuranceResponse;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

	private final InsuranceService insuranceService;

	public InsuranceController(InsuranceService insuranceService) {
		this.insuranceService = insuranceService;
	}

	@GetMapping
	public List<InsuranceResponse> getAll(@RequestParam("price") Optional<Double> price) {
		if (price.isPresent()) {
			return insuranceService.findByPrice(price.get());
		}

		return insuranceService.getAll();
	}

	@GetMapping("/{id}")
	public InsuranceResponse getOne(@PathVariable("id") Long id) {
		return insuranceService.getOne(id);
	}

	@PostMapping
	public void addInsurance(@RequestBody CreateInsuranceDto insuranceDto) {
		insuranceService.add(insuranceDto);
	}


	@ExceptionHandler(ObjectNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void handleObjectNotFoundException(ObjectNotFoundException ex) {
		System.out.println("Zlapalem blad.");
	}

}

package pl.mikolaj.springdatajpaexample.insurance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mikolaj.springdatajpaexample.insurance.model.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
	List<Insurance> findByPrice(Double price);
}
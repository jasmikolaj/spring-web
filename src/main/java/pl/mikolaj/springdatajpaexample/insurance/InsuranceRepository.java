package pl.mikolaj.springdatajpaexample.insurance;

import org.springframework.data.repository.CrudRepository;
import pl.mikolaj.springdatajpaexample.insurance.model.Insurance;

public interface InsuranceRepository extends CrudRepository<Insurance, Long> {
}
package pl.mikolaj.springdatajpaexample.offer;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mikolaj.springdatajpaexample.insurance.model.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}

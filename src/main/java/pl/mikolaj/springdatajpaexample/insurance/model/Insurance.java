package pl.mikolaj.springdatajpaexample.insurance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Insurance {

	@Id
	@GeneratedValue
	private Long id;

	private Double price;

	@ManyToOne
	private Client client;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Insurance{" +
				"id=" + id +
				", price=" + price +
				", client=" + client +
				'}';
	}
}

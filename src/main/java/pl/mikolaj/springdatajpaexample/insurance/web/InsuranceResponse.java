package pl.mikolaj.springdatajpaexample.insurance.web;

public class InsuranceResponse {

	private long id;
	private double price;

	public InsuranceResponse(long id, double price) {
		this.id = id;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}
}

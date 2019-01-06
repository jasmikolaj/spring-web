package pl.mikolaj.springdatajpaexample.insurance.web;

public class CreateInsuranceDto {
	private double price;
	private long clientId;

	public CreateInsuranceDto() {
	}

	public CreateInsuranceDto(double price, long clientId) {
		this.price = price;
		this.clientId = clientId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
}
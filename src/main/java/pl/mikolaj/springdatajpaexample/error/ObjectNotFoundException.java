package pl.mikolaj.springdatajpaexample.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException {

	public ObjectNotFoundException(String objectId) {
		super("Resource not found with ID: " + objectId);
	}
}

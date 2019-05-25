package com.paf.rest.webservice.restfulwebservices.User.resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String massage) {
		super(massage);
		// TODO Auto-generated constructor stub
	}
	
	

}

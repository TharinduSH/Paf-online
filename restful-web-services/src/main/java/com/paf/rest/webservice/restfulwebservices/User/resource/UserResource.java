package com.paf.rest.webservice.restfulwebservices.User.resource;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;





@RestController
@RequestMapping("/com")
public class UserResource {
	
	@Autowired
	private UserDao service; 
	
	
	//retrieveAllUsers
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		
		return service.findAll();
	}
	
	@GetMapping("/users/{id}") //RetreaveUser(int id)
	
	public User retrieveUser(@PathVariable int id ) {
		User user = service.findOne(id);
		
		if(user==null) 
			
			throw new UserNotFoundException("id-" + id);
		
		
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		
		 URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		 
		 return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		User user = service.deleteById(id);
		
		if(user==null)
			
			throw new UserNotFoundException("id-" + id);
		
	}
	
	
	@PutMapping("/user/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable(value ="id") int id,@Valid @RequestBody User userDetails){
		
		User savedUser = service.findOne(id);
		
		if(savedUser==null) {
			
			return ResponseEntity.notFound().build();

		}
		savedUser.setName(userDetails.getName());
		savedUser.setAmount(userDetails.getAmount());
		savedUser.setMethod(userDetails.getMethod());
			
			User updateuser=service.save(savedUser);
			return ResponseEntity.ok().body(updateuser);
	   }
	
	}
	
	

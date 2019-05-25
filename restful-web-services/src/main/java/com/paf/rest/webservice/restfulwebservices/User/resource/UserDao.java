package com.paf.rest.webservice.restfulwebservices.User.resource;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;






@Component
public class UserDao {
	
	 private static List<User> users = new ArrayList<>();
	 
	 
	 public  int usersCount = 3;
	 static {
		 
		 users.add(new User(1,"saAdam",1200,new Date(),"cash"));
		 users.add(new User(2,"ras",1500,new Date(),"cash"));
		 users.add(new User(3,"Jack",1300,new Date(),"cash"));
	
		 
	 }
	 
	 public List<User> findAll(){
		 
		 return users;
	 }
	 
	 public User save(User user){
		 if(user.getId()==null) {
			 
			 user.setId(++usersCount);
		 }
		 users.add(user);
		 return user;
	 }
	 
	 public User findOne(long id){
		 for(User user:users) {
			 
			 if(user.getId()==id) {
				 return user;
			 }
		 }
		 return null;
	 }
	 
	 
     public User deleteById(int id){
		 Iterator<User> iterator = users.iterator();
	while(iterator.hasNext()) {
		
	User user = iterator.next();
	
	if(user.getId()==id) {
		
		iterator.remove();
		return user;
	}
	
	}
	return null;
	}
}

package com.paf.rest.webservice.restfulwebservices.User.resource;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="payments")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Size(min=2, message="Name should have atleat 2 charchters")
	@Column(name="Name")
	private String name;
	
	@Column(name="Amount")
	private int amount;
	
	@Column(name="Date")
	private Date date;
	
	@Column(name="Method")
	private String method;
    
	public User(Integer id, @Size(min = 2, message = "Name should have atleat 2 charchters") String name, int amount,
			Date date, String method) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.date = date;
		this.method = method;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", amount=" + amount + ", date=" + date + ", method=" + method
				+ "]";
	}

	
}
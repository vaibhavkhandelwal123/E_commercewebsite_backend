package com.ecommerce.model;

import java.time.LocalDateTime;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity

public class User {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String other;
	private String role;
	private String mobile;
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Address> address= new ArrayList<>();
	
	@Embedded
	@ElementCollection
	@CollectionTable(name="payment_information",joinColumns= @JoinColumn(name="user_id"))
	private List<Paymentinformation> paymentinformation = new ArrayList<>();
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Rating> ratings = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Review> reviews=new ArrayList<>();
	
	private LocalDateTime createdAt;
	
	public User() {
		
	}

	
	
	public User(Long id, String firstName, String lastName, String password, String email, String role, String mobile,String other,
			List<Address> address, List<Paymentinformation> paymentinformation, List<Rating> ratings,
			List<Review> reviews, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.other=other;
		this.email = email;
		this.role = role;
		this.mobile = mobile;
		this.address = address;
		this.paymentinformation = paymentinformation;
		this.ratings = ratings;
		this.reviews = reviews;
		this.createdAt = createdAt;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Paymentinformation> getPaymentinformation() {
		return paymentinformation;
	}

	public void setPaymentinformation(List<Paymentinformation> paymentinformation) {
		this.paymentinformation = paymentinformation;
	}

	public List<Rating> getRatings() {
		return ratings;
	}
	
	public String getOther() {
		return other;
	}



	public void setOther(String other) {
		this.other = other;
	}



	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}

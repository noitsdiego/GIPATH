package com.PISPATH.UserAdministrator.model;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class UserModel {

    @Id
    Integer id;

    String name;
    
    String lastName;
    
    String email;
    
    String password;
    
    String telephone;
    
    String city;
    
    String country;
    
    
    public UserModel() {
    	
    }
    		

	public UserModel(String name, String lastName, String email, String password, String telephone, String city,
			String country) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.city = city;
		this.country = country;
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


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public int hashCode() {
		return Objects.hash(city, country, email, id, lastName, name, telephone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		return Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(name, other.name)
				&& Objects.equals(telephone, other.telephone);
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", telephone="
				+ telephone + ", city=" + city + ", country=" + country + "]";
	}

    
    
 
}

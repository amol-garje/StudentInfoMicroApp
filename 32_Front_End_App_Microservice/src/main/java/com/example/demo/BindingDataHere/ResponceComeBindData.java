package com.example.demo.BindingDataHere;

public class ResponceComeBindData {
    int id;
	@Override
	public String toString() {
		return "ResponceComeBindData [id=" + id + ", name=" + name + ", password=" + password + ", place=" + place
				+ ", email=" + email + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	String name;
	String password;
	String place;
	String email;
	  
}

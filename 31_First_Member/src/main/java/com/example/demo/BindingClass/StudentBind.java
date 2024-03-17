package com.example.demo.BindingClass;

public class StudentBind {
	String name;
	String password;
	String place;
	String email;
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
	@Override
	public String toString() {
		return "StudentBind [name=" + name + ", password=" + password + ", place=" + place + ", email=" + email + "]";
	}
	
}

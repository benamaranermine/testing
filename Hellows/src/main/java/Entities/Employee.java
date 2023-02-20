package Entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Employee {
public String cin;
public String firstname;
public String lastname;

 
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(String cin, String firstname, String lastname) {
	super();
	this.cin = cin;
	this.firstname = firstname;
	this.lastname = lastname;
}
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}




}

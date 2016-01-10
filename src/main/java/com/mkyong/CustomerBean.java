package com.mkyong;

import java.io.Serializable;
import java.util.List;

import com.mkyong.customer.bo.CustomerBo;
import com.mkyong.customer.model.Customer;

public class CustomerBean implements Serializable{
 
	//DI via Spring
	CustomerBo customerBo;
	
	public String firstName;
	public String address;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCustomerBo(CustomerBo customerBo) {
		this.customerBo = customerBo;
	}
 
	//get all customer data from database
	public List<Customer> getCustomerList(){
		return customerBo.findAllCustomer();
	}
	
	//add a new customer data into database
	public String addCustomer(){
		
		Customer cust = new Customer();
		cust.setFname(getFirstName());
		cust.setAddress(getAddress());
		
		customerBo.addCustomer(cust);
		
		clearForm();
		
		return "";
	}
	
	//clear form values
	private void clearForm(){
		setFirstName("");
		setAddress("");
	}
	
}

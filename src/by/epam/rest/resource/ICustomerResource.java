package by.epam.rest.resource;

import java.util.List;

import javax.xml.bind.JAXBElement;

import by.epam.rest.model.bean.Customer;

public interface ICustomerResource {
	List<Customer> getCustomers();
	Customer getCustomerById(int id);
	void addCustomer(JAXBElement<Customer> customer);
	void deleteCustomer(int id);
	void updateCustomer(JAXBElement<Customer> customer);
}

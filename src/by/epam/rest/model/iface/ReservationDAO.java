package by.epam.rest.model.iface;

import java.util.List;

import by.epam.rest.exception.custom.DaoException;
import by.epam.rest.model.bean.Customer;

public interface ReservationDAO {
	List<Customer> getCustomers() throws DaoException;
	Customer getCustomerById(int id) throws DaoException;
	void addCustomer(Customer customer) throws DaoException;
	void deleteCustomer(int id) throws DaoException;
	void updateCustomer(Customer customer) throws DaoException;
}

package by.epam.rest.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import by.epam.rest.exception.custom.DaoException;
import by.epam.rest.model.bean.Customer;
import by.epam.rest.model.factory.ReservationImplFactory;
import by.epam.rest.model.iface.ReservationDAO;

@Path("customer")
public class CustomerResource implements ICustomerResource {
	private ReservationDAO dao = ReservationImplFactory.getImplementation();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers;
		try {
			customers = dao.getCustomers();
		} catch (DaoException ex) {
			customers = new ArrayList<Customer>();
			System.out.println(ex);
		}
		return customers;
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public Customer getCustomerById(@PathParam("id") int id) {
		Customer customer;
		try {
			customer = dao.getCustomerById(id);
		} catch (DaoException ex) {
			customer = new Customer();
			System.out.println(ex);
		}
		return customer;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Override
	public void addCustomer(JAXBElement<Customer> customer) {
		try {
			dao.addCustomer(customer.getValue());
		} catch (DaoException ex) {
			System.out.println(ex);
		}
	}
	
	@DELETE
	@Path("{id}")
	@Override
	public void deleteCustomer(@PathParam("id") int id) {
		try {
			dao.deleteCustomer(id);
		} catch (DaoException ex) {
			System.out.println(ex);
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Override
	public void updateCustomer(JAXBElement<Customer> customer) {
		try {
			dao.updateCustomer(customer.getValue());
		} catch (DaoException ex) {
			System.out.println(ex);
		}
	}
}

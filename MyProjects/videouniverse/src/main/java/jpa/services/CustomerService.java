package jpa.services;

import jpa.models.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomerById(long id);

    void deleteCustomerById(long id);

}

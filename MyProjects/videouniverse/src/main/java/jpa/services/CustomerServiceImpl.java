package jpa.services;

import jpa.models.Customer;
import jpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(long id) {
        Customer customer = customerRepository.getById(id);
        if (customer == null) {
            throw new CustomerNotFoundException();
        }
        return customer;
    }

    @Override
    public void deleteCustomerById(long id) {
        this.customerRepository.deleteById(id);
    }
}

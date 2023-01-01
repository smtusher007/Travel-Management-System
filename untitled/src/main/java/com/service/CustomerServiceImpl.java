package com.service;


import com.domain.Customer;
import com.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository)
    {
        this.customerRepository=customerRepository;
    }
    @Transactional
    public Customer get(int id)
    {
        return customerRepository.get(id);
    }

    @Transactional
    public List<Customer> getAll()
    {
        return customerRepository.getAll();
    }
    @Transactional
    public Customer insert(Customer customer){return customerRepository.create(customer);}
    @Transactional
    public Customer update(Customer customer)
    {
        return customerRepository.update(customer);
    }
    @Transactional
    public void delete(int id)
    {
        customerRepository.delete(id);
    }
}

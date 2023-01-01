package com.service;

import com.domain.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface CustomerService {

    public Customer get(int id);

    public List<Customer> getAll();

    public Customer insert(Customer customer);

    public Customer update(Customer customer);

    public void delete(int id);

}

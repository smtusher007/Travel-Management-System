package com.repository;

import com.domain.Customer;

import java.util.List;

public interface CustomerRepository {

    public List<Customer> getAll();

    public Customer create(Customer customer);

    public Customer get(int id);

    public Customer update(Customer customer);

    public void delete(int id);

}

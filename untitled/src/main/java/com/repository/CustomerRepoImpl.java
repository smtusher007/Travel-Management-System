package com.repository;

import com.domain.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepoImpl implements CustomerRepository {

    private SessionFactory sessionFactory;

    public CustomerRepoImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory=sessionFactory;
    }
    public List<Customer> getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> customerQuery = session.createQuery("from Customer" , Customer.class);
        return customerQuery.getResultList();
    }
    public Customer create(Customer customer)
    {
        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
        return customer;
    }
    public Customer get(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        return  session.get(Customer.class,id);
    }
    public Customer update(Customer customer)
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
        return customer;
    }
    public void delete(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = get(id);
        if(customer != null)
        {
            session.delete(customer);
        }
    }
}

package com.repository;

import com.domain.Emp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpRepoImpl implements EmpRepository {

    private SessionFactory sessionFactory;
    public EmpRepoImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    public List<Emp> getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        Query<Emp> empQuery = session.createQuery("from Emp",Emp.class);
        return  empQuery.getResultList();
    }
    public Emp create(Emp emp)
    {
        Session session = sessionFactory.getCurrentSession();
        session.save(emp);
        return emp;
    }
    public Emp get(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Emp.class,id);
    }
    public Emp update(Emp emp)
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(emp);
        return emp;
    }
    public void delete(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Emp emp = get(id);
        if(emp != null)
        {
            session.delete(emp);
        }
    }
}

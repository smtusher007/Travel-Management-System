package com.repository;


import com.domain.Authority;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorityRepoImpl implements AuthorityRepository {

    private SessionFactory sessionFactory;

    public AuthorityRepoImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory=sessionFactory;
    }
    public List<Authority> getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        Query<Authority> adminQuery = session.createQuery("from Admin", Authority.class);
        return adminQuery.getResultList();
    }

    public Authority create(Authority authority)
    {
        Session session = sessionFactory.getCurrentSession();
        session.save(authority);
        return authority;
    }

    public Authority get(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Authority.class, id);
    }

    public Authority update(Authority authority)
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(authority);
        return authority;
    }

    public void delete(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Authority authority = get(id);
        if(authority != null)
        {
            session.delete(authority);
        }
    }
}

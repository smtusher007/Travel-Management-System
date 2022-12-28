package com.repository;


import com.domain.Bus_booking;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BusRepoImpl {
    private SessionFactory sessionFactory;
    public BusRepoImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory=sessionFactory;
    }
    public List<Bus_booking> getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        Query<Bus_booking> bus_bookingQuery = session.createQuery("from Bus_booking ", Bus_booking.class);
        return bus_bookingQuery.getResultList();
    }
    public Bus_booking create(Bus_booking bus_booking)
    {
        Session session = sessionFactory.getCurrentSession();
        session.save(bus_booking);
        return bus_booking;
    }
    public Bus_booking get(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Bus_booking.class,id);
    }
    public Bus_booking update(Bus_booking bus_booking)
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(bus_booking);
        return bus_booking;
    }
    public void delete(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Bus_booking bus_booking = get(id);
        if(bus_booking !=null )
        {
            session.delete(bus_booking);
        }
    }
}

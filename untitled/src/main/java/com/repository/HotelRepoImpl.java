package com.repository;


import com.domain.Hotel_booking;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelRepoImpl implements  HotelRepository{

    private SessionFactory sessionFactory;
    public HotelRepoImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    public List<Hotel_booking> getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        Query<Hotel_booking> hotel_bookingQuery = session.createQuery("from Hotel_booking ", Hotel_booking.class);
        return hotel_bookingQuery.getResultList();
    }
    public Hotel_booking create(Hotel_booking hotel_booking)
    {
        Session session = sessionFactory.getCurrentSession();
        session.save(hotel_booking);
        return  hotel_booking;
    }
    public Hotel_booking get(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        return  session.get(Hotel_booking.class,id);
    }
    public Hotel_booking update(Hotel_booking hotel_booking)
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(hotel_booking);
        return  hotel_booking;
    }
    public void delete(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Hotel_booking hotel_booking = get(id);
        if(hotel_booking !=null) {
            session.delete(hotel_booking);
        }
    }
}

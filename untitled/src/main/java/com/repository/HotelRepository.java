package com.repository;

import com.domain.Hotel_booking;

import java.util.List;

public interface HotelRepository {

    public List<Hotel_booking> getAll();

    public Hotel_booking create(Hotel_booking hotel_booking);

    public Hotel_booking get(int id);

    public Hotel_booking update(Hotel_booking hotel_booking);

    public void delete(int id);
}

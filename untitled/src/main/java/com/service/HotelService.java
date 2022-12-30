package com.service;

import com.domain.Hotel_booking;

import java.util.List;

public interface HotelService {

    public Hotel_booking insert(Hotel_booking hotel_booking);

    public Hotel_booking update(Hotel_booking hotel_booking);

    public Hotel_booking get(int id);

    public List<Hotel_booking> getAll();

    public void delete(int id);
}

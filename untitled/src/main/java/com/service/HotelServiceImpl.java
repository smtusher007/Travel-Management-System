package com.service;

import com.domain.Hotel_booking;
import com.repository.HotelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository)
    {
        this.hotelRepository=hotelRepository;
    }

    @Transactional
    public Hotel_booking insert(Hotel_booking hotel_booking)
    {
        return hotelRepository.create(hotel_booking);
    }

    @Transactional(readOnly = true)
    public Hotel_booking get(int id)
    {
        return  hotelRepository.get(id);
    }

    @Transactional(readOnly = true)
    public List<Hotel_booking> getAll()
    {
        return hotelRepository.getAll();
    }

    @Transactional
    public Hotel_booking update(Hotel_booking hotel_booking)
    {
        return hotelRepository.update(hotel_booking);
    }

    @Transactional
    public void delete(int id)
    {
        hotelRepository.delete(id);
    }
}

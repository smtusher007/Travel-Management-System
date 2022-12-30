package com.service;

import com.domain.Bus_booking;

import java.util.List;

public interface BusService {

    public Bus_booking insert(Bus_booking bus_booking);

    public Bus_booking get(int id);

    public List<Bus_booking> getAll();

    public Bus_booking update(Bus_booking bus_booking);

    public  void delete(int id);

}

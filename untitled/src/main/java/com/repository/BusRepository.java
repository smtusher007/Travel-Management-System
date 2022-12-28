package com.repository;

import com.domain.Bus_booking;

import java.util.List;

public interface BusRepository {
    public List<Bus_booking> getAll();

    public Bus_booking create(Bus_booking bus_booking);

    public Bus_booking get(int id);

    public Bus_booking update(Bus_booking bus_booking);

    public void delete(int id);
}

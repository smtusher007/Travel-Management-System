package com.service;


import com.domain.Bus_booking;
import com.repository.BusRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BusServiceImpl implements BusService {

    private BusRepository busRepository;

    public BusServiceImpl(BusRepository busRepository)
    {
        this.busRepository=busRepository;
    }

    @Transactional
    public Bus_booking insert(Bus_booking bus_booking)
    {
        return busRepository.create(bus_booking);
    }

    @Transactional(readOnly = true)
    public Bus_booking get(int id)
    {
        return busRepository.get(id);
    }

    @Transactional(readOnly = true)
    public List<Bus_booking> getAll()
    {
        return busRepository.getAll();
    }

    @Transactional
    public Bus_booking update(Bus_booking bus_booking)
    {
        return busRepository.update(bus_booking);
    }

    @Transactional
    public void delete(int id)
    {
        busRepository.delete(id);
    }
}

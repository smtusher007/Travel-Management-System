package com.controller;


import com.domain.Bus_booking;
import com.domain.Emp;
import com.exception.BadRequestAlertException;
import com.exception.NotFoundAlertException;
import com.service.BusService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BusController {
    private BusService busService;
    public BusController(BusService busService)
    {
        this.busService=busService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @PostMapping("/bus")
    public ResponseEntity<Bus_booking> createBus(@Valid @RequestBody Bus_booking bus_booking) throws Exception
    {
        if(bus_booking.getId() != 0)
        {
            throw new BadRequestAlertException("A new Bus cannot have an id value");

        }
        busService.insert(bus_booking);
        return ResponseEntity.created(new URI("/bus/")).body(bus_booking);
    }

    @PutMapping("/bus")
    public ResponseEntity<Bus_booking> updateBus(@Valid @RequestBody Bus_booking bus_booking) throws Exception
    {
        if(bus_booking.getId() == 0)
        {
            throw new BadRequestAlertException("Invalid id");
        }
        busService.update(bus_booking);
        return ResponseEntity.created(new URI("/bus/")).body(bus_booking);
    }

    @GetMapping("/bus")
    public ResponseEntity<List<Bus_booking>> getAllBus()
    {
        List<Bus_booking> bus_bookings = busService.getAll();
        return ResponseEntity.ok().body(bus_bookings);
    }

    @GetMapping("/bus/{id}")
    public ResponseEntity<Bus_booking> getBus(@PathVariable int id)
    {
        Optional<Bus_booking> bus_booking = Optional.ofNullable(busService.get(id));
        if(bus_booking.isPresent())
        {
            return ResponseEntity.ok().body(bus_booking.get());
        }
        throw new NotFoundAlertException("Record not found for [" + id + "]");
    }

    @DeleteMapping("/bus/{id}")
    public ResponseEntity<Bus_booking> deleteBus(@PathVariable int id)
    {
        busService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

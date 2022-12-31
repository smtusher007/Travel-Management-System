package com.controller;



import com.domain.Hotel_booking;
import com.exception.BadRequestAlertException;
import com.exception.NotFoundAlertException;
import com.service.HotelService;
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
public class HotelController {

    private HotelService hotelService;

    public HotelController(HotelService hotelService)
    {
        this.hotelService=hotelService;
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
    @PostMapping("/hotels")
    public ResponseEntity<Hotel_booking> createHotels(@Valid @RequestBody Hotel_booking hotel_booking) throws Exception
    {
        if(hotel_booking.getId() != 0)
        {
            throw new BadRequestAlertException("A new Hotel cannot have an id value");

        }
        hotelService.insert(hotel_booking);
        return ResponseEntity.created(new URI("/hotels/")).body(hotel_booking);
    }

    @PutMapping("/hotels")
    public ResponseEntity<Hotel_booking> updateHotels(@Valid @RequestBody Hotel_booking hotel_booking) throws Exception
    {
        if(hotel_booking.getId() == 0)
        {
            throw new BadRequestAlertException("Invalid id");
        }
        hotelService.update(hotel_booking);
        return ResponseEntity.created(new URI("/hotels/")).body(hotel_booking);
    }

    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel_booking>> getAllHotels()
    {
        List<Hotel_booking> hotel_bookings = hotelService.getAll();
        return ResponseEntity.ok().body(hotel_bookings);
    }
    @GetMapping("/hotels/{id}")
    public ResponseEntity<Hotel_booking> getHotels(@PathVariable int id)
    {
        Optional<Hotel_booking> hotel_booking = Optional.ofNullable(hotelService.get(id));
        if(hotel_booking.isPresent())
        {
            return ResponseEntity.ok().body(hotel_booking.get());
        }
        throw new NotFoundAlertException("Record not found for [" + id + "]");
    }
    @DeleteMapping("hotels/{id}")
    public ResponseEntity<Hotel_booking> deleteHotels(@PathVariable int id)
    {
        hotelService.delete(id);
        return ResponseEntity.noContent().build();
    }


}

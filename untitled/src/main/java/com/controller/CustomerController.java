package com.controller;


import com.domain.Customer;
import com.exception.BadRequestAlertException;
import com.exception.NotFoundAlertException;
import com.service.CustomerService;
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
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @PutMapping("/customers")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer) throws Exception
    {
        if(customer.getId() == 0)
        {
            throw new BadRequestAlertException("Invalid id");
        }
        customerService.update(customer);
        return ResponseEntity.created(new URI("/customers/"))
                .body(customer);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers()
    {
        List<Customer> customers = customerService.getAll();
        return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int id)
    {
        Optional<Customer> customer = Optional.ofNullable(customerService.get(id));
        if(customer.isPresent())
        {
            return ResponseEntity.ok().body(customer.get());
        }
        throw new NotFoundAlertException("Record not found [" + id + "]");
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable int id)
    {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


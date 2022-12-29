package com.controller;


import com.domain.Admin;
import com.exception.BadRequestAlertException;
import com.exception.NotFoundAlertException;
import com.service.AdminService;
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
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService)
    {
        this.adminService=adminService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @PostMapping("/admins")
    public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin admin) throws Exception
    {
        if(admin.getId() != 0 )
        {
            throw new BadRequestAlertException("A new admin cannot have an id value");
        }
        adminService.insert(admin);
        return ResponseEntity.created(new URI("/admins/")).body(admin);
    }

    @PutMapping("/admins")
    public ResponseEntity<Admin>update(@Valid @RequestBody Admin admin) throws Exception
    {
        if(admin.getId() == 0 )
        {
            throw new BadRequestAlertException("Invalid id");
        }
        adminService.update(admin);
        return ResponseEntity.created(new URI("/admins/")).body(admin);
    }
    @GetMapping ("/admins")
    public  ResponseEntity<List<Admin>> getAllAdmins()
    {
        List<Admin> admins = adminService.getAll();
        return ResponseEntity.ok().body(admins);
    }
    @GetMapping("/admins/{id}")
    public ResponseEntity <Admin> getAdmin(@PathVariable int id)
    {
        Optional<Admin> admin = Optional.ofNullable(adminService.get(id));
        if(admin.isPresent())
        {
            return ResponseEntity.ok().body(admin.get());
        }
        throw new NotFoundAlertException("Record not found[" +id+ "]");
    }

    @DeleteMapping("/admins/{id}")
    public  ResponseEntity<Admin> deleteAdmin(@PathVariable int id)
    {
        adminService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

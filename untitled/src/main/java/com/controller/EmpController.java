package com.controller;


import com.domain.Emp;
import com.exception.BadRequestAlertException;
import com.exception.NotFoundAlertException;
import com.service.EmpService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmpController {

    private EmpService empService;
    public EmpController(EmpService empService)
    {
        this.empService=empService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @PostMapping("/emps")
    public ResponseEntity<Emp> createEmp(@Valid @RequestBody Emp emp) throws Exception
    {
        if(emp.getId() != 0)
        {
           throw new BadRequestAlertException("A new Employee cannot have an id value");

        }
        empService.insert(emp);
        return ResponseEntity.created(new URI("/emps/")).body(emp);
    }

    @PutMapping("/emps")
    public ResponseEntity<Emp> updateEmp(@Valid @RequestBody Emp emp) throws Exception
    {
        if(emp.getId() == 0)
        {
            throw new BadRequestAlertException("Invalid id");
        }
        empService.update(emp);
        return ResponseEntity.created(new URI("/emps/")).body(emp);
    }

    @GetMapping("/emps")
    public ResponseEntity<List<Emp>> getAllEmp()
    {
        List<Emp> emps = empService.getAll();
        return ResponseEntity.ok().body(emps);
    }

    @GetMapping("/emps/{id}")
    public ResponseEntity<Emp> getEmp(@PathVariable int id)
    {
        Optional<Emp> emp = Optional.ofNullable(empService.get(id));
        if(emp.isPresent())
        {
            return ResponseEntity.ok().body(emp.get());
        }
        throw new NotFoundAlertException("Record not found for [" + id + "]");
    }

    @DeleteMapping("emps/{id}")
    public ResponseEntity<Emp> deleteEmp(@PathVariable int id)
    {
        empService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

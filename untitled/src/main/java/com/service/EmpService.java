package com.service;

import com.domain.Emp;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface EmpService{

    public Emp insert(Emp emp);

    public Emp get(int id);

    public List<Emp> getAll();

    public Emp update(Emp emp);

    public void delete(int id);


}

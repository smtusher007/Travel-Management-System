package com.service;


import com.domain.Emp;
import com.repository.EmpRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    private EmpRepository empRepository;
    private PasswordEncoder passwordEncoder;

    public EmpServiceImpl(EmpRepository empRepository, PasswordEncoder passwordEncoder)
    {
        this.empRepository = empRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Emp insert(Emp emp)
    {
        emp.setPassword(passwordEncoder.encode(emp.getPassword()));
        return  empRepository.create(emp);
    }

    @Transactional
    public Emp get(int id)
    {
        return empRepository.get(id);
    }

    @Transactional
    public List<Emp> getAll()
    {
        return empRepository.getAll();
    }

    @Transactional
    public Emp update(Emp emp)
    {
        return empRepository.update(emp);
    }

    @Transactional
    public void delete(int id)
    {
        empRepository.delete(id);
    }

    @Transactional
    public Emp getByEmail(String email)
    {
        return empRepository.getByEmail(email);
    }

   @Override
    public UserDetails loadUserByUsername(String email)
   {
       Emp emp = getByEmail(email);
       return new org.springframework.security.core.userdetails.User(emp.getEmail(), emp.getPassword(), emp.getAdmins());
   }
}

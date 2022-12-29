package com.service;


import com.domain.Admin;
import com.repository.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository)
    {
        this.adminRepository=adminRepository;
    }

    @Transactional
    public Admin insert(Admin admin)
    {
        return adminRepository.create(admin);
    }

    @Transactional(readOnly = true)
    public Admin get(int id)
    {
        return adminRepository.get(id);
    }

    @Transactional(readOnly = true)
    public List<Admin> getAll()
    {
        return adminRepository.getAll();
    }

    @Transactional
    public Admin update(Admin admin)
    {
        return adminRepository.update(admin);
    }

    @Transactional
    public void delete(int id)
    {
        adminRepository.delete(id);
    }
}

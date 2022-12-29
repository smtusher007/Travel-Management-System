package com.service;

import com.domain.Admin;

import java.util.List;

public interface AdminService {

    public Admin insert(Admin admin);

    public Admin get(int id);

    public List<Admin> getAll();

    public Admin update(Admin admin);

    public  void delete(int id);
}

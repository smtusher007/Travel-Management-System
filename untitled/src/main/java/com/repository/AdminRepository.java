package com.repository;

import com.domain.Admin;

import java.util.List;

public interface AdminRepository {

    public List<Admin> getAll();

    public  Admin create(Admin admin);

    public Admin get(int id);

    public Admin update(Admin admin);

    public void delete(int id);
}

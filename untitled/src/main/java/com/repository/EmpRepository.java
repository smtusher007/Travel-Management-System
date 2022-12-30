package com.repository;

import com.domain.Emp;

import java.util.List;

public interface EmpRepository {
    public List<Emp> getAll();

    public Emp create(Emp emp);

    public Emp get(int id);

    public Emp update(Emp emp );

    public void delete(int id);

    public Emp getByUsername(String username);
}

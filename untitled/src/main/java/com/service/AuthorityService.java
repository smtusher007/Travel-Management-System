package com.service;

import com.domain.Authority;

import java.util.List;

public interface AuthorityService {

    public Authority insert(Authority authority);

    public Authority get(long id);

    public List<Authority> getAll();

    public Authority update(Authority authority);

    public  void delete(long id);
}

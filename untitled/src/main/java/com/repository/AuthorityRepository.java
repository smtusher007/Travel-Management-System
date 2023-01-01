package com.repository;

import com.domain.Authority;

import java.util.List;

public interface AuthorityRepository {

    public List<Authority> getAll();

    public Authority create(Authority authority);

    public Authority get(long id);

    public Authority update(Authority authority);

    public void delete(long id);
}

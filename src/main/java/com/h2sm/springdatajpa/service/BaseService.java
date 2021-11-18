package com.h2sm.springdatajpa.service;

import java.util.List;

public interface BaseService<T> {
    T getByID(int id);
    List<T> getAll();
    void delete (int id);
    void save(T entity);
    void update(T entity);
}

package com.h2sm.springdatajpa.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface BaseService<T> {
    T getByID(int id);
    List<T> getAll();
    void delete (int id);
    void save(T entity);
    void update(T entity);
}

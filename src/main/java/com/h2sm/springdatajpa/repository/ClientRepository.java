package com.h2sm.springdatajpa.repository;

import com.h2sm.springdatajpa.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}

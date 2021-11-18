package com.h2sm.springdatajpa.service;

import com.h2sm.springdatajpa.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private ClientRepository clientRepository;
}

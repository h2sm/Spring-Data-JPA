package com.h2sm.springdatajpa.service.clientService;

import com.h2sm.springdatajpa.entity.Client;
import com.h2sm.springdatajpa.repository.ClientRepository;
import com.h2sm.springdatajpa.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@PersistenceContext
public class ClientService implements BaseService<Client> {
    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public Client getByID(int id) {
        return clientRepository.getById(id);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public void delete(int id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void save(Client entity) {
        clientRepository.save(entity);
    }

    @Override
    public void update(Client entity) {
        var entityID = entity.getId();
        if (entityID == getByID(entityID).getId()){//if exists
            save(entity);
        }
    }
}

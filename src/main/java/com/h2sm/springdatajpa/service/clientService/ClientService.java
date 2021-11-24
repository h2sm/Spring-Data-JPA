package com.h2sm.springdatajpa.service.clientService;

import com.h2sm.springdatajpa.entity.Client;
import com.h2sm.springdatajpa.repository.ClientRepository;
import com.h2sm.springdatajpa.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService implements BaseService<Client> {
    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public Client getByID(int id) {
        return clientRepository.findById(id).orElseThrow(EntityExistsException::new);
    }

    @Override
    @Transactional
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(int id) {
        clientRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void save(Client entity) {
        clientRepository.save(entity);
    }

    @Override
    @Transactional
    public void update(Client entity) {
        if (clientRepository.existsById(entity.getId())) save(entity);
        else throw new EntityNotFoundException();
    }
}

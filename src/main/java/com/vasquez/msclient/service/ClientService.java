package com.vasquez.msclient.service;

import com.vasquez.msclient.entity.Client;
import com.vasquez.msclient.repository.ClientRepository;
import com.vasquez.msclient.util.CrudUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientService implements CrudUtil<Client, String> {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Mono<Client> create(Client request) {
        return clientRepository.save(request);
    }

    @Override
    public Mono<Client> update(Client request, String s) {
        return clientRepository.save(request);
    }

    @Override
    public Mono<Client> findById(String id) {
        return clientRepository.findById(id);
    }

    @Override
    public Flux<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return clientRepository.deleteById(id);
    }
}

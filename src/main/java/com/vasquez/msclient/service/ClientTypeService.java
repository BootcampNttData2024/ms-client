package com.vasquez.msclient.service;

import com.vasquez.msclient.entity.ClientType;
import com.vasquez.msclient.model.ClientTypeRequest;
import com.vasquez.msclient.repository.ClientTypeRepository;
import com.vasquez.msclient.util.CrudUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientTypeService implements CrudUtil<ClientType, String> {

    private final ClientTypeRepository clientTypeRepository;

    public ClientTypeService(ClientTypeRepository clientTypeRepository) {
        this.clientTypeRepository = clientTypeRepository;
    }

    @Override
    public Mono<ClientType> create(ClientType request) {
        return clientTypeRepository.save(request);
    }

    @Override
    public Mono<ClientType> update(ClientType request, String id) {
        Mono<ClientType> clientType = this.findById(id);
        return clientTypeRepository.save(request);
    }

    @Override
    public Mono<ClientType> findById(String id) {
        return clientTypeRepository.findById(id);
    }

    @Override
    public Flux<ClientType> findAll() {
        return clientTypeRepository.findAll();
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return clientTypeRepository.deleteById(id);
    }
}

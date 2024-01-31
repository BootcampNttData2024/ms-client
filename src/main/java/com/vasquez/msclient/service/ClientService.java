package com.vasquez.msclient.service;

import com.vasquez.msclient.entity.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {

    Mono<Client> create(Client request);

    Mono<Client> update(Client request, String clientId);

    Mono<Client> findById(String clientId);

    Flux<Client> findAll();

    Mono<Void> deleteById(String clientId);

}

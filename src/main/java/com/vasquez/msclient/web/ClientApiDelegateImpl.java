package com.vasquez.msclient.web;

import com.vasquez.msclient.api.ClientApiDelegate;
import com.vasquez.msclient.model.ClientRequest;
import com.vasquez.msclient.model.ClientResponse;
import com.vasquez.msclient.service.ClientService;
import com.vasquez.msclient.web.mapper.ClientMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientApiDelegateImpl implements ClientApiDelegate {

    private final ClientService clientService;

    public ClientApiDelegateImpl(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public Mono<ClientResponse> addClient(Mono<ClientRequest> clientRequest, ServerWebExchange exchange) {
        return clientRequest.map(ClientMapper::toEntity)
                .flatMap(clientService::create)
                .map(ClientMapper::toResponse);
    }

    @Override
    public Mono<Void> deleteClientById(String clientId, ServerWebExchange exchange) {
        return clientService.deleteById(clientId);
    }

    @Override
    public Mono<Flux<ClientResponse>> getAllClients(ServerWebExchange exchange) {
        return Mono.just(clientService.findAll().map(ClientMapper::toResponse));
    }

    @Override
    public Mono<ClientResponse> getClientById(String clientId, ServerWebExchange exchange) {
        return clientService.findById(clientId).map(ClientMapper::toResponse);
    }

    @Override
    public Mono<ClientResponse> updateClient(String clientId, Mono<ClientRequest> clientRequest, ServerWebExchange exchange) {
        return clientRequest.map(ClientMapper::toEntity)
                .flatMap(cli -> clientService.update(cli, clientId))
                .map(ClientMapper::toResponse);
    }
}

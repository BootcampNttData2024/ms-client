package com.vasquez.msclient.controller;

import com.vasquez.msclient.api.ClientApi;
import com.vasquez.msclient.model.ClientRequest;
import com.vasquez.msclient.model.ClientResponse;
import com.vasquez.msclient.model.ClientTypeResponse;
import com.vasquez.msclient.model.DocumentTypeResponse;
import com.vasquez.msclient.controller.mapper.ClientMapper;
import com.vasquez.msclient.controller.mapper.ClientTypeMapper;
import com.vasquez.msclient.controller.mapper.DocumentTypeMapper;
import com.vasquez.msclient.service.ClientService;
import com.vasquez.msclient.service.ClientTypeService;
import com.vasquez.msclient.service.DocumentTypeService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ClientRestController implements ClientApi {

    private final ClientMapper clientMapper;
    private final ClientTypeMapper clientTypeMapper;
    private final DocumentTypeMapper documentTypeMapper;
    private final ClientService clientService;
    private final ClientTypeService clientTypeService;
    private final DocumentTypeService documentTypeService;

    public ClientRestController(ClientService clientService, ClientMapper clientMapper, ClientTypeMapper clientTypeMapper, DocumentTypeMapper documentTypeMapper, ClientTypeService clientTypeService, DocumentTypeService documentTypeService) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
        this.clientTypeMapper = clientTypeMapper;
        this.documentTypeMapper = documentTypeMapper;
        this.clientTypeService = clientTypeService;
        this.documentTypeService = documentTypeService;
    }

    @Override
    public Mono<ClientResponse> addClient(Mono<ClientRequest> body, ServerWebExchange exchange) {
        return clientService.create(clientMapper.toEntity(body))
                .map(c -> {
                    ClientTypeResponse clientTypeResponse = clientTypeMapper
                            .toResponse(clientTypeService.findById(c.getClientTypeId()));

                    DocumentTypeResponse documentTypeResponse = documentTypeMapper
                            .toResponse(documentTypeService.findById(c.getDocumentTypeId()));
                    ClientResponse client = clientMapper.toResponse(c);
                    client.setClientType(clientTypeResponse);
                    client.setDocumentType(documentTypeResponse);
                    return client;
                });
    }

    @Override
    public Mono<Void> deleteClientById(String clientId, ServerWebExchange exchange) {
        return clientService.deleteById(clientId);
    }

    @Override
    public Mono<Flux<ClientResponse>> getAllClients(ServerWebExchange exchange) {
        return Mono.just(clientService.findAll()
                .map(clientMapper::toResponse));
    }

    @Override
    public Mono<ClientResponse> getClientById(String clientId, ServerWebExchange exchange) {
        return clientService.findById(clientId)
                .map(clientMapper::toResponse);
    }

    @Override
    public Mono<ClientResponse> updateClient(String clientId, Mono<ClientRequest> clientRequest, ServerWebExchange exchange) {
        return clientService.update(clientMapper.toEntity(clientRequest), clientId)
                .map(clientMapper::toResponse);
    }


}

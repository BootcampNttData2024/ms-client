package com.vasquez.msclient.controller;

import com.vasquez.msclient.api.ClientTypeApi;
import com.vasquez.msclient.model.ClientTypeRequest;
import com.vasquez.msclient.controller.mapper.ClientTypeMapper;
import com.vasquez.msclient.model.ClientTypeResponse;
import com.vasquez.msclient.service.ClientTypeService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ClientTypeRestController implements ClientTypeApi {

    private final ClientTypeMapper clientTypeMapper;
    private final ClientTypeService clientTypeService;

    public ClientTypeRestController(ClientTypeMapper clientTypeMapper, ClientTypeService clientTypeService) {
        this.clientTypeMapper = clientTypeMapper;
        this.clientTypeService = clientTypeService;
    }

    @Override
    public Mono<ClientTypeResponse> addClientType(Mono<ClientTypeRequest> body, ServerWebExchange exchange) {
        return clientTypeService.create(clientTypeMapper.toEntity(body))
                .map(clientTypeMapper::toResponse);
    }

    @Override
    public Mono<Void> deleteClientTypeById(String clientTypeId, ServerWebExchange exchange) {
        return clientTypeService.deleteById(clientTypeId);
    }

    @Override
    public Mono<Flux<ClientTypeResponse>> getAllClientType(ServerWebExchange exchange) {
        return Mono.just(clientTypeService.findAll()
                .map(clientTypeMapper::toResponse));
    }

    @Override
    public Mono<ClientTypeResponse> getClientTypeById(String clientTypeId, ServerWebExchange exchange) {
        return clientTypeService.findById(clientTypeId)
                .map(clientTypeMapper::toResponse);
    }

    @Override
    public Mono<ClientTypeResponse> updateClientType(String clientTypeId, Mono<ClientTypeRequest> body, ServerWebExchange exchange) {
        return clientTypeService.update(clientTypeMapper.toEntity(body), clientTypeId)
                .map(clientTypeMapper::toResponse);
    }
}

package com.vasquez.msclient.web;

import com.vasquez.msclient.api.ClientProfileApiDelegate;
import com.vasquez.msclient.model.ClientProfileRequest;
import com.vasquez.msclient.model.ClientProfileResponse;
import com.vasquez.msclient.service.ClientProfileService;
import com.vasquez.msclient.web.mapper.ClientProfileMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientProfileApiDelegateImpl implements ClientProfileApiDelegate {

    private final ClientProfileService clientProfileService;

    public ClientProfileApiDelegateImpl(ClientProfileService clientProfileService) {
        this.clientProfileService = clientProfileService;
    }

    @Override
    public Mono<ClientProfileResponse> addClientProfile(Mono<ClientProfileRequest> clientProfileRequest, ServerWebExchange exchange) {
        return clientProfileRequest.map(ClientProfileMapper::toEntity)
                .flatMap(clientProfileService::create)
                .map(ClientProfileMapper::toResponse);
    }

    @Override
    public Mono<Void> deleteClientProfileById(String clientProfileId, ServerWebExchange exchange) {
        return clientProfileService.deleteById(clientProfileId);
    }

    @Override
    public Mono<Flux<ClientProfileResponse>> getAllClientProfile(ServerWebExchange exchange) {
        return Mono.just(clientProfileService.findAll().map(ClientProfileMapper::toResponse));
    }

    @Override
    public Mono<ClientProfileResponse> getClientProfileById(String clientProfileId, ServerWebExchange exchange) {
        return clientProfileService.findById(clientProfileId).map(ClientProfileMapper::toResponse);
    }

    @Override
    public Mono<ClientProfileResponse> updateClientProfile(String clientProfileId, Mono<ClientProfileRequest> clientProfileRequest, ServerWebExchange exchange) {
        return clientProfileRequest.map(ClientProfileMapper::toEntity)
                .flatMap(cli -> clientProfileService.update(cli, clientProfileId))
                .map(ClientProfileMapper::toResponse);
    }

}

package com.vasquez.msclient.web;

import com.vasquez.msclient.api.ClientApiDelegate;
import com.vasquez.msclient.model.ClientRequest;
import com.vasquez.msclient.model.ClientResponse;
import com.vasquez.msclient.service.ClientService;
import com.vasquez.msclient.web.mapper.ClientMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Client api delegate class.
 *
 * @author Vasquez
 * @version 1.0.
 */
@Service
public class ClientApiDelegateImpl implements ClientApiDelegate {

  private final ClientService clientService;

  public ClientApiDelegateImpl(ClientService clientService) {
    this.clientService = clientService;
  }

  @Override
  public Mono<ResponseEntity<ClientResponse>> addClient(Mono<ClientRequest> clientRequest, ServerWebExchange exchange) {
    return clientRequest
      .map(ClientMapper::toEntity)
      .flatMap(clientService::create)
      .map(ClientMapper::toResponse)
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Void>> deleteClientById(String clientId, ServerWebExchange exchange) {
    return clientService.deleteById(clientId)
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Flux<ClientResponse>>> getAllClients(ServerWebExchange exchange) {
    return Mono.just(clientService.findAll()
        .map(ClientMapper::toResponse))
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<ClientResponse>> getClientById(String clientId, ServerWebExchange exchange) {
    return clientService.findById(clientId)
      .map(ClientMapper::toResponse)
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<ClientResponse>> updateClient(String clientId, Mono<ClientRequest> clientRequest, ServerWebExchange exchange) {
    return clientRequest
      .map(ClientMapper::toEntity)
      .flatMap(cli -> clientService.update(cli, clientId))
      .map(ClientMapper::toResponse)
      .map(ResponseEntity::ok);
  }
}

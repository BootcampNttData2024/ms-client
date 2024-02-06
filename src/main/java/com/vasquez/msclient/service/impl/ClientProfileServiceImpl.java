package com.vasquez.msclient.service.impl;

import com.vasquez.msclient.entity.ClientProfile;
import com.vasquez.msclient.repository.ClientProfileRepository;
import com.vasquez.msclient.service.ClientProfileService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Client profile service implementation.
 *
 * @author Vasquez
 * @version 1.0.
 */
@Service
public class ClientProfileServiceImpl implements ClientProfileService {

  private final ClientProfileRepository clientProfileRepository;

  public ClientProfileServiceImpl(ClientProfileRepository clientProfileRepository) {
    this.clientProfileRepository = clientProfileRepository;
  }

  @Override
  public Mono<ClientProfile> create(ClientProfile request) {
    return clientProfileRepository.save(request);
  }

  @Override
  public Mono<ClientProfile> update(ClientProfile request, String id) {
    return this.findById(id).flatMap(typ -> {
      typ.setName(request.getName());
      return clientProfileRepository.save(typ);
    });
  }

  @Override
  public Mono<ClientProfile> findById(String id) {
    return clientProfileRepository.findById(id);
  }

  @Override
  public Flux<ClientProfile> findAll() {
    return clientProfileRepository.findAll();
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return clientProfileRepository.deleteById(id);
  }
}

package com.vasquez.msclient.business;

import com.vasquez.msclient.entity.ClientProfile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Client profile service interface.
 *
 * @author Vasquez
 * @version 1.0.
 */
public interface ClientProfileService {

  Mono<ClientProfile> create(ClientProfile request);

  Mono<ClientProfile> update(ClientProfile request, String clientProfileId);

  Mono<ClientProfile> findById(String clientProfileId);

  Flux<ClientProfile> findAll();

  Mono<Void> deleteById(String clientProfileId);

}

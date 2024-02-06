package com.vasquez.msclient.service.impl;

import com.vasquez.msclient.entity.Client;
import com.vasquez.msclient.entity.enums.ClientProfile;
import com.vasquez.msclient.entity.enums.ClientType;
import com.vasquez.msclient.repository.ClientRepository;
import com.vasquez.msclient.service.ClientService;
import com.vasquez.msclient.service.exception.AppException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Client service implementation.
 *
 * @author Vasquez
 * @version 1.0.
 */
@Service
public class ClientServiceImpl implements ClientService {

  private final ClientRepository clientRepository;
  private final ClientProfileServiceImpl clientProfileService;

  public ClientServiceImpl(ClientRepository clientRepository, ClientProfileServiceImpl clientProfileService) {
    this.clientRepository = clientRepository;
    this.clientProfileService = clientProfileService;
  }

  @Override
  public Mono<Client> create(Client request) {
    return clientProfileService.findById(request.getProfileId())
      .flatMap(profile -> {
        //personal client
        if (ClientType.PERSONAL.getValue().equals(request.getClientType())) {
          if (ClientProfile.VIP.getValue().equals(profile.getName()))
            return clientRepository.save(request);
          else
            return Mono.error(AppException
              .badRequest("The " + profile.getName() + " profile is not available for the " + request.getClientType() + " client type"));
        }
        //business client
        if (ClientProfile.PYME.getValue().equals(profile.getName()))
          return clientRepository.save(request);
        else
          return Mono.error(AppException
            .badRequest("The " + profile.getName() + " profile is not available for the " + request.getClientType() + " client type"));
      }).switchIfEmpty(clientRepository.save(request));
  }

  @Override
  public Mono<Client> update(Client request, String id) {
    return this.findById(id).flatMap(cli -> {
      cli.setClientId(request.getClientId());
      cli.setProfileId(request.getProfileId());
      cli.setFirstName(request.getFirstName());
      cli.setLastName(request.getLastName());
      cli.setEmail(request.getEmail());
      cli.setPhoneNumber(request.getPhoneNumber());
      cli.setAddress(request.getAddress());
      return clientRepository.save(cli);
    });
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

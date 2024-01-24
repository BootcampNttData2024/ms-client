package com.vasquez.msclient.controller.mapper;

import com.vasquez.msclient.model.ClientRequest;
import com.vasquez.msclient.model.ClientResponse;
import com.vasquez.msclient.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import reactor.core.publisher.Mono;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toEntity(Mono<ClientRequest> clientRequestMono);

    //@Mapping(source = "clientTypeId", target = "clientType")
    ClientResponse toResponse(Client client);

}

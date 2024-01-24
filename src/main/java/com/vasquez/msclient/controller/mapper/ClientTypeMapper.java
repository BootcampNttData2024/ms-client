package com.vasquez.msclient.controller.mapper;

import com.vasquez.msclient.model.ClientTypeRequest;
import com.vasquez.msclient.model.ClientTypeResponse;
import com.vasquez.msclient.entity.ClientType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import reactor.core.publisher.Mono;

@Mapper(componentModel = "spring")
public interface ClientTypeMapper {

    ClientType toEntity(Mono<ClientTypeRequest> clientTypeRequestMono);

    ClientTypeResponse toResponse(ClientType clientType);

    ClientTypeResponse toResponse(Mono<ClientType> clientTypeMono);

}

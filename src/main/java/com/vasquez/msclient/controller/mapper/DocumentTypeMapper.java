package com.vasquez.msclient.controller.mapper;

import com.vasquez.msclient.model.DocumentTypeRequest;
import com.vasquez.msclient.model.DocumentTypeResponse;
import com.vasquez.msclient.entity.DocumentType;
import org.mapstruct.Mapper;
import reactor.core.publisher.Mono;

@Mapper(componentModel = "spring")
public interface DocumentTypeMapper {

    DocumentType toEntity(Mono<DocumentTypeRequest> documentTypeRequestMono);

    DocumentTypeResponse toResponse(DocumentType documentTypeMono);

    DocumentTypeResponse toResponse(Mono<DocumentType> documentTypeMono);

}

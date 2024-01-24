package com.vasquez.msclient.controller;

import com.vasquez.msclient.api.DocumentTypeApi;
import com.vasquez.msclient.model.DocumentTypeRequest;
import com.vasquez.msclient.model.DocumentTypeResponse;
import com.vasquez.msclient.controller.mapper.DocumentTypeMapper;
import com.vasquez.msclient.service.DocumentTypeService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class DocumentTypeRestController implements DocumentTypeApi {

    private final DocumentTypeMapper documentTypeMapper;
    private final DocumentTypeService documentTypeService;

    public DocumentTypeRestController(DocumentTypeMapper documentTypeMapper, DocumentTypeService documentTypeService) {
        this.documentTypeMapper = documentTypeMapper;
        this.documentTypeService = documentTypeService;
    }

    @Override
    public Mono<DocumentTypeResponse> addDocumentType(Mono<DocumentTypeRequest> body, ServerWebExchange exchange) {
        return documentTypeService.create(documentTypeMapper.toEntity(body))
                .map(documentTypeMapper::toResponse);
    }

    @Override
    public Mono<Void> deleteDocumentTypeById(String documentTypeId, ServerWebExchange exchange) {
        return documentTypeService.deleteById(documentTypeId);
    }

    @Override
    public Mono<Flux<DocumentTypeResponse>> getAllDocumentType(ServerWebExchange exchange) {
        return Mono.just(documentTypeService.findAll().map(documentTypeMapper::toResponse));
    }

    @Override
    public Mono<DocumentTypeResponse> getDocumentTypeById(String documentTypeId, ServerWebExchange exchange) {
        return documentTypeService.findById(documentTypeId)
                .map(documentTypeMapper::toResponse);
    }

    @Override
    public Mono<DocumentTypeResponse> updateDocumentType(String documentTypeId, Mono<DocumentTypeRequest> body, ServerWebExchange exchange) {
        return documentTypeService.update(documentTypeMapper.toEntity(body), documentTypeId)
                .map(documentTypeMapper::toResponse);
    }
}

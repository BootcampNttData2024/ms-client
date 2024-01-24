package com.vasquez.msclient.service;

import com.vasquez.msclient.entity.DocumentType;
import com.vasquez.msclient.repository.DocumentTypeRepository;
import com.vasquez.msclient.util.CrudUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DocumentTypeService implements CrudUtil<DocumentType, String> {

    private final DocumentTypeRepository documentTypeRepository;

    public DocumentTypeService(DocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
    }

    @Override
    public Mono<DocumentType> create(DocumentType request) {
        return documentTypeRepository.save(request);
    }

    @Override
    public Mono<DocumentType> update(DocumentType request, String id) {
        Mono<DocumentType> documentType = findById(id);
        return documentTypeRepository.save(request);
    }

    @Override
    public Mono<DocumentType> findById(String id) {
        return documentTypeRepository.findById(id);
    }

    @Override
    public Flux<DocumentType> findAll() {
        return documentTypeRepository.findAll();
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return documentTypeRepository.deleteById(id);
    }
}

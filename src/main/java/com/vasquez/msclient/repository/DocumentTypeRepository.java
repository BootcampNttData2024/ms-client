package com.vasquez.msclient.repository;

import com.vasquez.msclient.entity.DocumentType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepository extends ReactiveMongoRepository<DocumentType, String> {
}

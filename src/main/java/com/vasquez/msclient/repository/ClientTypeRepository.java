package com.vasquez.msclient.repository;

import com.vasquez.msclient.entity.ClientType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientTypeRepository extends ReactiveMongoRepository<ClientType, String> {
}

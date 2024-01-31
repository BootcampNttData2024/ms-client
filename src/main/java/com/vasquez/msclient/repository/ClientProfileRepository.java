package com.vasquez.msclient.repository;

import com.vasquez.msclient.entity.ClientProfile;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientProfileRepository extends ReactiveMongoRepository<ClientProfile, String> {
}

package com.vasquez.msclient.repository;

import com.vasquez.msclient.entity.ClientProfile;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Client profile repository.
 *
 * @author Vasquez
 * @version 1.0.
 */
@Repository
public interface ClientProfileRepository extends ReactiveMongoRepository<ClientProfile, String> {
}

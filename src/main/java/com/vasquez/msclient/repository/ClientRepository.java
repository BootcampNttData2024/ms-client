package com.vasquez.msclient.repository;

import com.vasquez.msclient.entity.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Client repository.
 *
 * @author Vasquez
 * @version 1.0.
 */
@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, String> {
}

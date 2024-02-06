package com.vasquez.msclient.web.mapper;

import com.vasquez.msclient.entity.Client;
import com.vasquez.msclient.model.ClientRequest;
import com.vasquez.msclient.model.ClientResponse;
import org.springframework.beans.BeanUtils;

/**
 * Client mapper class.
 *
 * @author Vasquez
 * @version 1.0.
 */
public class ClientMapper {

  /**
   * To client request.
   *
   * @param clientRequest clientRequest
   * @return Client
   */
  public static Client toEntity(ClientRequest clientRequest) {
    Client client = new Client();
    BeanUtils.copyProperties(clientRequest, client);
    return client;
  }

  /**
   * To client response.
   *
   * @param client client
   * @return ClientResponse
   */
  public static ClientResponse toResponse(Client client) {
    ClientResponse clientResponse = new ClientResponse();
    BeanUtils.copyProperties(client, clientResponse);
    return clientResponse;
  }

}

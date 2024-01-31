package com.vasquez.msclient.web.mapper;

import com.vasquez.msclient.entity.Client;
import com.vasquez.msclient.model.ClientRequest;
import com.vasquez.msclient.model.ClientResponse;
import org.springframework.beans.BeanUtils;

public class ClientMapper {

    public static Client toEntity(ClientRequest ClientRequest) {
        Client client = new Client();
        BeanUtils.copyProperties(ClientRequest, client);
        return client;
    }

    public static ClientResponse toResponse(Client Client) {
        ClientResponse clientResponse = new ClientResponse();
        BeanUtils.copyProperties(Client, clientResponse);
        return clientResponse;
    }

}

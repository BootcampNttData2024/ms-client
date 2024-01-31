package com.vasquez.msclient.web.mapper;

import com.vasquez.msclient.entity.ClientProfile;
import com.vasquez.msclient.model.ClientProfileRequest;
import com.vasquez.msclient.model.ClientProfileResponse;
import org.springframework.beans.BeanUtils;

public class ClientProfileMapper {

    public static ClientProfile toEntity(ClientProfileRequest clientTypeRequest) {
        ClientProfile clientType = new ClientProfile();
        BeanUtils.copyProperties(clientTypeRequest, clientType);
        return clientType;
    }

    public static ClientProfileResponse toResponse(ClientProfile clientType) {
        ClientProfileResponse clientTypeResponse = new ClientProfileResponse();
        BeanUtils.copyProperties(clientType, clientTypeResponse);
        return clientTypeResponse;
    }

}

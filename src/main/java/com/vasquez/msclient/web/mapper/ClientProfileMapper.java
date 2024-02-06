package com.vasquez.msclient.web.mapper;

import com.vasquez.msclient.entity.ClientProfile;
import com.vasquez.msclient.model.ClientProfileRequest;
import com.vasquez.msclient.model.ClientProfileResponse;
import org.springframework.beans.BeanUtils;

/**
 * Client profile mapper class.
 *
 * @author Vasquez
 * @version 1.0.
 */
public class ClientProfileMapper {

  /**
   * To client profile request.
   *
   * @param clientTypeRequest clientTypeRequest
   * @return ClientProfile
   */
  public static ClientProfile toEntity(ClientProfileRequest clientTypeRequest) {
    ClientProfile clientType = new ClientProfile();
    BeanUtils.copyProperties(clientTypeRequest, clientType);
    return clientType;
  }

  /**
   * To client profile response.
   *
   * @param clientType clientType
   * @return ClientProfileResponse
   */
  public static ClientProfileResponse toResponse(ClientProfile clientType) {
    ClientProfileResponse clientTypeResponse = new ClientProfileResponse();
    BeanUtils.copyProperties(clientType, clientTypeResponse);
    return clientTypeResponse;
  }

}

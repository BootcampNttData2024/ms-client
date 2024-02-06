package com.vasquez.msclient.entity.enums;

import lombok.Getter;

/**
 * Client profile.
 *
 * @author Vasquez
 * @version 1.0.
 */
@Getter
public enum ClientProfile {

  VIP("VIP"),
  PYME("PYME");
  private String value;

  ClientProfile(String value) {
    this.value = value;
  }

}

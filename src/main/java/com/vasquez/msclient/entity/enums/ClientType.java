package com.vasquez.msclient.entity.enums;

import lombok.Getter;

/**
 * Client profile enum.
 *
 * @author Vasquez
 * @version 1.0.
 */
@Getter
public enum ClientType {

  PERSONAL("PERSONAL"),
  BUSINESS("EMPRESARIAL");
  private String value;

  ClientType(String value) {
    this.value = value;
  }

}

package com.vasquez.msclient.entity.enums;

import lombok.Getter;

@Getter
public enum ClientProfile {

    VIP("VIP"),
    PYME("PYME");
    private String value;

    ClientProfile(String value) {
        this.value = value;
    }

}

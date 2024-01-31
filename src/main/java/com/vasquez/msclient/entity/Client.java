package com.vasquez.msclient.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "client")
public class Client {

    @Id
    private String  clientId;

    @NotNull
    private String profileId;

    @NotNull
    private String clientType;

    @NotNull
    private String documentType;

    @NotNull
    private Integer documentNumber;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private Integer phoneNumber;

    private String address;

}

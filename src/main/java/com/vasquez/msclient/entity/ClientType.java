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
@Document(collection = "client_type")
public class ClientType {

    @Id
    private String clientTypeId;

    @NotNull
    private String name;

}

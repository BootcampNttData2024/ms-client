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
@Document(collection = "client_profile")
public class ClientProfile {

    @Id
    private String profileId;

    @NotNull
    private String name;

}

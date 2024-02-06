package com.vasquez.msclient.entity;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Client entity.
 *
 * @author Vasquez
 * @version 1.0.
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "client")
public class Client {

  @Id
  private String clientId;

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

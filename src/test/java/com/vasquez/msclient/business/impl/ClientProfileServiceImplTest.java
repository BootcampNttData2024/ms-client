package com.vasquez.msclient.business.impl;

import com.vasquez.msclient.entity.ClientProfile;
import com.vasquez.msclient.repository.ClientProfileRepository;
import com.vasquez.msclient.business.ClientProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClientProfileServiceImplTest {

  @MockBean
  private ClientProfileRepository clientProfileRepository;
  @Autowired
  private ClientProfileService clientProfileService;
  private ClientProfile clientProfile;
  private final String PROFILE_ID = "1";
  private final String NAME = "VIP";

  @BeforeEach
  void setUp() {
    clientProfile = new ClientProfile();
    clientProfile.setProfileId(PROFILE_ID);
    clientProfile.setName(NAME);
  }

  @Test
  void findById() {
    when(clientProfileRepository.findById(PROFILE_ID)).thenReturn(Mono.just(clientProfile));
    Mono<ClientProfile> clientProfileMono = clientProfileService.findById(PROFILE_ID);
    StepVerifier
      .create(clientProfileMono)
      .consumeNextWith(newClient -> {
        assertEquals(newClient.getName(), NAME);
      })
      .verifyComplete();
  }

  @Test
  void findAll() {

  }
}
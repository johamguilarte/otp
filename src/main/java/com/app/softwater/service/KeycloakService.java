package com.app.softwater.service;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;

public interface KeycloakService {

    public String createUser(String username, String email, String password);
    public Keycloak getInstance();
    public UserRepresentation getUserById(String userId);
}

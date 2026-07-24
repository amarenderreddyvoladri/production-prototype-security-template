package com.harinitech.springboot_security_jwt_rbac_app1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harinitech.springboot_security_jwt_rbac_app1.model.JwtRequest;
import com.harinitech.springboot_security_jwt_rbac_app1.support.AbstractSecurityIntegrationTest;
import com.harinitech.springboot_security_jwt_rbac_app1.utility.JwtUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SecurityGatingIntegrationTest extends AbstractSecurityIntegrationTest {

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("POST /api/v1/auth/login rejects invalid credentials")
    void loginEndpointRejectsInvalidCredentials() throws Exception {
        JwtRequest loginRequest = new JwtRequest();
        loginRequest.setUsername("nonexistent@domain.com");
        loginRequest.setPassword("WrongPassword123");

        mockMvc.perform(post("/api/v1/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("GET /api/v1/users/me denies anonymous access")
    void securedEndpointDeniesAnonymous() throws Exception {
        mockMvc.perform(get("/api/v1/users/me"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("GET /api/v1/admin/statistics/security denies regular user role access")
    void userTokenIsForbiddenOnAdminRoute() throws Exception {
        // Generate a valid Access Token for a regular USER role
        String userToken = jwtUtility.generateAccessToken(100L, "USER", Set.of("VIEW_PROFILE"));

        mockMvc.perform(get("/api/v1/admin/statistics/security")
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("GET /api/v1/admin/statistics/security allows admin access with correct permission")
    void adminTokenIsAllowedOnAdminRoute() throws Exception {
        // Generate a valid Access Token for an ADMIN role with VIEW_SECURITY_STATISTICS permission
        String adminToken = jwtUtility.generateAccessToken(1L, "ADMIN", Set.of("VIEW_SECURITY_STATISTICS"));

        mockMvc.perform(get("/api/v1/admin/statistics/security")
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));
    }

    @Test
    @DisplayName("Security Gating: tampered token signature gets rejected")
    void tamperedTokenSignatureIsRejected() throws Exception {
        String validToken = jwtUtility.generateAccessToken(100L, "USER", Set.of("VIEW_PROFILE"));
        
        // Modify the signature portion of the JWT (split by dot)
        String[] parts = validToken.split("\\.");
        if (parts.length == 3) {
            String tamperedToken = parts[0] + "." + parts[1] + "." + parts[2] + "TamperedExtraBytes";

            mockMvc.perform(get("/api/v1/users/me")
                            .header("Authorization", "Bearer " + tamperedToken))
                    .andExpect(status().isUnauthorized());
        }
    }
}

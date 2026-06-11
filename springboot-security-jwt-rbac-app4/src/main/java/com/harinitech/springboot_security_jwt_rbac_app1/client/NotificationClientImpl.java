package com.harinitech.springboot_security_jwt_rbac_app1.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.harinitech.springboot_security_jwt_rbac_app1.dto.SendNotificationRequest;
import com.harinitech.springboot_security_jwt_rbac_app1.exceptions.NotificationServiceException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ✅ PRODUCTION NotificationClientImpl
 *
 * WebClient-based HTTP client for notification-service.
 *
 * Sends a POST to  {notification.service.url}/api/v1/notifications
 * with an internal API key header so notification-service can
 * allow this call without requiring a JWT.
 *
 * Do NOT call this directly from services — use NotificationFacade.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationClientImpl implements NotificationClient {

    private final WebClient.Builder webClientBuilder;

    @Value("${notification.service.url}")
    private String notificationServiceUrl;

    @Value("${notification.service.internal-api-key}")
    private String internalApiKey;

    @Override
    public void sendNotification(SendNotificationRequest request) {

        log.info(
            "Calling Notification Service | recipient={} | type={}",
            request.getRecipient(),
            request.getType()
        );

        try {

            webClientBuilder.build()
                    .post()
                    .uri(notificationServiceUrl + "/api/v1/notifications")
                    .contentType(MediaType.APPLICATION_JSON)
                    .header("X-Internal-Api-Key", internalApiKey)
                    .bodyValue(request)
                    .retrieve()
                    .onStatus(
                        HttpStatusCode::isError,
                        response -> response.bodyToMono(String.class)
                                .map(error -> new NotificationServiceException(
                                        "Notification service returned error: " + error))
                    )
                    .toBodilessEntity()
                    .block();

            log.info(
                "Notification Service call successful | recipient={} | type={}",
                request.getRecipient(),
                request.getType()
            );

        } catch (NotificationServiceException ex) {

            throw ex;

        } catch (Exception ex) {

            log.error(
                "Notification Service unreachable | recipient={} | type={} | error={}",
                request.getRecipient(),
                request.getType(),
                ex.getMessage(),
                ex
            );

            throw new NotificationServiceException(
                    "Failed to communicate with notification service", ex);
        }
    }
}

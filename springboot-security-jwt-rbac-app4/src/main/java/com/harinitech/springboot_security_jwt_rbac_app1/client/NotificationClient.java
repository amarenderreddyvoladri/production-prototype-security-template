package com.harinitech.springboot_security_jwt_rbac_app1.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.harinitech.springboot_security_jwt_rbac_app1.dto.SendNotificationRequest;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NotificationClient {

	private final WebClient.Builder webClientBuilder;

	@Value("${notification.service.url}")
	private String notificationServiceUrl;

	public void sendNotification(String recipient, String subject, String content, String notificationType) {

		SendNotificationRequest request = new SendNotificationRequest(recipient, subject, content, notificationType);

		ResponseEntity<Void> response = webClientBuilder.build().post()
				.uri(notificationServiceUrl + "/api/v1/notifications/send").bodyValue(request).retrieve()
				.toBodilessEntity().block();

		if (response == null || !response.getStatusCode().is2xxSuccessful()) {
			throw new RuntimeException("Notification service call failed");
		}
	}
}
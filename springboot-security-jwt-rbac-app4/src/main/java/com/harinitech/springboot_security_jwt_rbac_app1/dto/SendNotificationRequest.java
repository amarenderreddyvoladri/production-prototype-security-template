package com.harinitech.springboot_security_jwt_rbac_app1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendNotificationRequest {

	private String recipient;
	private String subject;
	private String content;
	private String notificationType;
}
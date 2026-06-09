package com.harinitech.notification_service.service;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SendGridEmailProviderImpl implements EmailProvider {

	@Override
	public void sendEmail(String recipient, String subject, String body) {

		// SendGrid implementation later

	}
}
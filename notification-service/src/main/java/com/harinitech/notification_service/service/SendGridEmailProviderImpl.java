package com.harinitech.notification_service.service;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SendGridEmailProviderImpl
        implements EmailProvider {

    @Override
    public void sendEmail(
            String recipient,
            String subject,
            String body) {

        log.info(
            "Sending email | recipient={} | subject={}",
            recipient,
            subject
        );

        /*
         * TODO:
         * Implement SendGrid integration.
         *
         * Expected flow:
         * 1. Build Mail object
         * 2. Call SendGrid API
         * 3. Validate response status
         * 4. Throw EmailDeliveryException on failure
         */
    }
}
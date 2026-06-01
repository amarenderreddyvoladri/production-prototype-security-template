package com.harinitech.springboot_security_jwt_rbac_app1.config;

import java.util.TimeZone;

import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class TimeZoneConfig {

	@PostConstruct
	public void init() {

		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));

		System.out.println("Application TimeZone set to: " + TimeZone.getDefault().getID());
	}
}
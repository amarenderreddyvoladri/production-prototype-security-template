package com.harinitech.eureka_server.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupLogger implements ApplicationRunner {

	private static final Logger log = LoggerFactory.getLogger(StartupLogger.class);

	@Override
	public void run(ApplicationArguments args) {

		log.info("====================================================");
		log.info("           EUREKA SERVER STARTED SUCCESSFULLY");
		log.info("====================================================");
		log.info("Dashboard URL : http://localhost:8761");
		log.info("Health Check  : http://localhost:8761/actuator/health");
		log.info("====================================================");
	}
}
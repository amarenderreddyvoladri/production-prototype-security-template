package com.harinitech.springboot_security_jwt_rbac_app1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

@Configuration
@EnableSpringDataWebSupport
public class PaginationConfig {

	@Bean
	PageableHandlerMethodArgumentResolverCustomizer paginationCustomizer() {

		return pageable -> {

			pageable.setFallbackPageable(PageRequest.of(0, 10));

			pageable.setMaxPageSize(100);

			pageable.setOneIndexedParameters(false);
		};
	}
}
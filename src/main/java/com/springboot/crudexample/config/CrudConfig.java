package com.springboot.crudexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class CrudConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("CRUD Swagger").apiInfo(apiInfo()).select()
				.paths(regex("/api/v1/crud.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Crud Example").description("Swagger2 implementation for Crud application")
			.version("1.0").build();
	}
}
//.termsOfServiceUrl("https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ")
//.license("Crud Example")
//.licenseUrl("https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ")
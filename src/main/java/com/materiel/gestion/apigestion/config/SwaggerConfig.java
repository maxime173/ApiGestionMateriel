package com.materiel.gestion.apigestion.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import io.swagger.models.auth.In;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.securitySchemes(Arrays.asList(new ApiKey("JWT", HttpHeaders.AUTHORIZATION, In.HEADER.name())))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.materiel.gestion.apigestion.controller"))
				.paths(PathSelectors.ant("/api/v1/**"))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Api Gestion Matériel")
				.description("API Gestion Matériel")
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.termsOfServiceUrl("")
				.version("1.0.0")
				.contact(new Contact("", "", "etienne.picherit@gmail.com"))
				.build();
	}
	
	 @Bean SecurityConfiguration security() {
		 return SecurityConfigurationBuilder.builder().build();
	 }
}
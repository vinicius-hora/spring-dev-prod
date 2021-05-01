package com.devandprod.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {
	
	private String driverClassName;
	private String url;
	private String userName;
	private String password;
	
	
	@Profile("dev")
	@Bean
	public String testdatabaseConnection() {
		System.out.println("DB connection for DEV - H2");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB Connectuon to H2_TEST - Test instance";
	}
	
	@Profile("prod")
	@Bean
	public String productiondatabaseConnection() {
		System.out.println("DB connection for Production - MYSQL");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB Connectuon to MYSQL_PROD - Production instance";
	}
	
	

}

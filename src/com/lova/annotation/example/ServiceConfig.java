package com.lova.annotation.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ServiceConfig {
    @Bean(name="service_1")
	public Service service_1() {
		return new Service();
	}
	
    @Bean(name="service_2")
    @Scope("prototype")
	public Service service_2() {
		return new Service();
	}

    
	
}

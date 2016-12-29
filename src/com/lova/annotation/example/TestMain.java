package com.lova.annotation.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {

	public static void main(String[] args) {

		String name="Prepare things........";
		ApplicationContext context = new AnnotationConfigApplicationContext(
				ServiceConfig.class);
		Service ser_1 = (Service) context.getBean("service_1");
		ser_1.setMessage("Hello Jenny Bhai");
		
		Service ser_2 = (Service) context.getBean("service_2");
		ser_1.setMessage("Hello Jenny Bhai");
		

		Service ser_3 = (Service) context.getBean("service_2");
		ser_1.setMessage("Hello Jenny Bhai");
		
		Service ser_4 = (Service) context.getBean("service_1");
		ser_4.setMessage("Hello Jenny Bhai");
		
		
		System.out.println(ser_1);
		System.out.println(ser_2);
		System.out.println(ser_3);
		System.out.println(ser_4);
		
		
		
		System.out.println(ser_1==ser_2);
		
	}

}

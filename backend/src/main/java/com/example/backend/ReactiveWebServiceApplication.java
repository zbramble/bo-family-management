package com.example.backend;

import com.example.backend.model.Test;
import com.example.backend.model.Third;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReactiveWebServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ReactiveWebServiceApplication.class, args);
		System.out.println(context.getDisplayName());
		System.out.println(context.getId());
		GreetingClient greetingClient = context.getBean(GreetingClient.class);
		// We need to block for the content here or the JVM might exit before the message is logged
//		System.out.println(">> message = " + greetingClient.getMessage().block());
//		new Third();
		new Test();
	}
}

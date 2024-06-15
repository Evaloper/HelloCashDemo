package com.evaloper.HelloCashDemo;

import com.evaloper.HelloCashDemo.service.SocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloCashDemoApplication implements CommandLineRunner {

	private final SocketService socketService;

	@Autowired
	public HelloCashDemoApplication(SocketService socketService) {
		this.socketService = socketService;
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloCashDemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		new Thread(socketService).start();
	}

}

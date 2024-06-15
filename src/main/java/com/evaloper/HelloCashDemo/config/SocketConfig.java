package com.evaloper.HelloCashDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.ServerSocket;

@Configuration
public class SocketConfig {
    @Bean
    public ServerSocket serverSocket() throws IOException {
        return new ServerSocket(8081);
    }
}

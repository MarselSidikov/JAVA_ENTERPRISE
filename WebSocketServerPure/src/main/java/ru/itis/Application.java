package ru.itis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableAutoConfiguration
@EnableWebSocket
@ComponentScan(basePackages = "ru.itis")
public class Application  extends SpringBootServletInitializer implements
        WebSocketConfigurer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // конфигурирует статику
        return application.sources(Application.class);
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(echoWebSocketHandler(), "/echoHandler").withSockJS();
    }

    @Bean
    public WebSocketHandler echoWebSocketHandler() {
        return new EchoHandler();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

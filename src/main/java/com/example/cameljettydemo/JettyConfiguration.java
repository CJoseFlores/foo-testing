package com.example.cameljettydemo;

import org.apache.camel.component.jetty8.JettyHttpComponent8;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JettyConfiguration {
    @Bean
    JettyHttpComponent8 jetty() {
        JettyHttpComponent8 jetty = new JettyHttpComponent8();
        jetty.setContinuationTimeout(1000L);
        return jetty;
    }
}

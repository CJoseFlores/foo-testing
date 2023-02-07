package com.example.cameljettydemo;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JettyRouteBuilder extends RouteBuilder {
    public JettyRouteBuilder(){
        log.info("Created!");
    }

    @Override
    public void configure() throws Exception {
        from("jetty:http://localhost:8081?continuationTimeout=500&bridgeEndpoint=true&throwExceptionOnFailure=false")
        .process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                log.info("Received request!");
                // 1 Minute
                Thread.sleep(5000);
                log.info("Popping out of sleep");
                exchange.getIn().setBody("Hello World!");
            }
        });
    }
    
}

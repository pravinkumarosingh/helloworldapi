package com.example.firstproject.helloworldapi.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultiplePortsConfig {

    @Bean
    public TomcatServletWebServerFactory tomcatFactory() {
        return new TomcatServletWebServerFactory() ;
    }

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> multiplePortsCustomizer() {
        return factory -> {

            factory.addAdditionalTomcatConnectors(createConnector(9090));
            factory.addAdditionalTomcatConnectors(createConnector(9091));
            factory.addAdditionalTomcatConnectors(createConnector(9092));

        };
    }

    private Connector createConnector(int port) {
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setPort(port);
        return connector;
    }

}

package com.example.firstproject.helloworldapi.config;

import com.example.firstproject.helloworldapi.enums.ActiveInactive;
import com.example.firstproject.helloworldapi.model.PortConfig;
import com.example.firstproject.helloworldapi.repository.ConfigRepository;
import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MultiplePortsConfig {

    @Autowired
    private ConfigRepository configRepository;


    @Bean
    public TomcatServletWebServerFactory tomcatFactory() {
        return new TomcatServletWebServerFactory() ;
    }

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> multiplePortsCustomizer() {


        List<PortConfig> portConfigs = configRepository.findByStatus();

        return factory -> {
            for(PortConfig portConfig : portConfigs) {
                if(ActiveInactive.Active.name().equals(portConfig.getStatus()))
                    factory.addAdditionalTomcatConnectors(createConnector(portConfig.getPortNo()));
            }

//            factory.addAdditionalTomcatConnectors(createConnector(9090));
//            factory.addAdditionalTomcatConnectors(createConnector(9091));
//            factory.addAdditionalTomcatConnectors(createConnector(9092));

        };
    }

    private Connector createConnector(int port) {
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setPort(port);
        return connector;
    }

}

package com.kusumotolab.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableJpaAuditing
public class StarterApplication {

    public static final Logger log = LoggerFactory.getLogger(StarterApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        ApplicationContext context = SpringApplication.run(StarterApplication.class, args);
        Environment env = context.getEnvironment();

        String protocol = "http";
        log.info("\n----------------------------------------------------------\n\t" +
                        "KusumotoLab Standard Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}\n\t" +
                        "External: \t{}://{}:{}\n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                env.getProperty("local.server.port"),
                protocol,
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("local.server.port"),
                env.getActiveProfiles());
    }

}

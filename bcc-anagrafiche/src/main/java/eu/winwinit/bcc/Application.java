package eu.winwinit.bcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("eu.winwinit.bcc.advices")
@ComponentScan("eu.winwinit.bcc.controllers")
@ComponentScan("eu.winwinit.bcc.config")
@EntityScan("eu.winwinit.bcc.entities")
@ComponentScan("eu.winwinit.bcc.util")
@ComponentScan("eu.winwinit.bcc.repository")
@ComponentScan("eu.winwinit.bcc.security")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

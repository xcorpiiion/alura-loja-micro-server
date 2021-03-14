package br.com.study.ouath.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@RestController
public class OuathApplication {

    public static void main(String[] args) {
        run(OuathApplication.class, args);
    }

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}

package br.com.study.zuul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

	public static void main(String[] args) {
		run(ZuulApplication.class, args);
	}

}

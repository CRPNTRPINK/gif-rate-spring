package com.example.gifrate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableFeignClients
public class GifRateApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(GifRateApplication.class, args);
	}
}

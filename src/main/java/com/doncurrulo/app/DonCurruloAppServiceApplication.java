package com.doncurrulo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.doncurrulo.app.config.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class DonCurruloAppServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonCurruloAppServiceApplication.class, args);
	}

}
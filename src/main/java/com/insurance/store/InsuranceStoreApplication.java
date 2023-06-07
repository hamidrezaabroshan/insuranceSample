package com.insurance.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages ="com.insurance.store.*" )

@ComponentScan(basePackages ="com.insurance.store.*" )
@EntityScan(basePackages ="com.insurance.store.*" )
public class InsuranceStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceStoreApplication.class, args);
	}

}

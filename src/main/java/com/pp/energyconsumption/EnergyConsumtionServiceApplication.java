package com.pp.energyconsumption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * @author prathameshpawar
 *
 */
@SpringBootApplication
@EnableSwagger2 
@EnableFeignClients("com.pp.energyconsumption")
public class EnergyConsumtionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnergyConsumtionServiceApplication.class, args);
	}

}

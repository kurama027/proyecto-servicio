package com.helena.servicio.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class HelenaServicioProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelenaServicioProyectoApplication.class, args);
	}

}

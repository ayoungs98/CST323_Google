package com.ayoungs.cst323app2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "com.ayoungs" })
@SpringBootApplication
public class Cst323app2Application {

	public static void main(String[] args) {
		SpringApplication.run(Cst323app2Application.class, args);
	}

}

package com.jaimecorg.springprojects.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class TiendaApplication {

	public static void main(String[] args) {
		//Esto para que la raiz sea /tienda
		//System.setProperty("server.servlet.context-path", "/tienda");
		SpringApplication.run(TiendaApplication.class, args);
	}

}

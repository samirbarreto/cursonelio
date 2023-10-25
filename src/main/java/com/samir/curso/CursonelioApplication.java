package com.samir.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class CursonelioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursonelioApplication.class, args);
	}
      
}

package br.com.bliblioteca;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlibliotecaApplication.class, args);
	
	System.out.println(LocalDateTime.now());
		
	}  

}

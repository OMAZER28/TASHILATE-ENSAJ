package ma.ensaj.clientapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ma.ensaj.clientapp.beans.Counter;

@SpringBootApplication
public class ClientAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientAppApplication.class, args);
	}
	
	@Bean
	public Counter counter() {
		return Counter.getInstance();
	}
	

}

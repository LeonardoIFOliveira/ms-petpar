package br.edu.ifsp.arq.ads.petpar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.edu.ifsp.arq.ads.petpar")
public class PetParApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetParApplication.class, args);
	}

}

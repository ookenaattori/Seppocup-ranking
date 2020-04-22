package com.example.Seppocupranking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Seppocupranking.domain.Joukkue;
import com.example.Seppocupranking.domain.JoukkueRepository;
import com.example.Seppocupranking.domain.Kayttaja;
import com.example.Seppocupranking.domain.KayttajaRepository;
import com.example.Seppocupranking.domain.Ottelu;
import com.example.Seppocupranking.domain.OtteluRepository;
import com.example.Seppocupranking.domain.Valmentaja;
import com.example.Seppocupranking.domain.ValmentajaRepository;

@SpringBootApplication
public class SeppocuprankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeppocuprankingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(JoukkueRepository repository, ValmentajaRepository vrepository, KayttajaRepository krepository, OtteluRepository orepository) {
		return(args) -> {
			
			// Luodaan valmentaja olioita
			Valmentaja valmentaja1 = new Valmentaja("Nivalainen");
			Valmentaja valmentaja2 = new Valmentaja("Mömmö");
			Valmentaja valmentaja3 = new Valmentaja("Kummola");
			Valmentaja valmentaja4 = new Valmentaja("Tuovinen");
			Valmentaja valmentaja5 = new Valmentaja("Kontkanen");
			
			vrepository.save(valmentaja1);
			vrepository.save(valmentaja2);
			vrepository.save(valmentaja3);
			vrepository.save(valmentaja4);
			vrepository.save(valmentaja5);
			
			// Luodaan joukkue olioita
			Joukkue joukkue1 = new Joukkue("New york", 0, 0, 1, 0, 0, 2, 1, vrepository.findByNimi("Nivalainen").get(0));
			Joukkue joukkue2 = new Joukkue("Edmonton", 3, 1, 0, 0, 0, 5, 1, vrepository.findByNimi("Mömmö").get(0));
			
			
			repository.save(joukkue1);
			repository.save(joukkue2);
			
		
			
			// Create test users: admin/admin user/user
			Kayttaja user1 = new Kayttaja ("user", "$2y$12$nJFSm7ZKZS1Bq83wUsDRn.VN/Mqpj3IxSG4TnHhc/s3.36aVQOUS2", "USER");
			Kayttaja user2 = new Kayttaja ("admin", "$2y$12$/jKIdhatvwCuuW5.aQUjwOTaEIYI5a3iI2xNco4.pns9Xl3BZ9sPi", "ADMIN");
			Kayttaja user3 = new Kayttaja ("seppo", "$2y$12$x7dd/BQU/6s.VARqq15PFOEfCcBjviKaJEuny3Yqtkp9Fzs50zETS", "USER");
			krepository.save(user1);
			krepository.save(user2);
			krepository.save(user3);
			
			// Luodaan testi otteluita
			Ottelu ottelu1 = new Ottelu ("New york", "Edmonton", 2, 5, 0, 3, "Ei");
			Ottelu ottelu2 = new Ottelu ("Tampa Bay", "St. Louis", 3, 2, 3, 0, "Ei");
			
			orepository.save(ottelu1);
			orepository.save(ottelu2);
					
					
			
			};
	}

}

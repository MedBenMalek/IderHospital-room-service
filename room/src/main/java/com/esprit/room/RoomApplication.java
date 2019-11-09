package com.esprit.room;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomApplication.class, args);
	}
	
//	get list of patients
//	@Bean
//	ApplicationRunner init(CandidatRepository repository) {
//		return args -> {
//			Stream.of("samy","malek","khalil").forEach(nom -> {
//				repository.save(new Candidat(nom));
//			});
//			repository.findAll().forEach(System.out::println);
//		};
//	}
	
}

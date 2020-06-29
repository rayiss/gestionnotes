package org.rayis.gestion;

import org.rayis.gestion.services.IGesnotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionNotesApplication implements CommandLineRunner {

	@Autowired
	private IGesnotes iGesnotes;

	public static void main(String[] args) {
		SpringApplication.run(GestionNotesApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		iGesnotes.initApprenants();
		iGesnotes.initCours();
		iGesnotes.initExamens();
		for (int i=0; i<10; i++){
			iGesnotes.initNotes();
		}
	}
}

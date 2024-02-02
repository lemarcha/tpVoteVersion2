package fr.eni.tp.tpvote;

import fr.eni.tp.tpvote.bll.UtilisateurService;
import fr.eni.tp.tpvote.bo.Utilisateur;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpVoteApplication {

	@Autowired
	public UtilisateurService service;


	@PostConstruct
	public void init() {
		service.addUtilisateur(new Utilisateur("Steeve","pote","ADMIN,USER"));
		service.addUtilisateur(new Utilisateur("Alain","parrain","USER"));
		service.addUtilisateur(new Utilisateur("Audrey","femme","USER"));
		service.addUtilisateur(new Utilisateur("Antoine","papa","USER"));
		service.addUtilisateur(new Utilisateur("Aaron","fils","USER"));

		service.getAllUtilisateurs().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(TpVoteApplication.class, args);
	}

}

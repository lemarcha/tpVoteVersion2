package fr.eni.tp.tpvote.bll;


import fr.eni.tp.tpvote.bo.Utilisateur;
import fr.eni.tp.tpvote.ihm.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UtilisateurService {
	@Autowired
	UtilisateurRepository repo;
	
	@Autowired
	PasswordEncoder encodeur;
	
	
	@Transactional
	public void addUtilisateur(Utilisateur utilisateur) {
		// encodage du mot de passe 
		utilisateur.setMdp(encodeur.encode(utilisateur.getMdp()));
		
		// insertion en base
		repo.insert(utilisateur);
	}

	public List<Utilisateur> getAllUtilisateurs() {
		return repo.getAll();
	}
	
}

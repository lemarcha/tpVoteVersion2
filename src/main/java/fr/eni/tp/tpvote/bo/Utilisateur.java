package fr.eni.tp.tpvote.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Utilisateur {
	private Integer idUtilisateur;
	private String pseudo;
	private String mdp;
	private String roles;

	public Utilisateur(String pseudo, String mdp, String roles) {
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.roles = roles;
	}

	public Utilisateur(Integer idUtilisateur, String pseudo, String mdp, String roles) {
		this.idUtilisateur = idUtilisateur;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.roles = roles;
	}

	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Utilisateur{");
		sb.append("idUtilisateur=").append(idUtilisateur);
		sb.append(", pseudo='").append(pseudo).append('\'');
		sb.append(", mdp='").append(mdp).append('\'');
		sb.append(", roles='").append(roles).append('\'');
		sb.append('}');
		return sb.toString();
	}
}

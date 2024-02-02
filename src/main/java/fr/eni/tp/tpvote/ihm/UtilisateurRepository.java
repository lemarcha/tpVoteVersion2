package fr.eni.tp.tpvote.ihm;


import fr.eni.tp.tpvote.bo.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UtilisateurRepository {

//	requete pour recuperer les utilisateur
	final String SELECT = "SELECT * FROM utilisateur";

//	insertion d'un utilisateur'
	final String INSERT = "INSERT INTO utilisateur (pseudo,mdp,roles) VALUES (:pseudo,:mdp,:roles)";
	final String SELECT_BY_PSEUDO = "SELECT * FROM utilisateur WHERE pseudo=:pseudo";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	RowMapper<Utilisateur> mapper = (rs, i) -> new Utilisateur(rs.getInt("idUtilisateur"), rs.getString("pseudo"),
			rs.getString("mdp"),rs.getString("roles"));


	public List<Utilisateur> getAll() {
		return jdbcTemplate.query(SELECT, mapper);
	}

	public void insert(Utilisateur utilisateur) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
        BeanPropertySqlParameterSource namedParameters = new BeanPropertySqlParameterSource(utilisateur);
        namedParameterJdbcTemplate.update(INSERT, namedParameters,keyHolder);
        utilisateur.setIdUtilisateur(keyHolder.getKey().intValue());
	}

	public Utilisateur findByPseudo(String pseudo) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("pseudo", pseudo);
		Utilisateur utilisateur = namedParameterJdbcTemplate.queryForObject(SELECT_BY_PSEUDO,namedParameters, mapper);
		return utilisateur;
	}
}

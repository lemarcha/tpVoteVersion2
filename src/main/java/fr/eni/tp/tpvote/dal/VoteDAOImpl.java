package fr.eni.tp.tpvote.dal;

import fr.eni.tp.tpvote.bo.Candidat;
import fr.eni.tp.tpvote.bo.Vote;
import fr.eni.tp.tpvote.dal.interfaces.VoteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class VoteDAOImpl implements VoteDAO {

    RowMapper<Vote> rowMapper = (rs, i)->
            new Vote(rs.getInt("id"),rs.getString("name"), rs.getDate("ddn").toLocalDate(), Candidat.valueOf(rs.getString("candidatForVote")));

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void addVote(Vote vote) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", vote.getName());
        namedParameters.addValue("ddn", vote.getDdn());
        namedParameters.addValue("candidatForVote", vote.getCandidatForVote().toString());

        jdbcTemplate.update("INSERT INTO VOTE (name, ddn, candidatForVote) VALUES (:name,:ddn, :candidatForVote)", namedParameters, keyHolder);

        if (keyHolder != null && keyHolder.getKey() != null) {
            vote.setId(keyHolder.getKey().intValue());
        }

        // TODO : a supprimer
        System.out.println("insertion de "+ vote);
    }

    @Override
    public List<Vote> getAllVotes() {
        return jdbcTemplate.query("SELECT id, name, ddn, candidatForVote FROM VOTE", rowMapper);
    }

    @Override
    public List<Vote> findByVoterName(String voterName) {
        return jdbcTemplate.query("SELECT id, name, ddn, candidatForVote FROM VOTE WHERE name = :name", rowMapper);
    }

    @Override
    public List<Vote> findByCandidateVotedFor(Candidat candidat) {
        return jdbcTemplate.query("SELECT id, name, ddn, candidatForVote FROM VOTE WHERE candidatForVote = : candidatForVote", rowMapper);
    }

    @Override
    public List<Candidat> getAllCandidats() {
        return jdbcTemplate.query("SELECT DISTINCT candidatForVote FROM VOTE", (rs, rowNum) ->
                Candidat.valueOf(rs.getString("candidatForVote")));
    }


}

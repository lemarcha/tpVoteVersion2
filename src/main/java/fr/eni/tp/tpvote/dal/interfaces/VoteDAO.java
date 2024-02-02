package fr.eni.tp.tpvote.dal.interfaces;

import fr.eni.tp.tpvote.bo.Candidat;
import fr.eni.tp.tpvote.bo.Vote;

import java.util.List;

public interface VoteDAO {
    public void addVote(Vote vote);

    public List<Vote> getAllVotes();

    List<Vote> findByVoterName(String voterName);

    List<Vote> findByCandidateVotedFor(Candidat candidat);

    public List<Candidat> getAllCandidats();

}

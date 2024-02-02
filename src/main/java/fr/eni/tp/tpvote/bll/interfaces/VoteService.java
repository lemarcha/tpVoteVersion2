package fr.eni.tp.tpvote.bll.interfaces;

import fr.eni.tp.tpvote.bll.VoteServiceException;
import fr.eni.tp.tpvote.bo.Candidat;
import fr.eni.tp.tpvote.bo.Vote;

import java.util.List;

public interface VoteService {
    public void addVote(Vote vote) throws VoteServiceException;

    public List<Vote> getAllVotes();

    List<Vote> findByVoterName(String voterName);

    List<Vote> findByCandidateVotedFor(Candidat candidat);

    public List<Candidat> getAllCandidats();
}

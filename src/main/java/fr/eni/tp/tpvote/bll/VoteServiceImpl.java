package fr.eni.tp.tpvote.bll;

import fr.eni.tp.tpvote.bll.interfaces.VoteService;
import fr.eni.tp.tpvote.bo.Candidat;
import fr.eni.tp.tpvote.bo.Vote;
import fr.eni.tp.tpvote.dal.interfaces.VoteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    VoteDAO voteDAO;
    @Override
    public void addVote(Vote vote) throws VoteServiceException {
        voteDAO.addVote(vote);
    }

    @Override
    public List<Vote> getAllVotes() {
        return voteDAO.getAllVotes();
    }

    @Override
    public List<Vote> findByVoterName(String voterName) {
        return voteDAO.findByVoterName(voterName);
    }

    @Override
    public List<Vote> findByCandidateVotedFor(Candidat candidat) {
        return voteDAO.findByCandidateVotedFor(candidat);
    }

    @Override
    public List<Candidat> getAllCandidats() {
        return Arrays.asList(Candidat.values());
    }
}

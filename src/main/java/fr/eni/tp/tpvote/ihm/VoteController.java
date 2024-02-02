package fr.eni.tp.tpvote.ihm;

import fr.eni.tp.tpvote.bll.VoteServiceException;
import fr.eni.tp.tpvote.bll.interfaces.VoteService;
import fr.eni.tp.tpvote.bo.Candidat;
import fr.eni.tp.tpvote.bo.Vote;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    VoteService voteService;

    @ModelAttribute("lstVote")
    public List<Vote> getVote(){
        return voteService.getAllVotes();
    }

    @ModelAttribute("enumCandidat")
    public List<Candidat> getAllCandidats() {
        return voteService.getAllCandidats();
    }

    @GetMapping
    public String getVotePage(Vote vote){
        return "view-vote";
    }

    @PostMapping
    public String valid(@Valid @ModelAttribute("vote") Vote vote, BindingResult errors) {

        if(errors.hasErrors()) {
            return "view-vote";
        }
        try {
            Candidat selectedCandidat = vote.getCandidatForVote();
            System.out.println("Candidat sélectionné : " + selectedCandidat);
            voteService.addVote(vote);
        } catch (VoteServiceException e) {
            e.printStackTrace();
        }

        return "redirect:/vote";
    }

}

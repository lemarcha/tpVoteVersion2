package fr.eni.tp.tpvote.ihm;

import fr.eni.tp.tpvote.bll.UtilisateurService;
import fr.eni.tp.tpvote.bll.VoteServiceException;
import fr.eni.tp.tpvote.bo.Candidat;
import fr.eni.tp.tpvote.bo.Vote;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @Autowired
    public UtilisateurService service;

    @GetMapping("/")
    public String accueil(Model model) {
        model.addAttribute("utilisateurs",service.getAllUtilisateurs());
        return "accueil";
    }

//    @PostMapping
//    public String valid(@Valid @ModelAttribute("vote") Vote vote, BindingResult errors) {
//
//            Candidat selectedCandidat = vote.getCandidatForVote();
//            System.out.println("Candidat sélectionné : " + selectedCandidat);
//            voteService.addVote(vote);
//
//        return "redirect:/vote";
//    }


}

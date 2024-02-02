package fr.eni.tp.tpvote.bo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class Vote {
    private int id;
    @NotBlank
    @Size(min = 2, max = 50, message = "Le nom doit avoir au moins 2 caractères")
    private String name;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate ddn;
    private Candidat candidatForVote;

    public Vote() {
    }

    public Vote(String name, LocalDate ddn, Candidat candidatForVote) {
        this.name = name;
        this.ddn = ddn;
        this.candidatForVote = candidatForVote;
    }

    public Vote(int id, String name, LocalDate ddn, Candidat candidatForVote) {
        this.id = id;
        this.name = name;
        this.ddn = ddn;
        this.candidatForVote = candidatForVote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDdn() {
        return ddn;
    }

    public void setDdn(LocalDate ddn) {
        this.ddn = ddn;
    }

    public Candidat getCandidatForVote() {
        return candidatForVote;
    }

    public void setCandidatForVote(Candidat candidatForVote) {
        this.candidatForVote = candidatForVote;
    }

}

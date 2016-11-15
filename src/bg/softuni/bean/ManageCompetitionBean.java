package bg.softuni.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bg.softuni.model.competition.Competition;
import bg.softuni.model.user.User;
import bg.softuni.service.CompetitionService;

@ManagedBean(name = "ManageCompetitionBean")
@ViewScoped
public class ManageCompetitionBean {

    @EJB
    private CompetitionService competitionService;
    private Competition competition;

    @PostConstruct
    public void init() {
        competition = new Competition();
    }

    public CompetitionService getCompetitionService() {
        return competitionService;
    }

    public void setCompetitionService(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    public String addNewCompetition() {
        competitionService.addCompetition(competition);
        return "/page/competitions?faces-redirect=true";
    }

    public void editCompetition() {

    }

    public void deleteCompetition() {

    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public String addCompetitor(Competition competition) {
        return competitionService.addCompetitor(competition);

    }

    public List<User> getCompetitors(Competition competition) {
        return competitionService.getCompetitors(competition);
    }
}

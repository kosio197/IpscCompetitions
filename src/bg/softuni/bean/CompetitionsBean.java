package bg.softuni.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import bg.softuni.model.competition.Competition;
import bg.softuni.model.user.User;
import bg.softuni.service.CompetitionService;

@ManagedBean(name = "CompetitionsBean")
@ViewScoped
public class CompetitionsBean {

    @EJB
    private CompetitionService competitionService;
    @Inject
    private HttpServletRequest request;

    private List<Competition> afterDateCompetitions;
    private List<Competition> beforeDateCompetitions;
    private Competition competition;

    @PostConstruct
    public void init() {
        competition = (Competition) request.getSession().getAttribute("CURRENT_COMPETITION");
        if (competition == null) {
            competition = new Competition();
        }

        afterDateCompetitions = new ArrayList<Competition>();
        beforeDateCompetitions = new ArrayList<Competition>();
        List<Competition> competitions = competitionService.getAllCompetitions();
        for (Competition comp : competitions) {
            if (new Date().before(comp.getMatchDate())) {
                afterDateCompetitions.add(comp);
            } else {
                beforeDateCompetitions.add(comp);
            }
        }
    }

    public String generalInfoSendRedirect(Competition competition) {
        request.getSession().setAttribute("CURRENT_COMPETITION", competition);
        return "generalInfo.xhtml?faces-redirect=true";
    }

    public String addNewCompetition() {
        competitionService.addCompetition(competition);
        return "/page/competitions?faces-redirect=true";
    }

    public String editCompetition() {
        competitionService.editCompetition(competition);
        return "/page/competitions?faces-redirect=true";
    }

    public String addCompetitor(Competition competition) {
        if (hasRegister(competition))
            return "";
        return competitionService.addCompetitor(competition);

    }

    public String removeCompetitor(Competition competition) {
        competitionService.removeCompetitor(competition);
        return "/page/competitions?faces-redirect=true";
    }

    public List<User> getCompetitors(Competition competition) {
        return competitionService.getCompetitors(competition);
    }

    public boolean hasRegister(Competition competition) {
        User currentUser = getLogetUser();
        for (User user : competitionService.getCompetitors(competition)) {
            if (user.getUsername().equals(currentUser.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    private User getLogetUser() {
        return (User) request.getSession().getAttribute("LOGGED_USER");
    }

    public List<Competition> getCompetitions() {
        return afterDateCompetitions;
    }

    public List<Competition> getPastCompetitions() {
        return beforeDateCompetitions;
    }

    public CompetitionService getCompetitionService() {
        return competitionService;
    }

    public void setCompetitionService(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

}

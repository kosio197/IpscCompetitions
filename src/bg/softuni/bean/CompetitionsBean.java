package bg.softuni.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bg.softuni.model.competition.Competition;
import bg.softuni.service.CompetitionService;

@ManagedBean(name = "CompetitionsBean")
@SessionScoped
public class CompetitionsBean {

    @EJB
    private CompetitionService competitionService;
    private List<Competition> afterDateCompetitions;
    private List<Competition> beforeDateCompetitions;

    @PostConstruct
    public void init() {
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

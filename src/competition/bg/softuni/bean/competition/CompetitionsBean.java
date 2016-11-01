package competition.bg.softuni.bean.competition;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

import competition.bg.softuni.model.competition.Competition;

@ManagedBean(name = "CompetitionsBean")
@ApplicationScoped
public class CompetitionsBean {
    private List<Competition> competitions;

    @PostConstruct
    public void init() {
        competitions = new ArrayList<Competition>();

    }

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public List<Competition> getPastCompetitions() {
        return competitions;
    }

    public void onTabChange(TabChangeEvent event) {
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onTabClose(TabCloseEvent event) {
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}

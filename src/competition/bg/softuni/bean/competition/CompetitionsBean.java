package competition.bg.softuni.bean.competition;

import java.util.ArrayList;
import java.util.Date;
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
		
		competitions.add(new Competition("Cup 1", 3, "Tam nqkyde", "Az", "hand gun", new Date(), 400, 24, 50, "BGN"));
		competitions.add(new Competition("Cup 2", 3, "Tam nqkyde", "Az", "hand gun", new Date(), 400, 24, 50, "BGN"));
		competitions.add(new Competition("Cup 3", 3, "Tam nqkyde", "Az", "hand gun", new Date(), 400, 24, 50, "BGN"));
		competitions.add(new Competition("Cup 4", 3, "Tam nqkyde", "Az", "hand gun", new Date(), 400, 24, 50, "BGN"));
		competitions.add(new Competition("Cup 5", 3, "Tam nqkyde", "Az", "hand gun", new Date(), 400, 24, 50, "BGN"));
		competitions.add(new Competition("Cup 6", 3, "Tam nqkyde", "Az", "hand gun", new Date(), 400, 24, 50, "BGN"));
		competitions.add(new Competition("Cup 7", 3, "Tam nqkyde", "Az", "hand gun", new Date(), 400, 24, 50, "BGN"));
		competitions.add(new Competition("Cup 8", 3, "Tam nqkyde", "Az", "hand gun", new Date(), 400, 24, 50, "BGN"));
		competitions.add(new Competition("Cup 9", 3, "Tam nqkyde", "Az", "hand gun", new Date(), 400, 24, 50, "BGN"));
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

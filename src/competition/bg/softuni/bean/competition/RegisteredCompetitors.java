package competition.bg.softuni.bean.competition;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import competition.bg.softuni.model.user.Competitor;
import competition.bg.softuni.model.user.User;

@ManagedBean(name="RegisteredCompetitors")
@ApplicationScoped
public class RegisteredCompetitors {
	private List<Competitor> competitors;
	
	@PostConstruct
	public void init() {
		competitors = new ArrayList<Competitor>();
		
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
		competitors.add(new Competitor(new User("Deni", "Gencheva", "", "Bulgaria"), "Lady", "PRD"));
	}

	public List<Competitor> getCompetitors() {
		return competitors;
	}

	public void setCompetitors(List<Competitor> competitors) {
		this.competitors = competitors;
	}
}

package bg.softuni.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import bg.softuni.model.user.RegisteredCompetitor;

@ManagedBean(name = "RegisteredCompetitorsBean")
@ApplicationScoped
public class RegisteredCompetitorsBean {
    private List<RegisteredCompetitor> competitors;

    @PostConstruct
    public void init() {
        competitors = new ArrayList<RegisteredCompetitor>();
    }

    public List<RegisteredCompetitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<RegisteredCompetitor> competitors) {
        this.competitors = competitors;
    }
}

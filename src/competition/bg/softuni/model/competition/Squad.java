package competition.bg.softuni.model.competition;

import java.util.ArrayList;
import java.util.List;

import competition.bg.softuni.model.user.RegisteredCompetitor;

public class Squad {
    private int number;
    private List<RegisteredCompetitor> competitors;

    public Squad() {
        competitors = new ArrayList<RegisteredCompetitor>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<RegisteredCompetitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<RegisteredCompetitor> competitors) {
        this.competitors = competitors;
    }
}

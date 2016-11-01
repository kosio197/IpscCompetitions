package competition.bg.softuni.model.competition;

import java.util.ArrayList;
import java.util.List;

public class Stage {
    private int number;
    private int minRounds;
    private int maxPoints;

    private String description;

    private List<StageResult> stageResults;

    public Stage() {
        stageResults = new ArrayList<StageResult>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMinRounds() {
        return minRounds;
    }

    public void setMinRounds(int minRounds) {
        this.minRounds = minRounds;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<StageResult> getStageResults() {
        return stageResults;
    }

    public void setStageResults(List<StageResult> stageResults) {
        this.stageResults = stageResults;
    }
}

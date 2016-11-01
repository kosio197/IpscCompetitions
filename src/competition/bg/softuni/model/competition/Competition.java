package competition.bg.softuni.model.competition;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import competition.bg.softuni.model.enumeration.Discipline;
import competition.bg.softuni.model.user.User;

public class Competition {
    private String name;
    private String address;
    private String feeCurrency;
    private String description;

    private Date matchDate;
    private Date prematchDate;
    private Date registrationDeadline;
    private Date paymentDeadline;

    private int level;
    private double fee;

    private Discipline discipline;

    private List<Stage> stages;

    private User createdBy;

    public Competition() {
        stages = new ArrayList<Stage>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getFeeCurrency() {
        return feeCurrency;
    }

    public void setFeeCurrency(String feeCurrency) {
        this.feeCurrency = feeCurrency;
    }

    public Date getPrematchDate() {
        return prematchDate;
    }

    public void setPrematchDate(Date prematchDate) {
        this.prematchDate = prematchDate;
    }

    public Date getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(Date registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }

    public Date getPaymentDeadline() {
        return paymentDeadline;
    }

    public void setPaymentDeadline(Date paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

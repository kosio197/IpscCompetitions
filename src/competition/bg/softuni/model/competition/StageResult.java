package competition.bg.softuni.model.competition;

import competition.bg.softuni.model.user.RegisteredCompetitor;

public class StageResult {
    private Stage stage;

    private RegisteredCompetitor competitor;

    private double time;

    private int a;
    private int c;
    private int d;
    private int ns;
    private int proc;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public RegisteredCompetitor getCompetitor() {
        return competitor;
    }

    public void setCompetitor(RegisteredCompetitor competitor) {
        this.competitor = competitor;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getNs() {
        return ns;
    }

    public void setNs(int ns) {
        this.ns = ns;
    }

    public int getProc() {
        return proc;
    }

    public void setProc(int proc) {
        this.proc = proc;
    }
}

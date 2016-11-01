package competition.bg.softuni.model.user;

import competition.bg.softuni.model.enumeration.PowerFactor;
import competition.bg.softuni.model.enumeration.RiffleDevision;

public class RiffleCompetitor extends RegisteredCompetitor {
    private RiffleDevision devision;
    private PowerFactor powerFactor;

    public RiffleCompetitor() {
        devision = user.getDefaultRiffleDevision();
        powerFactor = user.getDefaultHandgunPowerFactor();
    }

    public PowerFactor getPowerFactor() {
        return powerFactor;
    }

    public void setPowerFactor(PowerFactor powerFactor) {
        this.powerFactor = powerFactor;
    }

    public RiffleDevision getDevision() {
        return devision;
    }

    public void setDevision(RiffleDevision devision) {
        this.devision = devision;
    }
}

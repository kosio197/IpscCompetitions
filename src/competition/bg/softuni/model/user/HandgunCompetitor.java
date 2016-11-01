package competition.bg.softuni.model.user;

import competition.bg.softuni.model.enumeration.HandgunDevision;
import competition.bg.softuni.model.enumeration.PowerFactor;

public class HandgunCompetitor extends RegisteredCompetitor {
    private HandgunDevision devision;
    private PowerFactor powerFactor;

    public HandgunCompetitor() {
        devision = user.getDefaultHandgunDevision();
        powerFactor = user.getDefaultHandgunPowerFactor();
    }

    public PowerFactor getPowerFactor() {
        return powerFactor;
    }

    public void setPowerFactor(PowerFactor powerFactor) {
        this.powerFactor = powerFactor;
    }

    public HandgunDevision getDevision() {
        return devision;
    }

    public void setDevision(HandgunDevision devision) {
        this.devision = devision;
    }
}

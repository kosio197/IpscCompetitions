package bg.softuni.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import bg.softuni.model.enumeration.HandgunDevision;
import bg.softuni.model.enumeration.RifleDevision;
import bg.softuni.model.enumeration.ShotgunDevision;

@ManagedBean(name = "devisionBean")
@ApplicationScoped
public class DevisionBean {

    private List<String> handgunDevisions;
    private List<String> shotgunDevisions;
    private List<String> rifleDevisions;

    @PostConstruct
    public void init() {
        handgunDevisions = new ArrayList<String>();
        for (HandgunDevision hd : HandgunDevision.values()) {
            handgunDevisions.add(hd.toString());
        }

        shotgunDevisions = new ArrayList<String>();
        for (ShotgunDevision hd : ShotgunDevision.values()) {
            shotgunDevisions.add(hd.toString());
        }

        rifleDevisions = new ArrayList<String>();
        for (RifleDevision hd : RifleDevision.values()) {
            rifleDevisions.add(hd.toString());
        }
    }

    public List<String> getHandgunDevisions() {
        return handgunDevisions;
    }

    public void setHandgunDevisions(List<String> handgunDevisions) {
        this.handgunDevisions = handgunDevisions;
    }

    public List<String> getShotgunDevisions() {
        return shotgunDevisions;
    }

    public void setShotgunDevisions(List<String> shotgunDevisions) {
        this.shotgunDevisions = shotgunDevisions;
    }

    public List<String> getRifleDevisions() {
        return rifleDevisions;
    }

    public void setRifleDevisions(List<String> rifleDevisions) {
        this.rifleDevisions = rifleDevisions;
    }

}

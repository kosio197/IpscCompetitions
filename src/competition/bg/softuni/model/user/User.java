package competition.bg.softuni.model.user;

import competition.bg.softuni.model.enumeration.Cathegory;
import competition.bg.softuni.model.enumeration.HandgunDevision;
import competition.bg.softuni.model.enumeration.PowerFactor;
import competition.bg.softuni.model.enumeration.RiffleDevision;
import competition.bg.softuni.model.enumeration.Role;
import competition.bg.softuni.model.enumeration.ShotgunDevision;

public class User {
    private String username;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String alias;
    private String shootingClub;
    private String email;
    private String country;
    private String telephone;

    private Cathegory cathegory;

    private HandgunDevision defaultHandgunDevision;
    private PowerFactor defaultHandgunPowerFactor;

    private RiffleDevision defaultRiffleDevision;
    private PowerFactor defaultRifflePowerFactor;

    private ShotgunDevision defaultShotgunDevision;

    private Role role;

    public User() {
        defaultHandgunDevision = HandgunDevision.PRD;
        defaultShotgunDevision = ShotgunDevision.MOD;
        defaultRiffleDevision = RiffleDevision.MAO;

        defaultHandgunPowerFactor = PowerFactor.MIN;
        defaultRifflePowerFactor = PowerFactor.MIN;

        cathegory = Cathegory.REGULAR;

        country = "Bulgaria";

        role = Role.USER;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ShotgunDevision getDefaultShotgunDevision() {
        return defaultShotgunDevision;
    }

    public void setDefaultShotgunDevision(ShotgunDevision defaultShotgunDevision) {
        this.defaultShotgunDevision = defaultShotgunDevision;
    }

    public RiffleDevision getDefaultRiffleDevision() {
        return defaultRiffleDevision;
    }

    public void setDefaultRiffleDevision(RiffleDevision defaultRiffleDevision) {
        this.defaultRiffleDevision = defaultRiffleDevision;
    }

    public PowerFactor getDefaultHandgunPowerFactor() {
        return defaultHandgunPowerFactor;
    }

    public void setDefaultHandgunPowerFactor(PowerFactor defaultHandgunPowerFactor) {
        this.defaultHandgunPowerFactor = defaultHandgunPowerFactor;
    }

    public PowerFactor getDefaultRifflePowerFactor() {
        return defaultRifflePowerFactor;
    }

    public void setDefaultRifflePowerFactor(PowerFactor defaultRifflePowerFactor) {
        this.defaultRifflePowerFactor = defaultRifflePowerFactor;
    }

    public HandgunDevision getDefaultHandgunDevision() {
        return defaultHandgunDevision;
    }

    public void setDefaultHandgunDevision(HandgunDevision defaultHandgunDevision) {
        this.defaultHandgunDevision = defaultHandgunDevision;
    }

    public Cathegory getCathegory() {
        return cathegory;
    }

    public void setCathegory(Cathegory cathegory) {
        this.cathegory = cathegory;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getShootingClub() {
        return shootingClub;
    }

    public void setShootingClub(String shootingClub) {
        this.shootingClub = shootingClub;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}

package bg.softuni.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import bg.softuni.model.enumeration.Role;

@ManagedBean(name = "roleBean")
@ApplicationScoped
public class RoleBean {
    private List<String> roles;
    private String defaultRole;

    @PostConstruct
    public void init() {
        roles = new ArrayList<String>();
        roles.add(Role.USER.name());
        roles.add(Role.CLUB_OWNER.name());
        roles.add(Role.ADMIN.name());

        defaultRole = Role.USER.name();
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getDefaultRole() {
        return defaultRole;
    }

    public void setDefaultRole(String defaultRole) {
        this.defaultRole = defaultRole;
    }

}

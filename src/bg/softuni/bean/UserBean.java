package bg.softuni.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.CellEditEvent;

import bg.softuni.model.enumeration.Category;
import bg.softuni.model.enumeration.Role;
import bg.softuni.model.user.User;
import bg.softuni.service.UserService;

@ManagedBean(name = "userBean")
@ViewScoped
public class UserBean {

    @EJB
    private UserService userService;

    @Inject
    private HttpServletRequest request;

    private User user;
    public List<User> allUsers;

    @PostConstruct
    public void init() {
        allUsers = userService.getAllUsers();
        user = getLogetUser();
        if (user == null) {
            user = new User();
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String save() {
        userService.addUser(user);

        return "/page/competitions?faces-redirect=true";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public boolean hasRoleAdmin() {

        User currentLogetUser = getLogetUser();
        if ("ADMIN".equalsIgnoreCase(currentLogetUser.getRole().name())) {
            return true;
        }
        return false;
    }

    public String editProfile() {
        userService.editProfile(getLogetUser(), user);
        return "/page/competitions?faces-redirect=true";
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    private User getLogetUser() {
        return (User) request.getSession().getAttribute("LOGGED_USER");
    }

    public List<String> getAllRoles() {
        List<String> roles = new ArrayList<String>();
        for (Role rol : Role.values()) {
            roles.add(rol.toString());
        }
        return roles;
    }

    public void myListener(User user) {
        userService.editUserRole(user);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed",
                    "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public List<String> getCategories() {
        List<String> cat = new ArrayList<String>();
        for (Category category : Category.values()) {
            cat.add(category.toString());
        }
        return cat;
    }

}

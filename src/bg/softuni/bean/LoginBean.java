package bg.softuni.bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import bg.softuni.model.user.User;
import bg.softuni.service.UserService;

@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean {

    @EJB
    private UserService userService;
    @Inject
    private HttpServletRequest request;

    private String username;
    private String password;

    public String login() {
        User user = userService.getUser(username, password);

        if (null == user) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ivalid username or password!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);

            return "";
        } else {
            request.getSession().setAttribute("LOGGED_USER", user);
            return "/page/competitions?faces-redirect=true";
        }
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
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
}

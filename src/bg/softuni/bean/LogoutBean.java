package bg.softuni.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "LogoutBean")
@RequestScoped
public class LogoutBean {

    @Inject
    HttpServletRequest request;

    public String logout() {

        request.getSession().invalidate();
        return "/page/competitions?faces-redirect=true";
    }
}

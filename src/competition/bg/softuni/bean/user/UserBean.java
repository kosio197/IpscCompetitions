package competition.bg.softuni.bean.user;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import competition.bg.softuni.model.user.User;
import competition.bg.softuni.service.UserService;

@ManagedBean(name="userBean")
@ViewScoped
public class UserBean {
	@Inject
	private UserService userService;
	
    @Inject
    private HttpServletRequest request;
	
	private User user;

	@PostConstruct
	public void init() {
		user = new User();
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
}

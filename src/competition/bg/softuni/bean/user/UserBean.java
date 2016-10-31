package competition.bg.softuni.bean.user;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import competition.bg.softuni.model.user.User;
import competition.bg.softuni.service.UserService;

@ManagedBean(name="userBean")
@ViewScoped
public class UserBean {
	@Inject
	private UserService userService;
	
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
	
	public void save() {
		userService.addUser(user);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}

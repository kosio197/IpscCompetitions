package competition.bg.softuni.service;

import competition.bg.softuni.model.user.User;

public interface UserService {
	public void addUser(User user);
	public User deleteUser(String email);
	public User getUser(String email);
	public User validateUser(String username, String password);
}

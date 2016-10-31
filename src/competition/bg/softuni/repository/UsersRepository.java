package competition.bg.softuni.repository;

import competition.bg.softuni.model.user.User;

public interface UsersRepository {
	public void addUser(User user);
	public User getUser(String username);
}

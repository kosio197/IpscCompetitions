package competition.bg.softuni.repository;

import java.util.ArrayList;
import java.util.List;

import competition.bg.softuni.model.user.User;

public class UsersRepositoryImpl implements UsersRepository {
	private List<User> users;
	
	public UsersRepositoryImpl() {
		users = new ArrayList<User>();
	}
	
	@Override
	public void addUser(User user) {
		users.add(user);
	}
}

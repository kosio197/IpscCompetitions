package competition.bg.softuni.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;

import competition.bg.softuni.model.user.User;

@Singleton
public class UsersRepositoryImpl implements UsersRepository {
	private List<User> users;
	
	public UsersRepositoryImpl() {
		users = new ArrayList<User>();
	}
	
	@Override
	public void addUser(User user) {
		users.add(user);
	}

	@Override
	public User getUser(String username) {
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		
		return null;
	}
}

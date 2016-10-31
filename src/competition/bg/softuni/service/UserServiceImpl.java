package competition.bg.softuni.service;

import javax.inject.Inject;

import competition.bg.softuni.model.user.User;
import competition.bg.softuni.repository.UsersRepository;

public class UserServiceImpl implements UserService {

	@Inject
	private UsersRepository repository;
	
	@Override
	public void addUser(User user) {
		repository.addUser(user);
	}

	@Override
	public User deleteUser(String email) {
		return null;
	}

	@Override
	public User getUser(String email) {
		return null;
	}

	public UsersRepository getRepository() {
		return repository;
	}

	public void setRepository(UsersRepository repository) {
		this.repository = repository;
	}
}

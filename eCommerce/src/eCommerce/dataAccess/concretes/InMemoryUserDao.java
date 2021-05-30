package eCommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class InMemoryUserDao implements UserDao {
	List<User> users = new ArrayList<User>();


	@Override
	public void add(User user) {
		users.add(user);
		
	}

	@Override
	public void delete(User user) {
		users.removeIf(obj->obj.getId() == user.getId());
		
	}

	@Override
	public void update(User user) {
		User userToUpdate = get(user.getId());
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());		
	}

	@Override
	public User get(int id) {
		for(User user : users) {
			if(user.getId() == id)
				return user;
		}
		return null;
		
	}

	@Override
	public User getByMail(String mail) {
		for(User user : users) {
			if(user.getMail() == mail)
				return user; }
		return null;
	}

	@Override
	public User getByMailAndPassword(String mail, String password) {
		for(User user : users) {
			if(user.getMail() == mail && user.getPassword() == password)
				return user; }
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}

}

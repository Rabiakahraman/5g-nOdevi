package eCommerce.Business.abstracts;

import java.util.List;

import eCommerce.entities.concretes.User;

public interface UserService {

	void add(User user);
	void remove(User user);
	void update(User user);
	void verifyUser(int id);
	   User get(int id);
	 
	   List<User> getAll();
	User getByMailAndPassword(String mail, String password);
	User getByMail(String mail);
}

package eCommerce.dataAccess.abstracts;

import java.util.List;

import eCommerce.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void delete(User user);
	void update(User user);
	User get(int id);
	User getByMail(String mail);
	User getByMailAndPassword(String mail,String password);
	List<User> getAll();
	

}

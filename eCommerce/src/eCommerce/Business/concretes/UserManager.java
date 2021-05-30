package eCommerce.Business.concretes;

import java.util.List;

import eCommerce.Business.abstracts.UserService;
import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class UserManager implements UserService {
	
	private UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		userDao.add(user);
		
	}

	@Override
	public void remove(User user) {
		userDao.delete(user);
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public void verifyUser(int id) {
		User user = userDao.get(id);
		user.setVerified(true);
		System.out.println("Kullanýcý baþarýyla doðrulandý..");
	}

	@Override
	public User get(int id) {
		return userDao.get(id);
		
	}

	
	@Override
	public User getByMail(String mail) {
		return userDao.getByMail(mail);
	}

	
	@Override
	public User getByMailAndPassword(String mail, String password) {
		
		return userDao.getByMailAndPassword(mail, password);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();

	}

}

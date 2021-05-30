package eCommerce.core;

public interface AuthService {

	void login(String mail, String password);
	void register(int id, String mail, String password, String firstName, String lastName);

}

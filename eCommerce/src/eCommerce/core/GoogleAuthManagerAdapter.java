package eCommerce.core;
import eCommerce.GoogleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements AuthService {

	
	@Override
	public void register(int id, String mail, String password, String firstName, String lastName) {
		GoogleAuthManager googleAuthManager = new GoogleAuthManager();
		googleAuthManager.register(mail,password);
		
	}
	@Override
    public void login(String mail, String password) {
		GoogleAuthManager googleAuthManager = new GoogleAuthManager();
		googleAuthManager.login(mail,password);
	}


}

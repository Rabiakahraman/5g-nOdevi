package eCommerce;

import eCommerce.Business.abstracts.UserService;
import eCommerce.Business.concretes.AuthManager;
import eCommerce.Business.concretes.EmailManager;
import eCommerce.Business.concretes.UserManager;
import eCommerce.Business.concretes.UserValidationManager;
import eCommerce.core.AuthService;
import eCommerce.core.GoogleAuthManagerAdapter;
import eCommerce.dataAccess.concretes.InMemoryUserDao;

public class Main {

	public static void main(String[] args) {

		
		
		UserService userService = new UserManager(new InMemoryUserDao());
		AuthService authService = new AuthManager(userService, new UserValidationManager(), new EmailManager());
		authService.register(1, "rabia@gmail.com", "123456", "rabia", "kahraman");
		authService.register(2, "buyanlýseposta", "234567", "rabia", "kahraman");
		authService.register(3, "buyanlýseposta", "1", "m", "k");
		

		authService.login("rabia@gmail.com","123456");
		userService.verifyUser(1);
		authService.login("rabia@gmail.com","12345");
		authService.login("rabia@gmail.com","123456");
		authService.login("", "");
		
		authService.login("rabia@gmail.com","123456");
		userService.verifyUser(1);
		authService.login("rabia@gmail.com","12345");
		authService.login("rabia@gmail.com","123456");
		authService.login("", "");
		
		
		
		AuthService googleAuthService = new GoogleAuthManagerAdapter();
		googleAuthService.register(5,"zeynep@gmail.com","234567","zeynep","korkmaz");
		googleAuthService.login("klyyc7@gmail.com", "123halit1234");
		
		
		
	}

}

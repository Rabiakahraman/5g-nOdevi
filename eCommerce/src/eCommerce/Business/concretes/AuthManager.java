package eCommerce.Business.concretes;

import eCommerce.Business.abstracts.EmailService;
import eCommerce.Business.abstracts.UserService;
import eCommerce.Business.abstracts.UserValidationService;
import eCommerce.core.AuthService;
import eCommerce.core.BusinessRules;
import eCommerce.entities.concretes.User;

public class AuthManager implements AuthService {
	
	UserService userService;
	UserValidationService userValidationService;
	EmailService mailService;
	
	public AuthManager(UserService userService, UserValidationService userValidationService, EmailService mailService) {
		super();
		this.userService = userService;
		this.userValidationService = userValidationService;
		this.mailService = mailService;
	}

	@Override
	public void register(int id, String mail, String password, String firstName, String lastName) {
    User userToRegister = new User(id,mail,password,firstName,lastName,false);
		
		if(!userValidationService.validate(userToRegister)) {
			System.out.println("Validasyon i�lemi ba�ar�s�z. L�tfen t�m alanlar� do�ru girdi�inizden emin olunuz.");
			return;
		}
		
		if(!BusinessRules.run(checkIfUserExists(mail))) {
			System.out.println("Kay�t olma i�lemi ba�ar�s�z. Bu email ile bir ba�ka �ye mevcut.");
			return;
		}
		
		System.out.println("Ba�ar�yla kay�t olundu. �yeli�inizi do�rulamak i�in l�tfen e-posta adresinizi kontrol ediniz.");
		mailService.send("Deneme do�rulama mesaj�d�r. Do�rulamak i�in kodlama.io/dogrula?id=xyz&token=abc adresine gidin.", userToRegister.getMail());
		userService.add(userToRegister);
	}

	

	
	@Override
	public void login(String mail, String password) {
		if(!BusinessRules.run(checkIfAllFieldsFilled(mail, password))) {
			System.out.println("Giri� ba�ar�s�z. Inputlar do�ru doldurulmad�.");
			return;
		}
		
		User userToLogin = userService.getByMailAndPassword(mail, password);
		
		if(userToLogin == null) {
			System.out.println("Giri� ba�ar�s�z. E-posta adresiniz veya �ifreniz yanl��.");
			return;
		}
		
		if(!checkIfUserVerified(userToLogin)) {
			System.out.println("Giri� ba�ar�s�z. �yeli�inizi do�rulamad�n�z.");
			return;
		}
		System.out.println("Giri� ba�ar�l�. Ho�geldiniz : " + userToLogin.getFirstName() + " " + userToLogin.getLastName());
		
	}
	private boolean checkIfUserExists(String mail) {
		return userService.getByMail(mail) == null;
		
	}


	private boolean checkIfUserVerified(User user) {
		return user.isVerified();

	}

	private boolean checkIfAllFieldsFilled(String mail, String password) {
		if(mail.length()<=0 || password.length() <=0) {
			return false;
		}
		return true;
	}
	
	


}

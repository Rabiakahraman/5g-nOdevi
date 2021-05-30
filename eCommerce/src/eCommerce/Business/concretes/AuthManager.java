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
			System.out.println("Validasyon iþlemi baþarýsýz. Lütfen tüm alanlarý doðru girdiðinizden emin olunuz.");
			return;
		}
		
		if(!BusinessRules.run(checkIfUserExists(mail))) {
			System.out.println("Kayýt olma iþlemi baþarýsýz. Bu email ile bir baþka üye mevcut.");
			return;
		}
		
		System.out.println("Baþarýyla kayýt olundu. Üyeliðinizi doðrulamak için lütfen e-posta adresinizi kontrol ediniz.");
		mailService.send("Deneme doðrulama mesajýdýr. Doðrulamak için kodlama.io/dogrula?id=xyz&token=abc adresine gidin.", userToRegister.getMail());
		userService.add(userToRegister);
	}

	

	
	@Override
	public void login(String mail, String password) {
		if(!BusinessRules.run(checkIfAllFieldsFilled(mail, password))) {
			System.out.println("Giriþ baþarýsýz. Inputlar doðru doldurulmadý.");
			return;
		}
		
		User userToLogin = userService.getByMailAndPassword(mail, password);
		
		if(userToLogin == null) {
			System.out.println("Giriþ baþarýsýz. E-posta adresiniz veya þifreniz yanlýþ.");
			return;
		}
		
		if(!checkIfUserVerified(userToLogin)) {
			System.out.println("Giriþ baþarýsýz. Üyeliðinizi doðrulamadýnýz.");
			return;
		}
		System.out.println("Giriþ baþarýlý. Hoþgeldiniz : " + userToLogin.getFirstName() + " " + userToLogin.getLastName());
		
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

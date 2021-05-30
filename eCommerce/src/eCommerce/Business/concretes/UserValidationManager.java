package eCommerce.Business.concretes;


import java.util.regex.Pattern;

import eCommerce.Business.abstracts.UserValidationService;
import eCommerce.core.ValidationRules;
import eCommerce.entities.concretes.User;

public class UserValidationManager implements UserValidationService {
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		    

	@Override
	public boolean validate(User user) {
		boolean result = ValidationRules.run(
				isEmailFormatValid(user.getMail()),
				isPasswordLengthValid(user.getPassword()),
				isFirstNameLengthValid(user.getFirstName()),
				isLastNameLengthValid(user.getLastName()),
				isAllFieldsFilled(user.getFirstName(), user.getLastName(), user.getMail(), user.getPassword())
				);
		return result;	}

	private boolean isAllFieldsFilled(String firstName, String lastName, String mail, String password) {
		if(firstName.length() <= 0 || lastName.length() <= 0 || mail.length() <= 0 || password.length() <= 0) {
			return false; }		
		return true;
	}

	private boolean isLastNameLengthValid(String lastName) {
		return lastName.length() > 2;
	}

	private boolean isFirstNameLengthValid(String firstName) {
		return firstName.length() > 2;
	}

	private boolean isPasswordLengthValid(String password) {
		return password.length() > 6;
	}

	private boolean isEmailFormatValid(String mail) {
		 
		return VALID_EMAIL_ADDRESS_REGEX.matcher(mail).find();
	}

}

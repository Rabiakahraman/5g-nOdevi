package eCommerce.Business.abstracts;

import eCommerce.entities.concretes.User;

public interface UserValidationService {

	boolean validate(User user);

}

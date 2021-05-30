package eCommerce.Business.concretes;

import eCommerce.Business.abstracts.EmailService;

public class EmailManager implements EmailService {

	@Override
	public void send(String message, String to) {
		System.out.println("E-posta Manager : " + message + " mesajý " + to + " adresine gönderildi.");

	}

}

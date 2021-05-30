package eCommerce.entities.concretes;

import eCommerce.entities.abstracts.IEntity;

public class User implements IEntity{
	private int id;
	private String FirstName;
	private String lastName;
	private String mail;
	private String password;
	private boolean verified;
	
	public User() {}
	
	public User(int id, String firstName, String lastName, String mail, String password, boolean verified) {
		super();
		this.id = id;
		FirstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.password = password;
		this.verified = verified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

}

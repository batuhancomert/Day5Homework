package eTradeSimulator.adapters;

import eTradeSimulator.business.abstracts.UserVerificationService;
import eTradeSimulator.entities.concretes.User;
import eTradeSimulator.google.GoogleValidation;
import eTradeSimulator.google.UserGoogle;

public class GoogleValidationAdapter implements UserVerificationService {
	
	private String password;
	private int id;

	public GoogleValidationAdapter(String password, int id) {
		super();
		this.password = password;
		this.id = id;
	}

	@Override
	public boolean validation(String email) {
		if(email!=null) {
			GoogleValidation googleValidation = new GoogleValidation();
			googleValidation.validation();
			return true;
		}
		return false;
	}
	
	public User mappingUser() {
		User user = new User();
		UserGoogle userGoogle = new UserGoogle();
		user.setId(id);
		user.setFirstName(userGoogle.getFirstName());
		user.setLastName(userGoogle.getLastName());
		user.seteMail(userGoogle.geteMail());
		user.setPassword(password);
		
		return user;
		
	}
}

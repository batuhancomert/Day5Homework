package eTradeSimulator.business.concretes;

import eTradeSimulator.business.abstracts.UserVerificationService;

public class UserVerificationManager implements UserVerificationService {

	@Override
	public boolean validation(String email) {
	    
		if(email!=null) {
			System.out.println("********Clicked on the Link********");
			return true;
		}
		return false;
	}

}

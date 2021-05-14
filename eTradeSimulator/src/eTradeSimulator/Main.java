package eTradeSimulator;

import eTradeSimulator.adapters.GoogleValidationAdapter;
import eTradeSimulator.business.abstracts.UserService;
import eTradeSimulator.business.concretes.UserManager;
import eTradeSimulator.business.concretes.UserVerificationManager;
import eTradeSimulator.dataAccess.concretes.HibernateDao;
import eTradeSimulator.entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		User user1 = new User(1, "Batuhan", "Cömert", "addaa@a.com", "1234567");
		User user2 = new User(2, "Eyüp", "Tigu", "tiguu@gmail.com", "1234567");

		UserService userManager1 = new UserManager(new UserVerificationManager(), new HibernateDao());
		userManager1.register(user1);
		System.out.println("");
		userManager1.register(user2);
		System.out.println("");

		GoogleValidationAdapter googleValidationAdapter = new GoogleValidationAdapter("1234567", 2);
		User userGoogle = googleValidationAdapter.mappingUser();

		UserService userManager2 = new UserManager(googleValidationAdapter, new HibernateDao());
		userManager2.register(userGoogle);
		
		
		

	}

}

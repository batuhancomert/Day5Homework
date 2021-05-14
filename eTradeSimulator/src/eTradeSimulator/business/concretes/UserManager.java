package eTradeSimulator.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eTradeSimulator.business.abstracts.UserService;
import eTradeSimulator.business.abstracts.UserVerificationService;
import eTradeSimulator.dataAccess.abstracts.UserDao;
import eTradeSimulator.entities.concretes.User;

public class UserManager implements UserService {

	UserVerificationService userVerificationService;
	UserDao userDao;

	public UserManager(UserVerificationService userVerificationService, UserDao userDao) {
		
		this.userVerificationService = userVerificationService;
		this.userDao = userDao;
	}

	@Override
	public boolean register(User user) {
		if (registerRules(user) && emailControl(user)) {
			System.out.println("Do�rulama i�in E-Postan�za g�nderdi�imiz linke t�klay�n");
			if(validationLink(user)) {
				System.out.println(user.getFirstName()+" "+user.getLastName());
				userDao.add(user);
				return true;
			}else {
				System.out.println("Do�rulama i�in E-Postan�za g�nderdi�imiz linke t�klay�n");
				return false;
			}

		}

		return false;
	}

	@Override
	public void login(String eMail, String password) {
		for (User user1 : userDao.getAll()) {
			if (user1.geteMail() == eMail && user1.getPassword() == password) {
				System.out.println("Bilgiler do�ru Giri� ba�ar�l�");

			}

		}
		System.out.println("Yanl�� veya Hatal� bilgi girdiniz,l�tfen tekrar deneyin");

	}

	@Override
	public void delete(User user) {
		userDao.delete(user);

	}

	@Override
	public void update(User user) {
		userDao.update(user);

	}

	@Override
	public List<User> getAll() {

		return userDao.getAll();
	}

	@Override
	public User getById(int id) {

		return userDao.getById(id);
	}

	public boolean registerRules(User user) {
		String regex = "^[a-z0-9._+-]+@[a-z0-9.-]+.(com|org|net|gov)(.[a-z]{2})?$";
		Pattern pattern = Pattern.compile(regex);
		Matcher control = pattern.matcher(user.geteMail());
		
		if( user.getFirstName().length() > 2 
				&& control.matches() 
				&& user.getLastName().length() > 2 
				&& user.getPassword().length() > 6) {
		
			return true;
		}else {
			
			System.out.println("Eksik veya hatal� bilgi girdiniz l�tfen tekrar deneyiniz");
			return false;
		}

	}

	public boolean emailControl(User user) {
		for (User user1 : userDao.getAll()) {
			if (user1.geteMail() == user.geteMail()) {
				System.out.println("Ge�ersiz bir email Adresi girdiniz");
				return false;
			}

		}
		return true;
	}

	public boolean validationLink(User user) {
		if (userVerificationService.validation(user.geteMail()) == true) {
			System.out.println("E-posta do�rulamas� ba�ar�l� | Kay�t Tamamland�");
			return true;
		}
		return false;
	}

}

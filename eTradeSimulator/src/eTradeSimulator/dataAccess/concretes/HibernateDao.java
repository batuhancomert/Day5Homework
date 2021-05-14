package eTradeSimulator.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTradeSimulator.dataAccess.abstracts.UserDao;
import eTradeSimulator.entities.concretes.User;

public class HibernateDao implements UserDao {
	
	List<User> userList =new ArrayList<User>();

	@Override
	public void add(User user) {
		System.out.println("Þahýs Eklendi");
		userList.add(user);
		
	}

	@Override
	public void delete(User user) {
		for (User user1 : userList) {
			if(user1.getId()==user1.getId()) {
				User deletedUser = user1;
				userList.remove(deletedUser);
			}
			
		}
		
	}

	@Override
	public void update(User user) {
		User updatedUser;
		for (User user1 : userList) {
			if(user1.getId()==user1.getId()) {
				updatedUser = user1;
				updatedUser.setFirstName(user.getFirstName());
				updatedUser.setLastName(user.getLastName());
				updatedUser.seteMail(user.geteMail());
				updatedUser.setPassword(user.getPassword());
			}
			
		}
		
	}

	@Override
	public List<User> getAll() {
		
		return userList;
	}

	@Override
	public User getById(int id) {
		for (User user1 : userList) {
			if(user1.getId()==id) {
				return user1;
			}
			
		}
		return null;
	}

}

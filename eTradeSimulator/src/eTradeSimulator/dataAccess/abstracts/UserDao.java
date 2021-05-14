package eTradeSimulator.dataAccess.abstracts;

import java.util.List;

import eTradeSimulator.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void delete(User user);
	void update(User user);
	List<User> getAll();
	User getById(int id);

}

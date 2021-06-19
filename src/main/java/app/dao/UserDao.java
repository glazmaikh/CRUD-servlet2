package app.dao;

import app.entities.User;

import java.util.List;

public interface UserDao {
    boolean saveUser(User user);
    List<User> getUsers();
}

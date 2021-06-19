package app.dao;

import app.connect.ConnectPostgreSQL;
import app.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    @Override
    public boolean saveUser(User user) {
        String INSERT = "INSERT INTO usr (name, surname, age, email) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnectPostgreSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)
        ) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setString(5, user.getEmail());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String SELECT_ALL = "SELECT * FROM usr ORDER BY id";

        try(Connection connection = ConnectPostgreSQL.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                int age = resultSet.getInt(4);
                String email = resultSet.getString(5);

                User user = new User(id, name, surname, age, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}

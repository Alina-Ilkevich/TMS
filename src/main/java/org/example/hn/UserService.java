package org.example.hn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
    public static User getUserInfo(int id) {
        try {
            Connection connection = PostgresDriverManager.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setLogin(resultSet.getString("login"));
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static boolean changeUserLogin(User user) throws SQLException {
        Connection connection = PostgresDriverManager.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("update users set login=? where id=?;");
        statement.setInt(2, user.getId());
        statement.setString(1, user.getLogin());
        return statement.executeUpdate() > 0;
    }
    public static boolean createUser(User user) throws SQLException {
        Connection connection = PostgresDriverManager.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into users (id, name, age, login) values (?, ?, ?, ?);");
        statement.setInt(1, user.getId());
        statement.setString(2, user.getName());
        statement.setInt(3, user.getAge());
        statement.setString(4, user.getLogin());
        return statement.executeUpdate() > 0;
    }
    public static boolean deleteUser(int id) {
        try {
            Connection connection = PostgresDriverManager.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from users where id = ?;");
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

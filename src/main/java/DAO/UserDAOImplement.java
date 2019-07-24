package DAO;

import Model.User;
import Util.MySQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImplement extends MySQLConnector implements DAO<User, Integer> {

    private Connection connection = getConnection();

    @Override
    public void add(User entity) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO `user` VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getSurname());
            preparedStatement.setString(3, entity.getAddress());
            preparedStatement.setString(4, entity.getPhone());
            preparedStatement.setString(5, entity.getLogin());
            preparedStatement.setString(6, entity.getPassword());
            preparedStatement.setString(7,entity.getRole().getRoleToString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!= null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getEntityByKey(Integer id) {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }
}

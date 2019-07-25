package DAO;

import Model.Role;
import Model.User;
import Util.MySQLConnector;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImplement extends MySQLConnector implements DAOUser {

    private User setUserFromDb(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setAddress(resultSet.getString("address"));
            user.setPhone(resultSet.getString("phone"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(resultSet.getString("role"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    private User getUserFromDb(String sql, String parametr) {
        User user = new User();
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        try {
            preparedStatement.setString(1, parametr);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user = setUserFromDb(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return user;
    }

    private void setUserToDb(PreparedStatement preparedStatement, User entity)  {
        try {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getSurname());
            preparedStatement.setString(4, entity.getAddress());
            preparedStatement.setString(5, entity.getPhone());
            preparedStatement.setString(6, entity.getLogin());
            preparedStatement.setString(7, entity.getPassword());
            preparedStatement.setString(8, entity.getRole().getRoleToString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT id, name, surname, address, phone, login, password, role FROM `user`";
        Statement statement = getStatament();
        try {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = setUserFromDb(resultSet);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
        return userList;
    }

    @Override
    public void add(User entity) {
        String sql = "INSERT INTO `user` (id, name, surname, address, phone, login, password, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = getPrepareStatement(sql);

        try {
            setUserToDb(preparedStatement, entity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }

    }

    @Override
    public void update(User entity) {
        String sql = "UPDATE `user` SET id=?, name=?, surname=?, address=?, phone=?, login=?, password=?, role=? WHERE id=?";

        PreparedStatement preparedStatement = getPrepareStatement(sql);

        try {
            setUserToDb(preparedStatement, entity);
            preparedStatement.setInt(9, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public void delete(User entity) {
        String sql = "DELETE FROM `user` WHERE ID=?";
        PreparedStatement preparedStatement =getPrepareStatement(sql);

        try {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public User getEntityByKey(Integer id) {
        String sql = "SELECT id, name, surname, address, phone, login, password, role FROM `user` WHERE id = ?";
        User user = new User();
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        try {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user = setUserFromDb(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return user;
    }

    @Override
    public User getEntityBySurame(String surname) {
        String sql = "SELECT id, name, surname, address, phone, login, password, role FROM `user` WHERE surname LIKE ?";
        return getUserFromDb(sql, surname);
    }

    @Override
    public User getEntityByRole(Role role) {
        User user = new User();
        String sql = "SELECT id, name, surname, address, phone, login, password, role FROM `user` WHERE role LIKE ?";
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        try {
            preparedStatement.setString(1, role.getRoleToString());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user = setUserFromDb(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return user;
    }

    @Override
    public User getEntityByLogin(String login) {
        String sql = "SELECT id, name, surname, address, phone, login, password, role FROM `user` WHERE login LIKE ?";
        return getUserFromDb(sql, login);
    }
}
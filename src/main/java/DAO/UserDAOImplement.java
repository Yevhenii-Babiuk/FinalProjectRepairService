package dao;

import model.Role;
import model.User;
import org.apache.log4j.Logger;
import util.MySQLConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Implementation of DAO interface for User
 */
public class UserDAOImplement extends MySQLConnector implements DAOUser {
    private static final Logger LOG = Logger.getLogger(UserDAOImplement.class);
    /**
     * Method for find all user
     * @return List of users
     */
    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT id, name, surname, address, phone, login, password, role FROM `user`";
        Connection connection = getConnection();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setAddress(resultSet.getString("address"));
                user.setPhone(resultSet.getString("phone"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                userList.add(user);
            }
        } catch (SQLException e) {
            try {
                if (!resultSet.next()) {
                    return null;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return userList;
    }

    /**
     * Add entity into DB
     * @param entity get entity to insert it to DB
     */
    @Override
    public void add(User entity) {
        String sql = "INSERT INTO `user` (id, name, surname, address, phone, login, password, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getSurname());
            preparedStatement.setString(4, entity.getAddress());
            preparedStatement.setString(5, entity.getPhone());
            preparedStatement.setString(6, entity.getLogin());
            preparedStatement.setString(7, entity.getPassword());
            preparedStatement.setString(8, entity.getRole().getRoleToString());
            preparedStatement.executeUpdate();
            LOG.debug("Executed query "+sql);
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Update entity into DB
     * @param entity get entity to update new values into DB
     */
    @Override
    public void update(User entity) {
        String sql = "UPDATE `user` SET id=?, name=?, surname=?, address=?, phone=?, login=?, password=?, role=? WHERE id=?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getSurname());
            preparedStatement.setString(4, entity.getAddress());
            preparedStatement.setString(5, entity.getPhone());
            preparedStatement.setString(6, entity.getLogin());
            preparedStatement.setString(7, entity.getPassword());
            preparedStatement.setString(8, entity.getRole().getRoleToString());
            preparedStatement.setInt(9, entity.getId());
            preparedStatement.executeUpdate();
            LOG.debug("Executed query "+sql);
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Delete entity in DB
     * @param entity what need to delete
     */
    @Override
    public void delete(User entity) {
        String sql = "DELETE FROM `user` WHERE id=?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
            LOG.debug("Executed query "+sql);
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Get entity by parameter
     * @param id parameter for find entity
     * @return entity
     */
    @Override
    public User getEntityByKey(Integer id) {
        String sql = "SELECT id, name, surname, address, phone, login, password, role FROM `user` WHERE id = ?";
        User user = new User();
        ResultSet resultSet = null;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setAddress(resultSet.getString("address"));
            user.setPhone(resultSet.getString("phone"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(resultSet.getString("role"));
        }catch (SQLException e) {
            try {
                if (!resultSet.next()) {
                    return null;}
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    /**
     * Get entity by parameter
     * @param surname parameter for find entity
     * @return entity
     */
    @Override
    public User getEntityBySurname(String surname) {
        String sql = "SELECT id, name, surname, address, phone, login, password, role FROM `user` WHERE surname LIKE ?";
        User user = new User();
        ResultSet resultSet = null;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, surname);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setAddress(resultSet.getString("address"));
            user.setPhone(resultSet.getString("phone"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(resultSet.getString("role"));
        } catch (SQLException e) {
            try {
                if (!resultSet.next()) {
                    return null;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    /**
     * Get entity by role
     * @param role parameter for find entity
     * @return list of entity
     */
    @Override
    public List<User> getEntityByRole(Role role) {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT id, name, surname, address, phone, login, password, role FROM `user` WHERE role LIKE ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, role.getRoleToString());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setAddress(resultSet.getString("address"));
                user.setPhone(resultSet.getString("phone"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                userList.add(user);
            }
            LOG.debug("Executed query "+sql);
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return userList;
    }

    /**
     * Get entity by login
     * @param login parameter for find entity
     * @return entity
     */
    @Override
    public User getEntityByLogin(String login) {
        String sql = "SELECT id, name, surname, address, phone, login, password, role FROM `user` WHERE login LIKE ?";
        User user = new User();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setAddress(resultSet.getString("address"));
            user.setPhone(resultSet.getString("phone"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(resultSet.getString("role"));
            LOG.debug("Executed query "+sql);
        } catch (SQLException e) {
            try {
                if (!resultSet.next()) {
                    return null;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }
}
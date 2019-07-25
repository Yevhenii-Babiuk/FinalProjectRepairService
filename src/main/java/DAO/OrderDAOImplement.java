package DAO;

import Model.Order;
import Util.MySQLConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImplement extends MySQLConnector implements DAOOrder {

    private Order setOrderFromDb(ResultSet resultSet) {
        Order order = new Order();
        try {
            order.setId(resultSet.getInt("id"));
            order.setClient(resultSet.getInt("client"));
            order.setManager(resultSet.getInt("manager"));
            order.setMaster(resultSet.getInt("master"));
            order.setDevice(resultSet.getInt("device"));
            order.setProblem(resultSet.getInt("problem"));
            order.setStart_date(resultSet.getDate("start_date"));
            order.setStatus(resultSet.getBoolean("status"));
            order.setEnd_date(resultSet.getDate("end_date"));
            order.setFeedback(resultSet.getInt("feedback"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }

    private void setOrderToDb(PreparedStatement preparedStatement, Order entity) {
        try {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setInt(2, entity.getClient());
            preparedStatement.setInt(3, entity.getManager());
            preparedStatement.setInt(4, entity.getMaster());
            preparedStatement.setInt(5, entity.getDevice());
            preparedStatement.setInt(6, entity.getProblem());
            preparedStatement.setDate(7, entity.getStart_date());
            preparedStatement.setBoolean(8, entity.isStatus());
            preparedStatement.setDate(9, entity.getEnd_date());
            preparedStatement.setInt(10, entity.getFeedback());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Order getOrderFromDb(String sql, Integer parametr) {
        Order order = new Order();
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        try {
            preparedStatement.setInt(1, parametr);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            order = setOrderFromDb(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return order;
    }

    private Order getOrderFromDb(String sql, Date min, Date max) {
        Order order = new Order();
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        try {
            preparedStatement.setDate(1, min);
            preparedStatement.setDate(2, max);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            order = setOrderFromDb(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return order;
    }

    @Override
    public Order getOrderByClient(Integer client) {
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order` WHERE client = ?";
        return getOrderFromDb(sql, client);
    }

    @Override
    public Order getOrderByManager(Integer manager) {
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order` WHERE manager = ?";
        return getOrderFromDb(sql, manager);
    }

    @Override
    public Order getOrderByMaster(Integer master) {
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order` WHERE master = ?";
        return getOrderFromDb(sql, master);
    }

    @Override
    public Order getOrderByDevice(Integer device) {
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order` WHERE device = ?";
        return getOrderFromDb(sql, device);
    }

    @Override
    public Order getOrderByProblem(Integer problem) {
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order` WHERE problem = ?";
        return getOrderFromDb(sql, problem);
    }

    @Override
    public Order getOrderByStartDate(Date min, Date max) {
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order` WHERE start_date BETWEEN ? AND ?";
        return getOrderFromDb(sql, min, max);
    }

    @Override
    public Order getOrderByEndDate(Date min, Date max) {
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order` WHERE end_date BETWEEN ? AND ?";
        return getOrderFromDb(sql, min, max);
    }

    @Override
    public Order getOrderByStatus(Boolean status) {
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order` WHERE status IS ?";
        Order order = new Order();
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        try {
            preparedStatement.setBoolean(1, status);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            order = setOrderFromDb(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return order;
    }

    @Override
    public void add(Order entity) {
        String sql = "INSERT INTO `order` (id, client, manager, master, device, problem, start_date, status, end_date, feedback) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = getPrepareStatement(sql);

        try {
            setOrderToDb(preparedStatement, entity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public List<Order> getAll() throws SQLException {
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order`";
        Statement statement = getStatament();
        try {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Order order = setOrderFromDb(resultSet);
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
        return orderList;
    }

    @Override
    public Order getEntityByKey(Integer id) {
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order` WHERE id = ?";
        return getOrderFromDb(sql, id);
    }

    @Override
    public void update(Order entity) {
        String sql = "UPDATE `order` SET id=?, client=?, manager=?, master=?, device=?, problem=?, start_date=?, status=?, end_date=?, feedback=? WHERE id=?";

        PreparedStatement preparedStatement = getPrepareStatement(sql);

        try {
            setOrderToDb(preparedStatement, entity);
            preparedStatement.setInt(4, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public void delete(Order entity) {
        String sql = "DELETE  FROM `order` WHERE id=?";
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
}

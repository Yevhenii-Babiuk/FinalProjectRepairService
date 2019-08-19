package dao;

import model.Order;
import model.Status;
import org.apache.log4j.Logger;
import util.MySQLConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of DAO interface for Order
 */
public class OrderDAOImplement extends MySQLConnector implements DAOOrder {

    private static final Logger LOG = Logger.getLogger(OrderDAOImplement.class);

    /**
     * @param client parameter for find entity
     * @return list of entity
     */
    @Override
    public List<Order> getOrderByClient(Integer client) {
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT id, client, manager, master, device, comment, problem, start_date, status, end_date, feedback FROM `order` WHERE client = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, client);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setClient(resultSet.getInt("client"));
                order.setMaster(resultSet.getInt("master"));
                order.setManager(resultSet.getInt("manager"));
                order.setDevice(resultSet.getInt("device"));
                order.setComment(resultSet.getString("comment"));
                order.setProblem(resultSet.getInt("problem"));
                order.setStart_date(resultSet.getDate("start_date"));
                order.setStatus(resultSet.getString("status"));
                order.setEnd_date(resultSet.getDate("end_date"));
                order.setFeedback(resultSet.getInt("feedback"));
                orderList.add(order);
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
        return orderList;
    }

    /**
     * @param master parameter for find entity
     * @return list of entity
     */
    @Override
    public List<Order> getOrderByMaster(Integer master) {
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT id, client, manager, master, device, comment, problem, start_date, status, end_date, feedback FROM `order` WHERE master = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, master);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setClient(resultSet.getInt("client"));
                order.setMaster(resultSet.getInt("master"));
                order.setManager(resultSet.getInt("manager"));
                order.setDevice(resultSet.getInt("device"));
                order.setComment(resultSet.getString("comment"));
                order.setProblem(resultSet.getInt("problem"));
                order.setStart_date(resultSet.getDate("start_date"));
                order.setStatus(resultSet.getString("status"));
                order.setEnd_date(resultSet.getDate("end_date"));
                order.setFeedback(resultSet.getInt("feedback"));
                orderList.add(order);
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
        return orderList;
    }

    /**
     * @param manager parameter for find entity
     * @return list of entity
     */
    @Override
    public List<Order> getOrderByManager(Integer manager) {
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT id, client, manager, master, device, comment, problem, start_date, status, end_date, feedback FROM `order` WHERE manager = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, manager);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setClient(resultSet.getInt("client"));
                order.setMaster(resultSet.getInt("master"));
                order.setManager(resultSet.getInt("manager"));
                order.setDevice(resultSet.getInt("device"));
                order.setComment(resultSet.getString("comment"));
                order.setProblem(resultSet.getInt("problem"));
                order.setStart_date(resultSet.getDate("start_date"));
                order.setStatus(resultSet.getString("status"));
                order.setEnd_date(resultSet.getDate("end_date"));
                order.setFeedback(resultSet.getInt("feedback"));
                orderList.add(order);
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
        return orderList;
    }

    /**
     * @param device parameter for find entity
     * @return list of entity
     */
    @Override
    public List<Order> getOrderByDevice(Integer device) {
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT id, client, manager, master, device, comment, problem, start_date, status, end_date, feedback FROM `order` WHERE device = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, device);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setClient(resultSet.getInt("client"));
                order.setMaster(resultSet.getInt("master"));
                order.setManager(resultSet.getInt("manager"));
                order.setDevice(resultSet.getInt("device"));
                order.setComment(resultSet.getString("comment"));
                order.setProblem(resultSet.getInt("problem"));
                order.setStart_date(resultSet.getDate("start_date"));
                order.setStatus(resultSet.getString("status"));
                order.setEnd_date(resultSet.getDate("end_date"));
                order.setFeedback(resultSet.getInt("feedback"));
                orderList.add(order);
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
        return orderList;
    }

    /**
     * @param problem parameter for find entity
     * @return list of entity
     */
    @Override
    public List<Order> getOrderByProblem(Integer problem) {
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT id, client, manager, master, device, comment, problem, start_date, status, end_date, feedback FROM `order` WHERE problem = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, problem);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setClient(resultSet.getInt("client"));
                order.setMaster(resultSet.getInt("master"));
                order.setManager(resultSet.getInt("manager"));
                order.setDevice(resultSet.getInt("device"));
                order.setComment(resultSet.getString("comment"));
                order.setProblem(resultSet.getInt("problem"));
                order.setStart_date(resultSet.getDate("start_date"));
                order.setStatus(resultSet.getString("status"));
                order.setEnd_date(resultSet.getDate("end_date"));
                order.setFeedback(resultSet.getInt("feedback"));
                orderList.add(order);
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
        return orderList;
    }

    /**
     * @param min minimal Date to search when order entered to service
     * @param max maximum Date to search when order entered to service
     * @return list of orders
     */
    @Override
    public List<Order>getOrderByStartDate(Date min, Date max) {
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT id, client, manager, master, device, comment, problem, start_date, status, end_date, feedback FROM `order` WHERE start_date BETWEEN ? AND ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, min);
            preparedStatement.setDate(2, max);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setClient(resultSet.getInt("client"));
                order.setMaster(resultSet.getInt("master"));
                order.setManager(resultSet.getInt("manager"));
                order.setDevice(resultSet.getInt("device"));
                order.setComment(resultSet.getString("comment"));
                order.setProblem(resultSet.getInt("problem"));
                order.setStart_date(resultSet.getDate("start_date"));
                order.setStatus(resultSet.getString("status"));
                order.setEnd_date(resultSet.getDate("end_date"));
                order.setFeedback(resultSet.getInt("feedback"));
                orderList.add(order);
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
        return orderList;
    }

    /**
     * @param min minimal Date to search when order will done
     * @param max maximum Date to search when order will done
     * @return list of orders
     */
    @Override
    public List<Order> getOrderByEndDate(Date min, Date max) {
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT id, client, manager, master, device, comment, problem, start_date, status, end_date, feedback FROM `order` WHERE end_date BETWEEN ? AND ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, min);
            preparedStatement.setDate(2, max);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setClient(resultSet.getInt("client"));
                order.setMaster(resultSet.getInt("master"));
                order.setManager(resultSet.getInt("manager"));
                order.setDevice(resultSet.getInt("device"));
                order.setComment(resultSet.getString("comment"));
                order.setProblem(resultSet.getInt("problem"));
                order.setStart_date(resultSet.getDate("start_date"));
                order.setStatus(resultSet.getString("status"));
                order.setEnd_date(resultSet.getDate("end_date"));
                order.setFeedback(resultSet.getInt("feedback"));
                orderList.add(order);
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
        return orderList;
    }

    /**
     * @param status parameter for find entity
     * @return list of entity
     */
    @Override
    public List<Order> getOrderByStatus(Status status) {
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT id, client, manager, master, device, comment, problem, start_date, status, end_date, feedback FROM `order` WHERE status LIKE  ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, status.getStatusToString());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setClient(resultSet.getInt("client"));
                order.setMaster(resultSet.getInt("master"));
                order.setManager(resultSet.getInt("manager"));
                order.setDevice(resultSet.getInt("device"));
                order.setComment(resultSet.getString("comment"));
                order.setProblem(resultSet.getInt("problem"));
                order.setStart_date(resultSet.getDate("start_date"));
                order.setStatus(resultSet.getString("status"));
                order.setEnd_date(resultSet.getDate("end_date"));
                order.setFeedback(resultSet.getInt("feedback"));
                orderList.add(order);
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
        return orderList;
    }

    /**
     * Add entity into DB
     * @param entity get entity to insert it to DB
     */
    @Override
    public void add(Order entity) {
        String sql = "INSERT INTO `order` (id, client, master, manager, device, comment, problem, start_date, status, end_date, feedback) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setInt(2, entity.getClient());
            ;
            if (entity.getMaster()==0) {
                preparedStatement.setNull(3, java.sql.Types.INTEGER);
            } else {
                preparedStatement.setInt(3, entity.getMaster());
            }
            if (entity.getManager()==0) {
                preparedStatement.setNull(4, java.sql.Types.INTEGER);
            } else {
                preparedStatement.setInt(4, entity.getManager());
            }
            preparedStatement.setInt(5, entity.getDevice());
            preparedStatement.setString(6, entity.getComment());
            if (entity.getProblem()==0) {
                preparedStatement.setNull(7, java.sql.Types.INTEGER);
            } else {
                preparedStatement.setInt(7, entity.getProblem());
            }
            preparedStatement.setDate(8, entity.getStart_date());
            preparedStatement.setString(9, entity.getStatus().getStatusToString());
            if (entity.getEnd_date()==null) {
                preparedStatement.setNull(10, Types.DATE);
            } else {
                preparedStatement.setDate(10, entity.getEnd_date());
            }
            if (entity.getFeedback()==0) {
                preparedStatement.setNull(11, java.sql.Types.INTEGER);
            } else {
                preparedStatement.setInt(11, entity.getFeedback());
            }
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
     * Method for find all order
     * @return List of order
     */
    @Override
    public List<Order> getAll() {
        List<Order> orderList = new ArrayList<>();
        Connection connection = getConnection();
        String sql = "SELECT id, client, manager, master, device, comment, problem, start_date, status, end_date, feedback FROM `order`";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setClient(resultSet.getInt("client"));
                order.setMaster(resultSet.getInt("master"));
                order.setManager(resultSet.getInt("manager"));
                order.setDevice(resultSet.getInt("device"));
                order.setComment(resultSet.getString("comment"));
                order.setProblem(resultSet.getInt("problem"));
                order.setStart_date(resultSet.getDate("start_date"));
                order.setStatus(resultSet.getString("status"));
                order.setEnd_date(resultSet.getDate("end_date"));
                order.setFeedback(resultSet.getInt("feedback"));
                orderList.add(order);
            }
            LOG.debug("Executed query "+sql);
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
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
        return orderList;
    }

    /**
     * @param id parameter for find entity
     * @return list of entity
     */
    @Override
    public Order getEntityByKey(Integer id) {
        String sql = "SELECT id, client, manager, master, device, comment, problem, start_date, status, end_date, feedback FROM `order` WHERE id = ?";
        Connection connection = getConnection();
        Order order = new Order();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            order.setId(resultSet.getInt("id"));
            order.setClient(resultSet.getInt("client"));
            order.setMaster(resultSet.getInt("master"));
            order.setManager(resultSet.getInt("manager"));
            order.setDevice(resultSet.getInt("device"));
            order.setComment(resultSet.getString("comment"));
            order.setProblem(resultSet.getInt("problem"));
            order.setStart_date(resultSet.getDate("start_date"));
            order.setStatus(resultSet.getString("status"));
            order.setEnd_date(resultSet.getDate("end_date"));
            order.setFeedback(resultSet.getInt("feedback"));
            LOG.debug("Executed query "+sql);
        } catch (SQLException e) {
            try {
                if(!resultSet.next()){
                    return null;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                LOG.debug("SQLException occurred");
            }
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
        return order;
    }

    /**
     * Update entity into DB
     * @param entity get entity to update new values into DB
     */
    @Override
    public void update(Order entity) {
        String sql = "UPDATE `order` SET id=?, client=?, manager=?, master=?, device=?, comment=?, problem=?, start_date=?, status=?, end_date=?, feedback=? WHERE id=?";
        Connection connection =getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setInt(2, entity.getClient());
            preparedStatement.setInt(3, entity.getManager());
            preparedStatement.setInt(4, entity.getMaster());
            preparedStatement.setInt(5, entity.getDevice());
            preparedStatement.setString(6, entity.getComment());
            preparedStatement.setInt(7, entity.getProblem());
            preparedStatement.setDate(8, entity.getStart_date());
            preparedStatement.setString(9, entity.getStatus().getStatusToString());
            preparedStatement.setDate(10, entity.getEnd_date());
            if(entity.getFeedback()==0){
                preparedStatement.setNull(11, Types.INTEGER);
            }else{
            preparedStatement.setInt(11, entity.getFeedback());}
            preparedStatement.setInt(12, entity.getId());
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
    public void delete(Order entity) {
        Connection connection = getConnection();
        String sql = "DELETE  FROM `order` WHERE id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =connection.prepareStatement(sql);
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

}

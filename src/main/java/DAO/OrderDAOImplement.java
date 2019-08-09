package dao;

import model.Order;
import model.Status;
import util.MySQLConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImplement extends MySQLConnector implements DAOOrder {


    @Override
    public Order getOrderByClient(Integer client) {
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order` WHERE client = ?";
        Connection connection = getConnection();
        Order order = new Order();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, client);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            order.setId(resultSet.getInt("id"));
            order.setClient(resultSet.getInt("client"));
            order.setMaster(resultSet.getInt("master"));
            order.setManager(resultSet.getInt("manager"));
            order.setDevice(resultSet.getInt("device"));
            order.setProblem(resultSet.getInt("problem"));
            order.setStart_date(resultSet.getDate("start_date"));
            order.setStatus(resultSet.getString("status"));
            order.setEnd_date(resultSet.getDate("end_date"));
            order.setFeedback(resultSet.getInt("feedback"));
        } catch (SQLException e) {
            e.printStackTrace();
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

    @Override
    public Order getOrderByMaster(Integer master) {
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order` WHERE master = ?";
        Connection connection = getConnection();
        Order order = new Order();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, master);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            order.setId(resultSet.getInt("id"));
            order.setClient(resultSet.getInt("client"));
            order.setMaster(resultSet.getInt("master"));
            order.setManager(resultSet.getInt("manager"));
            order.setDevice(resultSet.getInt("device"));
            order.setProblem(resultSet.getInt("problem"));
            order.setStart_date(resultSet.getDate("start_date"));
            order.setStatus(resultSet.getString("status"));
            order.setEnd_date(resultSet.getDate("end_date"));
            order.setFeedback(resultSet.getInt("feedback"));
        } catch (SQLException e) {
            e.printStackTrace();
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

    @Override
    public Order getOrderByManager(Integer manager) {
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order` WHERE manager = ?";
        Connection connection = getConnection();
        Order order = new Order();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, manager);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            order.setId(resultSet.getInt("id"));
            order.setClient(resultSet.getInt("client"));
            order.setMaster(resultSet.getInt("master"));
            order.setManager(resultSet.getInt("manager"));
            order.setDevice(resultSet.getInt("device"));
            order.setProblem(resultSet.getInt("problem"));
            order.setStart_date(resultSet.getDate("start_date"));
            order.setStatus(resultSet.getString("status"));
            order.setEnd_date(resultSet.getDate("end_date"));
            order.setFeedback(resultSet.getInt("feedback"));
        } catch (SQLException e) {
            e.printStackTrace();
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

    @Override
    public Order getOrderByDevice(Integer device) {
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order` WHERE device = ?";
        Connection connection = getConnection();
        Order order = new Order();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, device);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            order.setId(resultSet.getInt("id"));
            order.setClient(resultSet.getInt("client"));
            order.setMaster(resultSet.getInt("master"));
            order.setManager(resultSet.getInt("manager"));
            order.setDevice(resultSet.getInt("device"));
            order.setProblem(resultSet.getInt("problem"));
            order.setStart_date(resultSet.getDate("start_date"));
            order.setStatus(resultSet.getString("status"));
            order.setEnd_date(resultSet.getDate("end_date"));
            order.setFeedback(resultSet.getInt("feedback"));
        } catch (SQLException e) {
            e.printStackTrace();
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

    @Override
    public Order getOrderByProblem(Integer problem) {
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order` WHERE problem = ?";
        Connection connection = getConnection();
        Order order = new Order();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, problem);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            order.setId(resultSet.getInt("id"));
            order.setClient(resultSet.getInt("client"));
            order.setMaster(resultSet.getInt("master"));
            order.setManager(resultSet.getInt("manager"));
            order.setDevice(resultSet.getInt("device"));
            order.setProblem(resultSet.getInt("problem"));
            order.setStart_date(resultSet.getDate("start_date"));
            order.setStatus(resultSet.getString("status"));
            order.setEnd_date(resultSet.getDate("end_date"));
            order.setFeedback(resultSet.getInt("feedback"));
        } catch (SQLException e) {
            e.printStackTrace();
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

    @Override
    public Order getOrderByStartDate(Date min, Date max) {
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order` WHERE start_date BETWEEN ? AND ?";
        Connection connection = getConnection();
        Order order = new Order();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, min);
            preparedStatement.setDate(2, max);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            order.setId(resultSet.getInt("id"));
            order.setClient(resultSet.getInt("client"));
            order.setMaster(resultSet.getInt("master"));
            order.setManager(resultSet.getInt("manager"));
            order.setDevice(resultSet.getInt("device"));
            order.setProblem(resultSet.getInt("problem"));
            order.setStart_date(resultSet.getDate("start_date"));
            order.setStatus(resultSet.getString("status"));
            order.setEnd_date(resultSet.getDate("end_date"));
            order.setFeedback(resultSet.getInt("feedback"));
        } catch (SQLException e) {
            e.printStackTrace();
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

    @Override
    public Order getOrderByEndDate(Date min, Date max) {
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order` WHERE end_date BETWEEN ? AND ?";
        Connection connection = getConnection();
        Order order = new Order();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, min);
            preparedStatement.setDate(2, max);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            order.setId(resultSet.getInt("id"));
            order.setClient(resultSet.getInt("client"));
            order.setMaster(resultSet.getInt("master"));
            order.setManager(resultSet.getInt("manager"));
            order.setDevice(resultSet.getInt("device"));
            order.setProblem(resultSet.getInt("problem"));
            order.setStart_date(resultSet.getDate("start_date"));
            order.setStatus(resultSet.getString("status"));
            order.setEnd_date(resultSet.getDate("end_date"));
            order.setFeedback(resultSet.getInt("feedback"));
        } catch (SQLException e) {
            e.printStackTrace();
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

    @Override
    public Order getOrderByStatus(Status status) {
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order` WHERE status LIKE  ?";
        Connection connection = getConnection();
        Order order = new Order();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, status.getStatusToString());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            order.setId(resultSet.getInt("id"));
            order.setClient(resultSet.getInt("client"));
            order.setMaster(resultSet.getInt("master"));
            order.setManager(resultSet.getInt("manager"));
            order.setDevice(resultSet.getInt("device"));
            order.setProblem(resultSet.getInt("problem"));
            order.setStart_date(resultSet.getDate("start_date"));
            order.setStatus(resultSet.getString("status"));
            order.setEnd_date(resultSet.getDate("end_date"));
            order.setFeedback(resultSet.getInt("feedback"));
        } catch (SQLException e) {
            e.printStackTrace();
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

    @Override
    public void add(Order entity) {
        String sql = "INSERT INTO `order` (id, client, master, manager, device, problem, start_date, status, end_date, feedback) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setInt(2, entity.getClient());
            preparedStatement.setInt(3, entity.getMaster());
            preparedStatement.setInt(4, entity.getManager());
            preparedStatement.setInt(5, entity.getDevice());
            preparedStatement.setInt(6, entity.getProblem());
            preparedStatement.setDate(7, entity.getStart_date());
            preparedStatement.setString(8, entity.getStatus().getStatusToString());
            preparedStatement.setDate(9, entity.getEnd_date());
            preparedStatement.setInt(10, entity.getFeedback());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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

    @Override
    public List<Order> getAll() {
        List<Order> orderList = new ArrayList<>();
        Connection connection = getConnection();
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order`";
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
                order.setProblem(resultSet.getInt("problem"));
                order.setStart_date(resultSet.getDate("start_date"));
                order.setStatus(resultSet.getString("status"));
                order.setEnd_date(resultSet.getDate("end_date"));
                order.setFeedback(resultSet.getInt("feedback"));
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

    @Override
    public Order getEntityByKey(Integer id) {
        String sql = "SELECT id, client, manager, master, device, problem, start_date, status, end_date, feedback FROM `order` WHERE id = ?";
        Connection connection = getConnection();
        Order order = new Order();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            order.setId(resultSet.getInt("id"));
            order.setClient(resultSet.getInt("client"));
            order.setMaster(resultSet.getInt("master"));
            order.setManager(resultSet.getInt("manager"));
            order.setDevice(resultSet.getInt("device"));
            order.setProblem(resultSet.getInt("problem"));
            order.setStart_date(resultSet.getDate("start_date"));
            order.setStatus(resultSet.getString("status"));
            order.setEnd_date(resultSet.getDate("end_date"));
            order.setFeedback(resultSet.getInt("feedback"));
        } catch (SQLException e) {
            e.printStackTrace();
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

    @Override
    public void update(Order entity) {
        String sql = "UPDATE `order` SET id=?, client=?, manager=?, master=?, device=?, problem=?, start_date=?, status=?, end_date=?, feedback=? WHERE id=?";
        Connection connection =getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setInt(2, entity.getClient());
            preparedStatement.setInt(3, entity.getManager());
            preparedStatement.setInt(4, entity.getMaster());
            preparedStatement.setInt(5, entity.getDevice());
            preparedStatement.setInt(6, entity.getProblem());
            preparedStatement.setDate(7, entity.getStart_date());
            preparedStatement.setString(8, entity.getStatus().getStatusToString());
            preparedStatement.setDate(9, entity.getEnd_date());
            preparedStatement.setInt(10, entity.getFeedback());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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

    @Override
    public void delete(Order entity) {
        Connection connection = getConnection();
        String sql = "DELETE  FROM `order` WHERE id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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

package dao;

import model.Device;
import org.apache.log4j.Logger;
import util.MySQLConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of DAO interface for Device
 */

public class DeviceDAOImplement extends MySQLConnector implements DAODevice {
    private static final Logger LOG = Logger.getLogger(DeviceDAOImplement.class);

    /**
     * Method for find all devices
     * @return List of devices
     */
    @Override
    public List<Device> getAll() {
        Connection connection = getConnection();
        List<Device> deviceList = new ArrayList<>();
        String sql = "SELECT id, client, brand, model, imei FROM `device`";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Device device = new Device();
                device.setId(resultSet.getInt("id"));
                device.setClient(resultSet.getInt("client"));
                device.setBrand(resultSet.getString("brand"));
                device.setModel(resultSet.getString("model"));
                device.setImei(resultSet.getString("imei"));
                deviceList.add(device);
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
        return deviceList;
    }

    /**
     * Add entity into DB
     * @param entity get entity to insert it to DB
     */
    @Override
    public void add(Device entity) {
        Connection connection = getConnection();
        String sql = "INSERT INTO `device` (id, client, brand, model, imei) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setInt(2, entity.getClient());
            preparedStatement.setString(3, entity.getBrand());
            preparedStatement.setString(4, entity.getModel());
            preparedStatement.setString(5, entity.getImei());
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
    public void update(Device entity) {
        String sql = "UPDATE `device` SET id=?, client=?, brand=?, model=?, imei=? WHERE id=?";
        Connection connection =getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setInt(2, entity.getClient());
            preparedStatement.setString(3, entity.getBrand());
            preparedStatement.setString(4, entity.getModel());
            preparedStatement.setString(5, entity.getImei());
            preparedStatement.setInt(6, entity.getId());
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
    public void delete(Device entity) {
        Connection connection = getConnection();
        String sql = "DELETE FROM `device` WHERE id=?";
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

    /**
     * @param id parameter for find entity
     * @return entity
     */
    @Override
    public Device getEntityByKey(Integer id) {
        Connection connection = getConnection();
        String sql = "SELECT id, client, brand, model, imei FROM `device` WHERE id = ?";
        Device device = new Device();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            device.setId(resultSet.getInt("id"));
            device.setClient(resultSet.getInt("client"));
            device.setBrand(resultSet.getString("brand"));
            device.setModel(resultSet.getString("model"));
            device.setImei(resultSet.getString("imei"));
            LOG.debug("Executed query "+sql);
        } catch (SQLException e) {
            try {
                if (!resultSet.next()) {
                    return null;
                }
            } catch (SQLException ex) {
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
        return device;
    }

    /**
     * @param brand parameter for find entity
     * @return list entity
     */
    @Override
    public List<Device> getDeviceByBrand(String brand) {
        List<Device> deviceList = new ArrayList<>();
        Connection connection = getConnection();
        String sql = "SELECT id, client, brand, model, imei FROM `device` WHERE brand LIKE ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, brand);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Device device = new Device();
                device.setId(resultSet.getInt("id"));
                device.setClient(resultSet.getInt("client"));
                device.setBrand(resultSet.getString("brand"));
                device.setModel(resultSet.getString("model"));
                device.setImei(resultSet.getString("imei"));
                deviceList.add(device);
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
        return deviceList;
    }

    /**
     * @param model parameter for find entity
     * @return list entity
     */
    @Override
    public List<Device> getDeviceByModel(String model) {
        Connection connection = getConnection();
        String sql = "SELECT id, client, brand, model, imei FROM `device` WHERE model LIKE ?";
        List<Device> deviceList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, model);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Device device = new Device();
                device.setId(resultSet.getInt("id"));
                device.setClient(resultSet.getInt("client"));
                device.setBrand(resultSet.getString("brand"));
                device.setModel(resultSet.getString("model"));
                device.setImei(resultSet.getString("imei"));
                deviceList.add(device);
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
        return deviceList;
    }

    /**
     * @param imei parameter for find entity
     * @return entity
     */
    @Override
    public Device getDeviceByIMEI(String imei) {
        Connection connection = getConnection();
        String sql = "SELECT id, client, brand, model, imei FROM `device` WHERE imei LIKE ?";
        Device device = new Device();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, imei);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            device.setId(resultSet.getInt("id"));
            device.setClient(resultSet.getInt("client"));
            device.setBrand(resultSet.getString("brand"));
            device.setModel(resultSet.getString("model"));
            device.setImei(resultSet.getString("imei"));
            LOG.debug("Executed query "+sql);
        } catch (SQLException e) {
            try {
                if(!resultSet.next()){
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
        return device;
    }

    /**
     * @param client parameter for find entity
     * @return list entity
     */
    @Override
    public List<Device> getDeviceByClient(Integer client) {
        Connection connection = getConnection();
        String sql = "SELECT id, client, brand, model, imei FROM `device` WHERE client = ?";
        List<Device> deviceList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, client);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Device device = new Device();
                device.setId(resultSet.getInt("id"));
                device.setClient(resultSet.getInt("client"));
                device.setBrand(resultSet.getString("brand"));
                device.setModel(resultSet.getString("model"));
                device.setImei(resultSet.getString("imei"));
                deviceList.add(device);
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
        return deviceList;
    }
}

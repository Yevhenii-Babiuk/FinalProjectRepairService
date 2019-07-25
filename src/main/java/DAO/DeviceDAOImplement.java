package DAO;

import Model.Device;
import Util.MySQLConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeviceDAOImplement extends MySQLConnector implements DAODevice {

    private Device setDeviceFromDb(ResultSet resultSet) {
         Device device = new Device();
        try {
            device.setId(resultSet.getInt("id"));
            device.setClient(resultSet.getInt("client"));
            device.setBrand(resultSet.getString("brand"));
            device.setModel(resultSet.getString("model"));
            device.setImei(resultSet.getString("imei"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return device;
    }

    private Device getDeviceFromDb(String sql, String parametr) {
        Device device = new Device();
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        try {
            preparedStatement.setString(1, parametr);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            device = setDeviceFromDb(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return device;
    }

    private Device getDeviceFromDb(String sql, Integer parametr) {
        Device device = new Device();
        PreparedStatement preparedStatement = getPrepareStatement(sql);
        try {
            preparedStatement.setInt(1, parametr);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            device = setDeviceFromDb(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return device;
    }

    private void setDeviceToDb(PreparedStatement preparedStatement, Device entity)  {
        try {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setInt(2, entity.getClient());
            preparedStatement.setString(3, entity.getBrand());
            preparedStatement.setString(4, entity.getModel());
            preparedStatement.setString(5, entity.getImei());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Device> getAll() {
        List<Device> deviceList = new ArrayList<>();
        String sql = "SELECT id, client, brand, model, imei FROM `device`";
        Statement statement = getStatament();
        try {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Device device = setDeviceFromDb(resultSet);
                deviceList.add(device);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
        return deviceList;
    }

    @Override
    public void add(Device entity) {
        String sql = "INSERT INTO `device` (id, client, brand, model, imei) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = getPrepareStatement(sql);
        try {
            setDeviceToDb(preparedStatement, entity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }

    }

    @Override
    public void update(Device entity) {
        String sql = "UPDATE `device` SET id=?, client=?, brand=?, model=?, imei=? WHERE id=?";

        PreparedStatement preparedStatement = getPrepareStatement(sql);

        try {
            setDeviceToDb(preparedStatement, entity);
            preparedStatement.setInt(6, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public void delete(Device entity) {
        String sql = "DELETE FROM `device` WHERE ID=?";
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
    public Device getEntityByKey(Integer id) {
        String sql = "SELECT id, client, brand, model, imei FROM `device` WHERE id = ?";
        return getDeviceFromDb(sql, id);
    }

    @Override
    public Device getDeviceByBrand(String brand) {
        String sql = "SELECT id, client, brand, model, imei FROM `device` WHERE surname LIKE ?";
        return getDeviceFromDb(sql, brand);
    }

    @Override
    public Device getDeviceByModel(String model) {
        String sql = "SELECT id, client, brand, model, imei FROM `device` WHERE surname LIKE ?";
        return getDeviceFromDb(sql, model);
    }

    @Override
    public Device getDeviceByIMEI(String imei) {
        String sql = "SELECT id, client, brand, model, imei FROM `device` WHERE surname LIKE ?";
        return getDeviceFromDb(sql, imei);
    }

    @Override
    public Device getDeviceByClient(Integer client) {
        String sql = "SELECT id, client, brand, model, imei FROM `device` WHERE client = ?";
        return getDeviceFromDb(sql, client);
    }
}

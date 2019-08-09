package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class MySQLConnector {
    private Connection connection = getConnection();
    private static final String dbFileProperties = "src/main/resources/db.properties";
    private static Properties properties = new Properties();

    static {

        try {
            properties.load(new FileInputStream(dbFileProperties));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDriver() {
        return properties.getProperty("driver");
    }

    public String getUrl() {
        return properties.getProperty("url");
    }

    public String getUser() {
        return properties.getProperty("user");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }


    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(getDriver());
            connection = DriverManager.getConnection(
                    getUrl(),
                    getUser(),
                    getPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
        }
    }

    public void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch (Exception e) {
        }
    }
}

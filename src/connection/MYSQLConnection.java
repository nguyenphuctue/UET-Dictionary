package connection;

import java.io.*;
import java.sql.*;
import java.util.*;

public class MYSQLConnection {
    private static final String FILE_CONFIG = "\\db.properties";

    /**
     * Method Connection.
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        Properties properties = new Properties();
        InputStream inputStream = null;

        try {
            String currentDir = System.getProperty("user.dir");
            inputStream = new FileInputStream(currentDir + FILE_CONFIG);

            properties.load(inputStream);

            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            connection = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return connection;
    }
}

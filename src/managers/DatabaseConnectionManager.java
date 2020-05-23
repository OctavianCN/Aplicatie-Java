package managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    public Connection createConnection() {
        try {
            String dataBaseName = "paoproject";
            String url = "jdbc:mysql://localhost:3306/paoproject";
            String username = "root";
            String password = "";

            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static DatabaseConnectionManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private final static class SingletonHolder {
        private static final DatabaseConnectionManager INSTANCE =
                new DatabaseConnectionManager();
    }
}

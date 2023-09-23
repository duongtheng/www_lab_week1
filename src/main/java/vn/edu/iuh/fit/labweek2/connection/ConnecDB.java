package vn.edu.iuh.fit.labweek2.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnecDB {
    private Connection connection;
    private static ConnecDB instance = null;

    public ConnecDB() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        String url = "jdbc:mariadb://localhost:3306/mydb?createDatabaseIfNotExist=true";
        connection = DriverManager.getConnection(url, "root", "sapassword");
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnecDB getInstance() throws SQLException, ClassNotFoundException {
        if(instance==null)
            instance = new ConnecDB();
        return instance;
    }
}

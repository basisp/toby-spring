package springbook111;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    public Connection connect() throws ClassNotFoundException, SQLException {

        //db 연결
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/springbook", "root", "1234");

        return c;
    }
}

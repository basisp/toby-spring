package springbook111.dao;

import springbook111.domain.User;

import java.sql.*;

public class UserDao{
    public void add(User user) throws ClassNotFoundException, SQLException{

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/springbook", "root", "1234");

        PreparedStatement ps =c.prepareStatement(
                "insert into users(id, name, password) values (?,?,?)"
        );

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException{

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/springbook", "root", "1234");

        PreparedStatement ps =c.prepareStatement(
                "select * from users where id=?"
        );
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("name"));
        user.setName(rs.getString("id"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }
}

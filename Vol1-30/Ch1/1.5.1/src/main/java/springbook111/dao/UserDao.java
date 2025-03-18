package springbook111.dao;

import springbook111.Closer;
import springbook111.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao{

    private final ConnectionMaker connectionMaker;
    private final Closer closer;

    public UserDao(ConnectionMaker connectionMaker){
        closer = new Closer();
        this.connectionMaker= connectionMaker;
    }
    public void add(User user) throws ClassNotFoundException, SQLException{

        Connection c= connectionMaker.makeConnection();

        PreparedStatement ps =c.prepareStatement(
                "insert into users(id, name, password) values (?,?,?)"
        );

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        closer.close(ps,c);

    }

    public User get(String id) throws ClassNotFoundException, SQLException{

        Connection c= connectionMaker.makeConnection();

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
        closer.close(ps,c);


        return user;
    }
}

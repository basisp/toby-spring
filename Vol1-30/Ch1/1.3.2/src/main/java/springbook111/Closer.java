package springbook111;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

final public class Closer {

    static public void close(PreparedStatement ps, Connection c) throws SQLException {
        ps.close();
        c.close();
    }
}

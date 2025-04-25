package springbook111.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionCounter implements ConnectionMaker{
    ConnectionMaker realConnectionMaker;
    public int counter = 0;

    public ConnectionCounter(ConnectionMaker connectionMaker) {
        this.realConnectionMaker = connectionMaker;
    }

    @Override
    public Connection makeConnection() throws SQLException, ClassNotFoundException {
        counter++;
        //DCounterConnectioinMaker의 makeConnection() 메서드 호출
        return realConnectionMaker.makeConnection();
    }

    public int getCounter() {
        return counter;
    }
}

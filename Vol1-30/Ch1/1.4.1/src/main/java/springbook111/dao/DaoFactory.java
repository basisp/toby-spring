package springbook111.dao;

public class DaoFactory {
    public UserDao userDao(){
        return connectionMake();
    }

    public AccountDao accountDao(){
        return connectionMake();
    }

    public MessageDao messageDao(){
        return connectionMake();
    }

    public UserDao connectionMake(){
        ConnectionMaker c = new DConnectionMaker();

        return new UserDao(c);
    }
}

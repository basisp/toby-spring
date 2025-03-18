package springbook111.dao;

public class DaoFactory {
    public UserDao userDao(){
        return new UserDao(new DaoFactory().connectionMake())
    }

    public AccountDao accountDao(){
        return new AccountDao(connectionMake());
    }

    public MessageDao messageDao(){
        return connectionMake();
    }

    public ConnectionMaker connectionMake(){
        return new DConnectionMaker();
    }
}

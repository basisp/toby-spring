package springbook111.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbook111.dao.AccountDao;
import springbook111.dao.DConnectionMaker;
import springbook111.dao.MessageDao;
import springbook111.dao.UserDao;
import springbook111.dao.ConnectionMaker;

@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }


}

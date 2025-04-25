package springbook111.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbook111.dao.ConnectionCounter;
import springbook111.dao.ConnectionMaker;
import springbook111.dao.DConnectionMaker;
import springbook111.dao.UserDao;

@Configuration
public class CountingDaoFactory {

    @Bean
    public UserDao userDao(){
        return new UserDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker(){
        return new ConnectionCounter(new DConnectionMaker());
    }

}

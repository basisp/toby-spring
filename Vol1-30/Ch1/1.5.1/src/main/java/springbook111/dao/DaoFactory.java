package springbook111.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao(){
        return new UserDao(new DaoFactory().connectionMake());
    }

    @Bean
    public ConnectionMaker connectionMake(){
        return new DConnectionMaker();
    }
}

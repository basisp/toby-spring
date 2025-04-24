package springbook111;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springbook111.dao.DConnectionMaker;
import springbook111.dao.UserDao;
import springbook111.domain.User;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SpringApplication.run(Application.class, args);

        DConnectionMaker dConnectionMaker = new DConnectionMaker();
        UserDao dao = new UserDao(dConnectionMaker);

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");

    }

}

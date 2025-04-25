package springbook111;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook111.dao.ConnectionCounter;
import springbook111.dao.UserDao;
import springbook111.domain.User;
import springbook111.factory.CountingDaoFactory;
import springbook111.factory.DaoFactory;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");


        ApplicationContext context =
                new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);
        dao.add(user);
        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");

        System.out.println("Connection count: " + context.getBean(("connectionMaker"), ConnectionCounter.class).getCounter());
    }
}

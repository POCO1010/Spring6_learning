package Spring6.test;

import Spring6.autowired.controller.UserController;
import Spring6.bean.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User bean = context.getBean(User.class);
        System.out.println(bean);
    }


    private Logger logger = LoggerFactory.getLogger(TestUser.class);

    @Test
    public void testAnnotation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
        UserController userController = context.getBean("userController", UserController.class);
        userController.out();
        logger.info("执行成功");
    }
}
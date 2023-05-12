package Spring6.test;


import Spring6.bean.User;
import Spring6.resource.controller.UserController;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class  TestUser_resource {
    private Logger logger = LoggerFactory.getLogger(TestUser_resource.class);

    @Test
    public void testAnnotation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
        UserController userController = context.getBean("myUserController", UserController.class);
        userController.out();
        logger.info("执行成功");
    }
}
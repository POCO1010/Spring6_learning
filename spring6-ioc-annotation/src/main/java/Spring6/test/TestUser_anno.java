package Spring6.test;


import Spring6.config.SpringConfig;
import Spring6.resource.controller.UserController;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser_anno {
    private Logger logger = LoggerFactory.getLogger(TestUser_anno.class);

    @Test
    public void testAnnotation() {
        //加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController userController = context.getBean("myUserController", UserController.class);
        userController.out();
        logger.info("执行成功");
    }
}
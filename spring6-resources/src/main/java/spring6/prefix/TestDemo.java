package spring6.prefix;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import spring6.di.User;

public class TestDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bean*.xml");
//        Resource resource = context.getResource("test.txt");
//        System.out.println(resource.getFilename());
        User user = context.getBean(User.class);
        System.out.println(user);
    }
}

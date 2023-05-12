package ioc;

import ioc.bean.AnnotationApplicationContext;
import ioc.bean.ApplicationContext;
import ioc.service.UserService;

public class testUserIoc {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationApplicationContext("ioc");
        UserService userService = (UserService)context.getBean(UserService.class);
        System.out.println(userService);
        userService.out();
    }
}


package spring6.validation.three;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyService service = context.getBean(MyService.class);
        User user = new User();
        user.setName("jack");
        user.setAge(10);
        user.setPhone("18227276626");
        user.setMessage("121");
        //TODO 这里还是会报错
        service.testMethod(user);

    }
}

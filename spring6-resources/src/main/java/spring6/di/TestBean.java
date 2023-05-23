package spring6.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean{
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        ResourceBean resourceBean = context.getBean(ResourceBean.class);
        resourceBean.parse();
    }
}
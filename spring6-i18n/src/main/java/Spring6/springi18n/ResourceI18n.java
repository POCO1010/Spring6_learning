package Spring6.springi18n;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceI18n {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        Object[] objs = new Object[]{"test",new Date().toString()};
        String value = context.getMessage("test", objs, Locale.CHINA);
        System.out.println(value);
    }
}

package Spring6;

import Spring6.bean.Clazz;
import Spring6.bean.Student;
import Spring6.bean.Teacher;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;


public class TestUser {
    @Test
    public void testUserObject(){
        //加载Spring配置文件，对象创建
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");

        //获取创建对象
        User user = (User) context.getBean("user");
        System.out.println(user);

        //使用对象调用方法进行测试
        user.add();
    }

    @Test
    public void testUserObject1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //获取类Class对象   TODO Class<?>不懂
        Class<?> aClass = Class.forName("Spring6.User");
        //调用方法创建对象
        //Object o = class.newInstance()
        User user = (User) aClass.getDeclaredConstructor().newInstance();
        System.out.println(user);
        user.add();
    }


    // ClassPathXmlApplicationContext Context🌟

    private final Logger logger = LoggerFactory.getLogger(User.class);
    @Test
    // 使用日志
    public void testUserObject2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User) ac.getBean("user");
        user.add();
        logger.info("执行成功");
    }

    @Test
    // 使用日志
    public void testUserObject3(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        User user = ac.getBean("user", User.class);
        User user1 = ac.getBean(User.class);
        user.add();
        user1.add();
        logger.info("执行成功");
    }

    @Test
    public void testDIBySet(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-di.xml");
        Student studentOne = ac.getBean("studentOne", Student.class);
        System.out.println(studentOne);
    }

    @Test
    public void testDIByConstructor(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-di.xml");
        Student studentOne = ac.getBean("studentTwo", Student.class);
        System.out.println(studentOne);
    }

    @Test
    public void ref(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-di.xml");
        Student studentOne = ac.getBean("studentFour", Student.class);
        System.out.println(studentOne);
        System.out.println(studentOne.getClazz().getClazzName());
        //Student{id=1004, name='赵六', age=26, sex='女'}
        //财源滚滚班
        //通过ref给类中类赋值
    }

    @Test
    public void insideBean(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-di.xml");
        Student studentOne = ac.getBean("studentFour2", Student.class);
        System.out.println(studentOne);
        System.out.println(studentOne.getClazz().getClazzName());
        //Student{id=1004, name='赵六', age=26, sex='女'}
        //远大前程班
        //在一个bean中再声明一个bean就是内部bean
    }

    @Test
    public void arrayBean(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-di.xml");
        Student studentOne = ac.getBean("studentFour4", Student.class);
        System.out.println(studentOne);
        System.out.println(Arrays.toString(studentOne.getHobbies()));
        // 迭代器输出数组
        Iterator<String> iterator = Arrays.stream(studentOne.getHobbies()).iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //Student{id=1004, name='赵六', age=26, sex='女'}
        //[Ljava.lang.String;@54afd745
        //抽烟
        //喝酒
        //烫头
    }

    @Test
    public void listBean(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-di.xml");
        Clazz clazzTwo = ac.getBean("clazzTwo", Clazz.class);
        // 高级for循环
        for (Student student : clazzTwo.getStudents()) {
            System.out.println(student);
        }
        System.out.println(clazzTwo);
        //Student{id=1001, name='张三', age=23, sex='男'}
        //Student{id=1002, name='李四', age=33, sex='女'}
        //Student{id=1004, name='赵六', age=26, sex='女'}
        //Clazz{clazzId=4444, clazzName='Javaee0222'}
    }

    //map方法
    @Test
    public void mapBean(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-di.xml");
        Student studentFour = ac.getBean("studentFour5", Student.class);
        map_sout(studentFour);
    }

    private void map_sout(Student studentFour) {
        Iterator<Map.Entry<String, Teacher>> iterator = studentFour.getTeacherMap().entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Teacher> next = iterator.next();
            System.out.println(next.getKey()+"-------->"+next.getValue());
        }
    }


    //map方法 util
    @Test
    public void map_utilBean(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-di.xml");
        Student studentFour6 = ac.getBean("studentFour6", Student.class);
        map_sout(studentFour6);
    }

    //list方法 util
    @Test
    public void list_utilBean(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-di.xml");
        Clazz clazzTwo = ac.getBean("clazzTwo2", Clazz.class);
        // 高级for循环
        for (Student student : clazzTwo.getStudents()) {
            System.out.println(student);
        }
        System.out.println(clazzTwo);
    }

    @Test
    public void p_Bean(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-di.xml");
        Student studentFour6 = ac.getBean("studentSix", Student.class);
        map_sout(studentFour6);
    }


    @Test
    public void testDataSource() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-datasource.xml");
        DataSource dataSource = ac.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testBeanScope(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-scope.xml");
        User user1 = ac.getBean(User.class);
        User user2 = ac.getBean(User.class);
        System.out.println(user1==user2);
    }
    // 设置为prototype会创建多个实例


    // TODO 主动销毁实例？
    @Test
    public void testLife() throws Exception {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User bean = ac.getBean(User.class);
        System.out.println("生命周期：4、通过IOC容器获取bean并使用");
        ac.close();
        ac.registerShutdownHook();
        System.out.println(bean.getUsername());
    }

}

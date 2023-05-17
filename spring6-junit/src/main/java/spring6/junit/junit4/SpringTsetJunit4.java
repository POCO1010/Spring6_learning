package spring6.junit.junit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring6.junit.junit5.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class SpringTsetJunit4 {
    //注入
    @Autowired
    private User user;

    @Test
    public void testUser(){
        System.out.println(user);
        user.run();
    }
}

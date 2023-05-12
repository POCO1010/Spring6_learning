package Spring6.resource.controller;

import Spring6.resource.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("myUserController")
public class UserController  {

    @Resource(name = "myUserService")
    private UserService userService;

    public void out() {
        userService.out();
        System.out.println("@Resource Controller层执行结束。");
    }

}

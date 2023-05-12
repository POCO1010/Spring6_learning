package Spring6.resource.service;

import Spring6.resource.dao.UserDao;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("myUserService")
public class UserServiceImp implements UserService {


    @Resource
    private UserDao myUserDao;

    @Override
    public void out() {
        myUserDao.print();
        System.out.println("@Resource Service层执行结束");
    }
}

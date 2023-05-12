package Spring6.autowired.service;

import Spring6.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{


//    @Autowired
//    private UserDao userDao;

    private UserDao userDao;
    @Autowired
    private void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }


    @Override
    public void out() {
        userDao.print();
        System.out.println("Service层执行结束");
    }
}

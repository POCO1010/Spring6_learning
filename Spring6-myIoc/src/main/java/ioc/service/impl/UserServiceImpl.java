package ioc.service.impl;

import ioc.anno.Bean;
import ioc.anno.Di;
import ioc.dao.UserDao;
import ioc.service.UserService;

@Bean
public class UserServiceImpl implements UserService {

    @Di
    private UserDao userDao;

    @Override
    public void out() {
        System.out.println("Service层执行结束");
        userDao.print();
    }
}

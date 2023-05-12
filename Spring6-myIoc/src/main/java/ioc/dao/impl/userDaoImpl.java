package ioc.dao.impl;

import ioc.anno.Bean;
import ioc.dao.UserDao;

@Bean
public class userDaoImpl implements UserDao {
    @Override
    public void print() {
        System.out.println("Dao层执行结束");
    }
}

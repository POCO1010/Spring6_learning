package Spring6.autowired.dao;

import Spring6.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao{

    private UserService userService;

    @Autowired
    private void setUserService(UserService userService){
        this.userService = userService;
    }
    @Override
    public void print() {
        System.out.println("Dao层执行结束");
    }
}

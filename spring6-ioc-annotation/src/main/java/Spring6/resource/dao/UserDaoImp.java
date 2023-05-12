package Spring6.resource.dao;

import Spring6.resource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("myUserDao")
public class UserDaoImp implements UserDao {

    private UserService userService;

    @Autowired
    private void setUserService(UserService userService){
        this.userService = userService;
    }
    @Override
    public void print() {
        System.out.println("@Resource Dao层执行结束");
    }
}

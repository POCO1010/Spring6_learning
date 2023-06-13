package spring6.validation.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;

@Service
public class MyValidation2 {
    @Autowired
    public Validator validator;

    public boolean validatorByUserTwo(User user){

        BindException bindException = new BindException(user,user.getName());
        validator.validate(user,bindException);
        System.out.println(bindException.getAllErrors());
        return bindException.hasErrors();
    }
}

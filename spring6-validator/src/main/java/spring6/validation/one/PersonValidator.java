package spring6.validation.one;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //name不能为空
        ValidationUtils.rejectIfEmpty(
                errors,"name","name.empty","name is null");
        //age不能小于0 不能大于200
        Person person = (Person) target;
        if (person.getAge() < 0){
            errors.rejectValue("age","age.value.error","age < 0");
        }else if(person.getAge() > 200){
            errors.rejectValue("age","age.value.error.old","age > 200");
        }
    }
}

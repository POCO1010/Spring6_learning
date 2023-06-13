package spring6.validation.two;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan("spring6.validation.two")
public class ValidationConfig {
    @Bean
    public LocalValidatorFactoryBean getValidator(){
        return new LocalValidatorFactoryBean();
    }
}

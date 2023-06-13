package spring6.validation.three;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
@ComponentScan("spring6.validation.three")
public class ValidationConfig {
    @Bean
    public MethodValidationPostProcessor getValidator(){
        return new MethodValidationPostProcessor();
    }
}

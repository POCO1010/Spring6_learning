package spring6.resourceloader;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

public class resourceLoaderDemo {
    @Test
    public void demo01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        Resource resource = context.getResource("test.txt");
        System.out.println(resource.getFilename());
    }

    @Test
    public void demo02(){
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext();
        Resource resource = context.getResource("test.txt");
        System.out.println(resource.getFilename());
    }

}

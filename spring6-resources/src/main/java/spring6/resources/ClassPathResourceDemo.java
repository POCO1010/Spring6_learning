package spring6.resources;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

// 访问类路径下资源
public class ClassPathResourceDemo {

    public static void main(String[] args) {
        loadClasspathResource("test.txt");
    }

    public static void loadClasspathResource(String path){
        //创建对象ClassPathResource
        ClassPathResource resource = new ClassPathResource(path);

        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());

        //获取文件内容
        try {
            InputStream inputStream = resource.getInputStream();
            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes) != -1 ){
                System.out.println(new String(bytes));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package spring6.resources;

import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;

public class UrlResourceDemo {

    public static void main(String[] args) {
        // http
        loadUrlResource("https://www.baidu.com");
        // file
        loadUrlResource("file:test.txt");


    }

    /**
     * 访问前缀http，file
     * @param path
     */
    public static void loadUrlResource(String path) {
        try {
            // 创建Resource实现类的对象 UrlResource
            UrlResource url = new UrlResource(path);
            // 获取资源信息
            System.out.println(url.getFilename());
            System.out.println(url.getURL());
            System.out.println(url.getDescription());
            System.out.println(url.getInputStream().read());
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}

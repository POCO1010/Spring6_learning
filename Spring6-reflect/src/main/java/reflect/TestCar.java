package reflect;

import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCar {
    // 获取class
     @Test
    public void test01() throws Exception {
         // 类名.class
         Class clazz01 = Car.class;
         // 对象.getClass()
         Class clazz02 = new Car().getClass();
         // class.forName("全路径")
         Class clazz03 = Class.forName("reflect.Car");

         //实例化
         Car car = (Car)clazz03.getDeclaredConstructor().newInstance();
         System.out.println(car);

     }

     //获取构造方法
    @Test
    public void test02() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Class clazz = Car.class;
        //获取所有构造方法
        Constructor[] constructors = clazz.getConstructors(); // getConstructors只能获取public方法 私有需添加declared
        for (Constructor c : constructors) {
            System.out.println("构造方法名称："+c.getName()+" 参数个数："+c.getParameterCount());
        }
        //指定有参数构造创建对象 public
        Constructor c1 = clazz.getConstructor(String.class, int.class, String.class);
        Car car1 = (Car) c1.newInstance("夏利", 10, "红色");
        System.out.println(car1);
        //指定有参数构造创建对象 private
        Constructor c2 = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        c2.setAccessible(true); // 允许访问私有构造方法
        Car car2 = (Car)c2.newInstance("捷达", 15, "白色");
        System.out.println(car2);
    }

    //获取属性
    @Test
    public void test03() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Car.class;
        Car car = (Car)clazz.getDeclaredConstructor().newInstance();
        //获取所有public属性
        Field[] fields = clazz.getFields();
        //获取所有属性（包含私有属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {

            if(field.getName().equals("name")){
                field.setAccessible(true);
                field.set(car,"五菱宏光");
            }

            System.out.println(field.getName());

        }
        System.out.println(car.toString());
    }

    //获取方法
    @Test
    public void test04() throws InvocationTargetException, IllegalAccessException {
        Car car = new Car("奔驰", 10, "黑色");
        Class clazz = car.getClass();
        // public方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().equals("toString")){
                //执行方法
                String invoke = (String) method.invoke(car);
                System.out.println("toString方法执行："+invoke);
            }
        }
        // private方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().equals("run")){
                declaredMethod.setAccessible(true);
                //执行方法
                declaredMethod.invoke(car);
            }
        }

    }
}

package Bit;

import javax.xml.crypto.Data;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.SimpleTimeZone;

/*
反射
 */
public class Demo6 {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("java.util.Date");
        Object o = clazz.newInstance();
        //获取所有的构造方法
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for(Constructor constructor : constructors){
            System.out.println(constructor);
        }
        Method[] method = clazz.getMethods();
        for(Method method1:method){
            System.out.println(method1);
        }






        /*//获取当前时间
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sd.format(date));
        //获取当前时间
        System.out.println(LocalDateTime.now());*/

    }
}

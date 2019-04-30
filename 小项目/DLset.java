package 小项目;

import java.util.HashSet;
import java.util.Scanner;

class Person{
    String name;
    String password;
    public Person(String name,String password){
        this.name = name;
        this.password = password;
    }
    public String toString() {
        return "{名字："+this.name+" 密码："+this.password+"}";
    }

    @Override
    public int hashCode() {
        return name.hashCode();//+password.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person)obj;
        return this.name.equals(person.name);//&&this.password.equals(person.password);
    }
}
public class DLset {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        HashSet set = new HashSet();
        while(true) {
            System.out.println("请输入用户名：");
            String name = in.next();
            System.out.println("请输入密码：");
            String password = in.next();
                Person person= new Person(name,password);
            if (set.add(person)) {
                System.out.println("登录成功");
                System.out.println("当前用户有：" + set);
            } else {
                System.out.println("注册失败");
            }
        }
    }
}

package 小项目;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
class User{
    int id;
    String password;
    public User(int id,String password){
        this.id = id;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User)obj;
        return this.id==user.id;
    }

    @Override
    public String toString() {
        return "{账号:"+this.id+" 密码:"+this.password+"}";
    }
}
public class DL {
    static Scanner in = new Scanner(System.in);
    static Collection users = new ArrayList();
    public static void main(String[] args) {
        while(true) {
            System.out.println("请选择 (A):登录  (B):注册");
            String option = in.next();
            if ("a".equalsIgnoreCase(option)) {
                DengLu();
            } else if ("b".equalsIgnoreCase(option)) {
                ZhuCe();
            } else {
                System.out.println("选择错误，请重新输入!");
            }
        }
    }
    private static void DengLu(){
        while(true) {
            System.out.println("请输入账号：");
            int id = in.nextInt();
            System.out.println("请输入密码：");
            String password = in.next();
            Iterator it = users.iterator();
            boolean isLogin = false;
            while (it.hasNext()) {
                User user = (User) it.next();
                if (user.id == id && user.password.equals(password)) {
                    isLogin = true;
                }
            }
            if(isLogin){
                System.out.println("登陆成功！");
                break;
            }else{
                System.out.println("账号或者密码错误，请重新登录！");
            }
        }
    }
    private static void ZhuCe(){
        User user;
        while(true) {
            System.out.println("请输入账号：");
            int id = in.nextInt();
            user = new User(id, null);
            if (users.contains(user)) {
                System.out.println("该账号已经被注册，请重新输入！");
            } else {
                break;
            }
        }
        System.out.println("请输入密码：");
        String password = in.next();
        user.setPassword(password);
        users.add(user);
        System.out.println("注册成功");
        System.out.println("已注册的用户："+users);
    }
}

package DesignMode;
/*
单例设计模式
 */
//饿汉式
class ESingleton{
    private static ESingleton singleton = new ESingleton();
    private ESingleton(){};
    public static ESingleton getSingleton(){
        return singleton;
    }
}
//完整的懒汉式

/*
new Singleton() 以上做了三件事
1-在堆上分配空间
2-属性初始化
3-引用指向对象

有可能出现 1-3-2;
在多线程中，singleton的引用已经不为null

1-在堆上分配空间
//线程1
3-引用指向对象(singleton已经不为null)  导致判断失效，使得属性值还未初始化，使得取出来的值null;

2-属性初始化


volatile作用：禁止指令重排，使得属性值一定是初始化好的。任何一个拿到对象，一定是初始化好的对象
synchronized作用：保证对象只有一个。
 */
class LSingleton{
    private static volatile LSingleton singleton;
    private String name;
    private LSingleton(){
        name = "Hello";
    }
    //如果不加volatile，以下这个值可能为空
    public String getName() {
        return name;
    }
    public static LSingleton getSingleton(){
        if(singleton==null){
            synchronized (singleton){
                if(singleton==null){
                    singleton = new LSingleton();
                }
            }
        }
        return singleton;
    }
}
public class Singleton {
    public static void main(String[] args) {

    }

}

package Bit;
/*
死锁的例子
同步的本质在于：一个线程等待另外一个线程执行完毕执行完成后才可以继续执行。但是现在相关的几个线程彼此之间都在相互等待着
那么就会造成死锁。
 */

class Pen implements Runnable{

    public void run() {
        synchronized ("笔"){
            System.out.println(Thread.currentThread().getName()+"目前有笔了，现在需要本子！");
            synchronized ("本子"){
                System.out.println(Thread.currentThread().getName()+"目前有本子了，现在需要笔！");
            }
        }

    }
}
class Book implements Runnable{
    public void run() {
        synchronized("本子"){
            System.out.println(Thread.currentThread().getName()+"目前有本子，现在需要笔！");
            synchronized("笔"){
                System.out.println(Thread.currentThread().getName()+"目前有笔，现在需要本子！");
            }
        }

    }
}
public class Demo9 {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Book book = new Book();
        Thread t1 = new Thread(pen,"小明");
        Thread t2 = new Thread(book,"小红");
        t1.start();
        t2.start();

    }
}

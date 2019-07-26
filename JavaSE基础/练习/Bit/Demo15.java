package Bit;
/*
编写一个程序，启动三个线程，三个线程的名称分别是A、B、C; 每个线程将自己的名称在屏幕上打印五遍，打印顺序是ABCABC、、、
 */

class  Printf{
    private int flag = 1;
    public synchronized void PrintfA(){
        if(flag==1) {
            System.out.print(Thread.currentThread().getName());
            flag=2;
            notifyAll();
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void PrintfB(){
        if(flag==2) {
            System.out.print(Thread.currentThread().getName());
            flag=3;
            notifyAll();
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void PrintfC(){
        if(flag==3) {
            System.out.print(Thread.currentThread().getName());
            flag=1;
            notifyAll();
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Demo15 {
    public static void main(String[] args) {
        Printf printf = new Printf();
        new Thread(()->{
            for(int i=0; i<5; i++) {
                if(Thread.currentThread().getName().equals("A")) {
                    printf.PrintfA();
                }
            }

        },"A").start();
        new Thread(()->{
            for(int i=0; i<5; i++) {
                if(Thread.currentThread().getName().equals("B")) {
                    printf.PrintfB();
                }
            }

        },"B").start();
        new Thread(()->{
            for(int i=0; i<5; i++) {
                if(Thread.currentThread().getName().equals("C")) {
                    printf.PrintfC();
                }
            }

        },"C").start();
    }
}

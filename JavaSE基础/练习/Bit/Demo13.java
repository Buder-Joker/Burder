package Bit;
/*
刘益铭版的生产者与消费者模型
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//商品
class Goodes{
    private String name;
    private int count;

    //消费者
    public synchronized void getGoodes() {
        while(count==0){
            try {
                System.out.println("商品买完了，客官等一下哈！");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName()+"消费"+toString());
        notifyAll();

    }

    //生产者
    public synchronized void setGoodes(String name) {
        this.name = name;
        while (count>5){
            try {
                System.out.println("有商品！");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println(Thread.currentThread().getName()+"生产"+toString());
        notifyAll();
    }

    @Override
    public String toString() {
        return "[商品:"+name+count+"个]";
    }
}

//生产者
class Producter1 implements Runnable{
    Goodes goodes;
    public Producter1(Goodes goodes){
        this.goodes = goodes;
    }
    @Override
    public void run() {
        while(true){
            goodes.setGoodes("香蕉");
        }
    }
}

//消费者

class Custemer1 implements Runnable{
    Goodes goodes;
    public Custemer1(Goodes goodes){
        this.goodes = goodes;
    }
    @Override
    public void run() {
        while(true){
            goodes.getGoodes();
        }
    }
}
public class Demo13 {

    public static void main(String[] args) {
        Goodes goodes = new Goodes();
        List<Thread> list = new ArrayList();
        Producter1 producter1 = new Producter1(goodes);
        Custemer1 custemer1 = new Custemer1(goodes);
        //五个生产者
        for(int i = 0; i<5; i++){
            Thread thread1 = new Thread(producter1);
            list.add(thread1);
        }
        //十个消费者
        for(int i=0; i<10; i++){
            Thread thread2 = new Thread(custemer1);
            list.add(thread2);
        }

        for(Thread thread : list){
            thread.start();
        }
    }
}

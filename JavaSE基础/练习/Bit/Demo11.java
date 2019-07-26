package Bit;
/*
生产者与消费者
生产者 生产物品  放到容器
消费者 消费物品  从容器拿

当容器中的物品容量超过指定的值 ， 生产者停止生产 等待通知
当容器中的物品容量为空 ， 消费者停止消费发出通知
 */

import jdk.internal.org.objectweb.asm.tree.FieldInsnNode;

import java.util.LinkedList;
import java.util.Queue;

class Goods{
    String name;
    int price;
    public Goods(String name,int price){
         this.name = name;
         this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Goods["+"name:"+this.name+"/"+this.price+"]";
    }
}
class Producer implements Runnable{
    private final Queue<Goods> goodsQueue;

    private final Integer maxGoods;

    Producer(Queue<Goods> goodsQueue,Integer maxGoods) {
        this.goodsQueue = goodsQueue;
        this.maxGoods = maxGoods;
    }
    public void run() {
        while(true){
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            synchronized (this.goodsQueue){
                if(goodsQueue.size()<maxGoods){
                    goodsQueue.add(new Goods("烧饼",5));
                    System.out.println(Thread.currentThread().getName()+"继续生产烧饼！");
                }else{
                    System.out.println("队列已满，等待消费！");
                    goodsQueue.notify();
                    try {
                        goodsQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
class Constemer implements Runnable{
    private final Queue<Goods> goodsQueue;

    public Constemer(Queue<Goods> goodsQueue) {
        this.goodsQueue = goodsQueue;
    }

    public void run() {
        while(true){
            /*try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            synchronized (this.goodsQueue){
                if(this.goodsQueue.isEmpty()){
                    System.out.println(Thread.currentThread().getName()+"队列已空，通知生产！");
                    goodsQueue.notify();
                    try {
                        goodsQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    goodsQueue.poll();
                    if(goodsQueue!=null){
                        System.out.println(Thread.currentThread().getName()+"买到了烧饼！");
                    }
                }

            }
        }
    }
}
public class Demo11 {
    public static void main(String[] args) {
        final Queue queue = new LinkedList();


        Producer producer = new Producer(queue,8);
        Constemer constemer = new Constemer(queue);
        /*Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(constemer);
        thread1.start();
        thread2.start();*/

        for(int i = 0; i<5; i++){
            new Thread(producer,"Thread-producer"+i).start();
        }
        for(int i = 0; i<10; i++){
            new Thread(constemer,"Thread-constemer"+i).start();
        }
    }
}

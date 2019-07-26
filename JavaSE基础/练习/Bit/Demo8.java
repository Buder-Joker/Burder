package Bit;
/*
生产者与消费者
 */

class Prodct{
    String name;
    int price;
    boolean flag = false;
}
 class Prodcter extends Thread{
     Prodct p;
    public Prodcter(Prodct p){
       this.p = p;
    }
    public void run() {
        int i = 0;
         while(true){
             synchronized (p){
                 if(p.flag==false){
                     if (i % 2 == 0) {
                         p.name = "香蕉";
                         try {
                             Thread.sleep(10);
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                         p.price = 6;
                     } else {
                         p.name = "苹果";
                         p.price = 9;
                     }
                     System.out.println("果农生产出" + p.name + ",它的价格为：" + p.price + "元");
                     p.flag = true;
                     i++;
                     p.notify();//唤醒消费者去消费
                 }else{
                     try {
                         p.wait();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             }
         }

    }
 }
 class Custemer extends Thread{
    Prodct p;
    public Custemer(Prodct p){
        this.p = p;
    }
     public void run() {
         while(true){
             synchronized (p) {
                 if(p.flag) {
                     System.out.println("商人购买了" + p.name + ",价格为：" + p.price + "元");
                     p.flag=false;
                     p.notify();//唤醒生产者去生产
                 }else{
                     try {
                         p.wait();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             }
         }
     }
 }
public class Demo8 {
    public static void main(String[] args) {
        Prodct prodct = new Prodct();
        Prodcter prodcter = new Prodcter(prodct);
        Custemer custemer = new Custemer(prodct);
        prodcter.start();
        custemer.start();
    }
}

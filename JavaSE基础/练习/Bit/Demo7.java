package Bit;
/*
卖票
 */
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class MyThread extends Thread{
    private static int ticket = 10;
    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        synchronized ("su") {
            while (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "剩余票数为:" + this.ticket-- + "张");
                if (ticket == 5) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class RunableThread implements Runnable{
    private int ticket = 20;
    @Override
    public void run() {

        while(ticket>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                synchronized (this) {
                    if (ticket > 0) {
                        System.out.println(Thread.currentThread().getName() + "剩余" + (--ticket) + "张票");
                    }
                    if (this.ticket == 0) {
                        System.out.println("卖完了");
                    }
                }
            }

        /*while(ticket>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"剩余票数为:"+this.ticket--+"张");
        }*/
    }
}

class MytickCallable implements Callable{
    private static int ticket = 10;
    @Override
    public String call() throws Exception{
        while(ticket>0){
            System.out.println(Thread.currentThread().getName()+"剩余票数为:"+this.ticket--+"张");
            if(ticket==5){
                Thread.sleep(1000);
            }
        }
        return "票买完了";
    }


}
public class Demo7 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*new MyThread("A").start();
        new MyThread("B").start();
        new MyThread("C").start();*/

        System.out.println(Thread.currentThread().getName()+"开始");
        RunableThread runableThread = new RunableThread();
        Thread thread1 = new Thread(runableThread,"A窗口");
        Thread thread2 = new Thread(runableThread,"B窗口");
        Thread thread3= new Thread(runableThread,"C窗口");
        thread1.start();
        thread2.start();
        thread3.start();

        //new Thread(r).start();
        //new Thread(r).start();

        System.out.println(Thread.currentThread().getName()+"结束");

       /* MytickCallable mytickCallable = new MytickCallable();
        Future future = new FutureTask(mytickCallable);
        Thread thread = new Thread((Runnable) future);
        thread.start();
        System.out.println(future.get());*/

    }
}

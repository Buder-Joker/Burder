package Bit;
/*
线程池的使用：
 */

import javafx.scene.control.TableRow;

import java.util.concurrent.*;

//class MyThread1 implements Runnable
class MyThread1 implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i<10; i++){
            System.out.println(Thread.currentThread().getName()+"-"+i);
        }
        //return Thread.currentThread().getName()+"执行完毕！";
    }
}
public class Demo12 {
    public static void main(String[] args) throws Exception {
        MyThread1 myThread1 = new MyThread1();
        //手工创建线程池
        /*ExecutorService executorService = new ThreadPoolExecutor(3,5,
                2000,TimeUnit.MICROSECONDS,new LinkedBlockingDeque<>());*/

        //使用单线程池
        //ExecutorService executorService = Executors.newSingleThreadExecutor();

        //使用固定大小线程池
        //ExecutorService executorService = Executors.newFixedThreadPool(3);

        //使用缓冲线程池
        //ExecutorService executorService = Executors.newCachedThreadPool();

        //定时调度池
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        for(int i=0; i<5; i++){
            //延迟3秒后执行
            //scheduledExecutorService.schedule(myThread1,3000,TimeUnit.MICROSECONDS);
            //延迟三秒后，每隔一秒后执行
            scheduledExecutorService.scheduleAtFixedRate(myThread1,3000,1000,TimeUnit.MICROSECONDS);
            //Thread.sleep(1);
            //executorService.submit(myThread1);
            //Future future = executorService.submit(myThread1);
            //System.out.println(future.get());
            //executorService.submit(myThread1);
        }

        //关闭线程池
        //executorService.shutdown();
    }


}


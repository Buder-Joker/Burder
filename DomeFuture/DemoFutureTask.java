package Bit;
/*
1 . 洗水壶(2)
2 . 烧开水(10)

3 . 洗茶壶(2)
4 . 洗茶杯(1)
5 . 拿茶叶(3)
线程一做前俩件事，线程二做后面俩件
 */

import java.sql.Time;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
//线程一
class Water implements Callable {
    FutureTask futureTask ;
    public Water(FutureTask futureTask){
        this.futureTask = futureTask;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("T1:洗水壶..");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("T1:烧开水..");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("等待茶叶..");
        //此时必须等到线程二执行完毕后才继续向下运行
        String str= (String) futureTask.get();
        System.out.println("T1:拿到茶叶..");
        System.out.println("T1:开始泡茶..");
        return "客官茶来咯..";
    }
}
//线程二
class Tea implements Callable{
    @Override
    public Object call() throws Exception {
        System.out.println("T2:洗茶壶..");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("T2:洗茶杯..");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("T2:拿茶叶..");
        TimeUnit.SECONDS.sleep(2);
        return "茶叶已备好！";
    }
}
public class DemoFutureTask {
    public static void main(String[] args) {
        FutureTask futureTea = new FutureTask(new Tea());
        FutureTask futureWater = new FutureTask(new Water(futureTea));
        Thread thread1 = new Thread(futureTea);
        Thread thread2 = new Thread(futureWater);
        thread1.start();
        thread2.start();
        try {
            System.out.println(futureWater.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}



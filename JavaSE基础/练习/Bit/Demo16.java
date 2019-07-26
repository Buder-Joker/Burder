package Bit;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
异步实现 1~100的和   以及1~200的和
 */
class MyThreadSum implements Callable<Integer>{
    private int n;
    private int sum = 0;
    public MyThreadSum(int n){
        this.n = n;
    }
    public Integer call() {
        for(int i=1; i<=n; i++){
            sum+=i;
        }
        return sum;
    }
}
public class Demo16 {
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = es.submit(new MyThreadSum(100));
        Future<Integer> future2 = es.submit(new MyThreadSum(200));
        int a = future1.get();
        int b = future2.get();
        System.out.println(a);
        System.out.println(b);
    }
}

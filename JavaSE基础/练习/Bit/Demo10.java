package Bit;
/*
从运行结果可以看出，对于ThreadLocal类型的变量，在一线程中设置值，不影响其在其他线程中的值。也就是说ThreadLocal类型的
变量的值在每一个线程中是独立的。
 */
public class Demo10 {
    private static String commStr;
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {
        commStr = "main";
        threadLocal.set("main");
        Thread thread = new Thread(new Runnable() {
            public void run() {
                commStr = "thread";
                threadLocal.set("thread");
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(commStr);
        System.out.println(threadLocal.get());
    }
}

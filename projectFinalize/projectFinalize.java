package project;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import sun.misc.GC;

/*
对象的自我拯救-finalize
 */
public class projectFinalize {
    private static projectFinalize pf;

    public void isAlive(){
        if(pf!=null){
            System.out.println("我还活着、、");
        }
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("执行finalize方法！");
        pf = this;
    }

    public static void main(String[] args) {
        pf = new projectFinalize();
        pf = null;
        System.gc();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(pf!=null){
            pf.isAlive();
        }else{
            System.out.println("我已经挂了、、");
        }
        System.out.println("-------------");
        pf = null;
        System.gc();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(pf!=null){
            pf.isAlive();
        }else{
            System.out.println("我已经挂了、、");
        }
    }
}

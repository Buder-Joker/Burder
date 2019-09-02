package Bit;


/*
1 . 写俩个线程，一个线程打印1~52，另一个线程打印A~Z，打印的顺序是12A34B....51Y52Z;
 */

import javax.print.attribute.standard.PrinterName;

/*class Print{

    int count = 1;
    public synchronized void PrintNum(){
        while(count<=26) {

            System.out.print(2*count-1);
            System.out.print(2*count);
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void PrintChar() {
        while(true){
           // if(count!=1)
            System.out.print((char)('A'+count-1));
            count++;
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
*/

class PrintNum implements Runnable{
    int count = 1;

    @Override
    public void run() {
        synchronized ("锁"){
            while(true){
                System.out.print(2*count-1);
                System.out.print(2*count);
                count++;
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(count==27){
                    break;
                }
            }
        }
    }
}
class PrintChar implements Runnable{
    char str = 'A';

    @Override
    public void run() {
        synchronized ("锁") {
          while(true){
                System.out.print(str);
                str += 1;
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("Z".equals(str)) {
                    break;
                }
            }
        }
    }
}
public class Demo14 {
    public static void main(String[] args) {
        /*Print print = new Print();
        new Thread(() -> {
            print.PrintNum();
        }).start();

        new Thread(() ->{
            print.PrintChar();
        }).start();*/
        PrintNum printNum = new PrintNum();
        PrintChar printChar = new PrintChar();
        Thread thread1 = new Thread(printChar);
        Thread thread2 = new Thread(printNum);
        thread1.start();
        thread2.start();
    }


}

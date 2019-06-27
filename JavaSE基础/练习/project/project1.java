package project;
class Person extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("你可真棒！");
        }
    }
}
public class project1 {
    public static void main(String[] args) {
        Person p = new Person();
        p.start();
    }
}

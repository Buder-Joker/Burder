package NiuKeWang;
/*
最小公倍数
 */
import java.util.Scanner;

public class Demo11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c =a>b? a:b;
        int d = a<b? a:b;
        int temp = c;
        int i=1;
        if(c%d==0){
            System.out.println(c);
        }else{
            while(true){
                if(c%d==0){
                    System.out.println(c);
                    break;
                }else{
                    c=temp*i;
                    i++;
                }
            }
        }
    }

    //不需要判断谁大谁小
    public static void right(){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int temp =a;
        int i=1;
        while(true){
            if(a%b==0){
                System.out.println(a);
                break;
            }else{
                a=temp*i;
                i++;
            }
        }
    }
}

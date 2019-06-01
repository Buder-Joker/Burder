package 剑指Offer;

import java.util.Scanner;

/*
不使用加减乘除做加法
 */
public class offer65 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        while (in.hasNextInt()){
            int a = in.nextInt();
            int b = in.nextInt();
            int c=0,d=0;
            while(b!=0){
                //无进位直接异或,就为结果
                c = a^b;
                //有进位相与,左移一位
                d = (a&b)<<1;
                //重复此过程,直到二者相与为0
                a=c;
                b=d;
            }
            System.out.println(c);
        }
    }
}

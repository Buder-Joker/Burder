package NiuKeWang;
/*
只提供每袋6个和每袋8个，需要n个，需要的最小袋数
 */
import java.util.Scanner;

public class Demo6 {
    public static void Frist(int n) {
        int x = 6;
        int y = 8;
        int count = -1;
        int mincount = 9999;
        //10代表可能会有6和8 袋数存在的范围
        for(int i=0; i<=10; i++){
            int sum = x*i;
            for(int j=0; j<=10; j++){
                if(n==sum+j*y){
                    count=i+j;
                    mincount = mincount<count? mincount:count;
                }
                /*if(i+j==20){
                    System.out.println(-1);
                }*/
            }
        }
        System.out.print(mincount);
    }

    public static int Second(int n){
        if(n<6||n%2!=0||n==10){
            return -1;
        }
        if(n%8==0){
            return n/8;
        }
        return 1+n/8;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //Frist(n);
        System.out.println(Second(n));
    }
}

package NiuKeWang;
/*
n的阶乘，输出最后末尾0的个数，牛客测试案例通过70%;
 */
import java.util.Scanner;

public class Demo14 {
    public static void main(String[] age) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = 0;
        int count = 0;
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum = sum * i;
            //count = sum%1000;
            while(sum>0){
                if(sum%10==0){
                    t++;
                    sum=sum/10;
                }else {
                    sum = sum%10;
                    break;
                }
            }
        }
        System.out.println(t);
    }
}

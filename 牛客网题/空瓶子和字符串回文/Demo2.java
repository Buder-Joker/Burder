package NiuKeWang;

/*
1 0
2 1
3 1
4 2
5 2
6 2+1
7 2+1
8 2+2
9 3+1
10 3+2
三个空瓶子可以换一瓶饮料
十个空瓶子可以换多少
 */
import java.util.Scanner;
public class Demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        while(true){
           n = in.nextInt();
           if(n==0){
               break;
           }
           System.out.println(isDrink(n));
        }
    }
    private static int isDrink(int n) {
        int count = 0;
        int temp = 0;
        int temp1 = 0;
        while(n>1) {
            if(n==2){
                count = count+1;
                break;
            }
            temp = n / 3;
            temp1 = n % 3;
            count = count + temp;
            n = temp + temp1;
        }
        return count;
    }
}

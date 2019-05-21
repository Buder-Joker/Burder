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
        int[] arr = new int[]{3,5,6,10,81};
        int t = 5;
       /* while(true){
            arr[t++] = in.nextInt();
            if(arr[t]==0){
                break;
            }
        }
        System.out.println("t:"+t);*/
        for(int i=0; i<t; i++){
            int count = 0;
            int temp = 0;
            int temp1 = 0;
            while(arr[i]>1) {
                if(arr[i]==2){
                    count = count+1;
                    break;
                }
                temp = arr[i] / 3;
                temp1 = arr[i] % 3;
                count = count + temp;
                arr[i] = temp + temp1;
            }
            System.out.println(count);
        }
    }
}

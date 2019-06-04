package NiuKeWang;
/*
注释的是：
2 2 0 0 0 3 0 0 1 0
输出:1000000223

函数isMainShu()
输出:10015558
 */
import java.util.Arrays;
import java.util.Scanner;

public class Demo18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr  = new int[10];
        for(int i=0; i<arr.length; i++){
            arr[i]=in.nextInt();
        }
        isMinShu(arr);
        /*Arrays.sort(arr);
        int min = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>min){
                min = arr[i];
                break;
            }
        }
        System.out.print(min);

        int t = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==min){
                t=i;
                break;
            }
        }
        for(int i=0; i<arr.length; i++){
            if(i==t){
                continue;
            }
            System.out.print(arr[i]);
        }*/
    }
    //2 2 0 0 0 3 0 0 1 0
    public static void isMinShu(int[] arr){
        int min = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0&&i!=0){
                min = i;
                break;
            }
        }
        System.out.print(min);
        for(int i=0; i<arr.length; i++){
            if(i==min){
                for(int j=0; j<arr[i]-1; j++){
                    System.out.print(i);
                }
            }else{
                for(int j=0; j<arr[i]; j++){
                    System.out.print(i);
                }
            }
        }
    }
}

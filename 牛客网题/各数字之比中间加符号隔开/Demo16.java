package NiuKeWang;

import java.util.Arrays;
import java.util.Scanner;
/*
输入一个K位整数，统计各位不同的数字出现的个数
例如：100311
按照D:M的格式输出001113
比如0:2<br/>1:3<br/>3:1

 */
public class Demo16 {
    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            String str = in.next();
            int[] arr = new int[str.length()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            Arrays.sort(arr);
            printf(arr);
        }

    }

    private static void printf(int[] arr) {
        int[] brr = new int[10];
        int temp = 0;
        for(int i=0; i<arr.length; i++){
            brr[arr[i]]++;
            temp = arr[arr.length-1];
        }
        for(int i=0; i<brr.length; i++){
            if(brr[i]==0){
                continue;
            }else {
                if(i==temp){
                    System.out.print(i + ":" + brr[i]);
                }else {
                    System.out.print(i + ":" + brr[i] + "<br/>");
                }
            }
        }
    }
}

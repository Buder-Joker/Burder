package NiuKeWang;

import java.util.Scanner;
/*
平均绩点学分制（GPA）
 */

public class Demo26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] brr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
        for(int i=0; i<n; i++){
            brr[i] = in.nextInt();
        }
        System.out.println(print(n,arr,brr));

    }

    private static double print(int n,int[] arr,int brr[]){
        double sum = 0;
        double count = 0;
        for(int i=0; i<n; i++){
            sum+=jiDian(brr[i])*arr[i];
            count+=arr[i];
        }
        return sum/count;
    }
    private static double jiDian(int brr){
        if(brr>=90&&brr<=100){
            return 4.0;
        }else if(brr>=85&&brr<=89){
            return 3.7;
        }else if(brr>=82&&brr<=84){
            return 3.3;
        }else if(brr>=78&&brr<=81){
            return 3.0;
        }else if(brr>=75&&brr<=77){
            return 2.7;
        }else if(brr>=72&&brr<=74){
            return 2.3;
        }else if(brr>=68&&brr<=71){
            return 2.0;
        }else if(brr>=64&&brr<=67){
            return 1.5;
        }else if(brr>=60&&brr<=63){
            return 1.0;
        }else{
            return 0;
        }
    }

}

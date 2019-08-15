package 剑指Offer.ThreeSix360;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        int[] brr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i]= in.nextInt();
        }
        for(int i=0; i<brr.length; i++){
            brr[i]= in.nextInt();
        }
    }
    public static void dfs(int[] arr,int[] brr){
        int[] book = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            book[i] = 0;
            if(arr[i]>=0){
                book[i]=1;
            }
        }
    }
}

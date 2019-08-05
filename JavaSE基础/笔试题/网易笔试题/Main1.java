package 剑指Offer;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        while(q>0){
            int m = sc.nextInt();
            Arrays.sort(arr);
            int count  = 0;
            for(int i=0; i<arr.length; i++){
                if(arr[i]>=m){
                    count++;
                    arr[i]--;
                }
            }
            System.out.println(count);
            q--;
        }
    }
}

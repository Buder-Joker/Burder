package 剑指Offer;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 1; i <= arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i <= arr.length-1; i++) {
            for(int j=i+1; j<=arr.length; j++){
                if((arr[i]+arr[j])%2!=0&&arr[i]>arr[j]){
                    int temp =arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}

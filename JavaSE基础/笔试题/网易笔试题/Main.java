package 剑指Offer;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        while(count>0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            if(isHuan(arr,n)){
                if(isMin(arr,n)){
                    System.out.println("YSE");
                }else{
                    System.out.println("NO");
                }
            }else{
                System.out.println("NO");
            }
            count--;
        }
    }

    private static boolean isMin(int[] arr, int n) {
        Arrays.sort(arr);
        int min = arr[0];
        int max = arr[arr.length-1];
        int index = 0;
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]==arr[j]){
                    index = arr[i];
                }
            }
        }
        if(min+index<max){
            return false;
        }else{
            return true;
        }
    }
    private static boolean isHuan(int[] arr,int n){
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]==arr[j]){
                    return true;
                }
            }
        }
        return false;
    }
}

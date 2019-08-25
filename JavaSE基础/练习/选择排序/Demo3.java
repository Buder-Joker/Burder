package 二叉树;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Demo3 {
    public static void heapSort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,5,9,4,1,8,3};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

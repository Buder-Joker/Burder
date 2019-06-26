package BubbleSort;

import com.sun.org.apache.xpath.internal.FoundIndex;

import java.util.Arrays;


public class Test1 {
    public static void main(String[] args) {
        int[] a = new int[]{5,3,1,9,7,4,6,2,8};
        //maopaoSort(a);
        //charuSort(a);
        //xuanzeSort(a);
        //zhebanSort(a);
        //kuaisuISort(a);
        kuaisuIISort(a);
    }

    public static void swap(int a[],int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static void maopaoSort(int[] a) {
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a.length-i-1; j++){
                if(a[j]>a[j+1]){
                    swap(a,j,j+1);
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
    private static void charuSort(int [] a) {
        for (int i = 1; i < a.length; i++) {
            int val = a[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (a[j] > val) {
                    a[j + 1] = a[j];
                }else{
                    break;
                }
            }
            a[j + 1] = val;
        }
        System.out.println(Arrays.toString(a));
    }
    private static void zhebanSort(int [] a) {
        for (int i = 1; i < a.length; i++) {
            int val = a[i];
            int l = 0;
            int r = i;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (a[mid] > val) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            int j = i - 1;
            //for(; j>r+1;j--)都可以
            for (; j >= l; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = val;
        }
        System.out.println(Arrays.toString(a));
    }
    private static void xuanzeSort(int [] a){
        for(int i=0; i<a.length; i++){
            int min = i;
            for(int j = i+1;j<a.length; j++){
                if(a[j]<a[min]){
                    min = j;
                }
            }
            swap(a,i,min);
        }
        System.out.println(Arrays.toString(a));
    }

    private static void kuaisuISort(int[] a) {
        int l = 0;
        int r = a.length-1;
        kuaisuSort(a,l,r);
        System.out.println(Arrays.toString(a));
    }
    public static void kuaisuSort(int[] a,int l,int r){
        if(l>=r){
            return;
        }
        int p = foundIndex(a,l,r);
        kuaisuSort(a,l,p-1);
        kuaisuSort(a,p+1,r);
    }
    public static int foundIndex(int[] a,int l,int r){
        int val = a[l];
        int i=l+1;
        int j = l;
        for(;i<=r;i++){
            if(a[i]<val){
                swap(a,i,j+1);
                j++;
            }
        }
        swap(a,j,l);
        return j;
    }

    private static void kuaisuIISort(int[] a){
        int l=0;
        int r =a.length-1;
        kuaisuIIsort(a,l,r);
        System.out.println(Arrays.toString(a));
    }
    private static void kuaisuIIsort(int[] a,int l,int r){
        if(l>=r){
            return;
        }
        int i = l;
        int j = r;
        int val = a[l];
        while(i<j){

            while(a[j]>=val&&i<j){
                j--;
            }

            while(a[i]<=val&&i<j){
                i++;
            }
            swap(a,i,j);
        }
        //swap(a,i,l)也行
        swap(a,j,l);
        kuaisuIIsort(a,l,j-1);
        kuaisuIIsort(a,j+1,r);
        return;
    }
}

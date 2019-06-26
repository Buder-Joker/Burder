package BubbleSort;
/*
每当发现比基准值小的元素放在左边，比他大的防砸右边，当遍历一次结束后一定有一个元素放在了属于他的位置
也就是最终位置此时分量下来，结果
 */
//冒泡排序
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = new int[] {2,5,9,3,6,1,8,4,7};
        int left = 0;
        int right = a.length-1;
        /*maopaoSort(a);
        System.out.println("-----");
        charuSort(a);
        System.out.println("-----");
        zhebanSort(a);
        System.out.println("-----");
        xuanzeSort(a);
        System.out.println("-----");
        guibinSort(a,left,right);
        kuaisuSort(a);*/
        kuaiSort(a,left,right);
        System.out.println(Arrays.toString(a));

    }
    //冒泡排序
    public static void maopaoSort(int a[]){
        long star = System.currentTimeMillis();
        for(int i= 0; i<a.length; i++) {
            boolean flag = false;
            for(int j=0; j<a.length-i-1; j++) {
                if(a[j]>a[j+1]) {
                    flag = true;
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            if(!flag) {
                System.out.println("当前的i为："+i);
                break;
            }
        }
        System.out.println(Arrays.toString(a));
        long end = System.currentTimeMillis();
        System.out.println(end-star);
    }
    //插入排序
    public static void charuSort(int a[]){
    long star = System.currentTimeMillis();
        int n = a.length;
        if(n<=1){
            return;
        }else{
            //待排序元素
            for(int i=1; i<n; i++){
                int val = a[i];
                //已排序的最后一个元素
                int j=i-1;
                //已排序元素
                for(; j>=0; j--){
                    if(a[j]>val){
                        a[j+1]=a[j];
                    }else{
                        break;
                    }
                }
                a[j+1]=val;
            }
        }System.out.println(Arrays.toString(a));
        long end = System.currentTimeMillis();
        System.out.println(end-star);
    }
    //折半排序
    public static void zhebanSort(int a[]){
        long star = System.currentTimeMillis();
        int n = a.length;
        if(n<=1){
            return;
        }else{
            for(int i=1; i<a.length; i++){
                int val = a[i];
                int left = 0;
                int right = i;
                while(left<=right){
                    int mid = (left+right)/2;
                    if(a[mid]<val){
                        left=mid+1;
                    }else{
                        right = mid-1;
                    }
                }
                int j = i-1;
                for(;j>=right+1;j--){
                    a[j+1] = a[j];
                }
                a[j+1] = val;
            }
        }
        System.out.println(Arrays.toString(a));
        long end = System.currentTimeMillis();
        System.out.println(end-star);
    }
    //选择排序
    public static void xuanzeSort(int a[]){
        long star = System.currentTimeMillis();
        if(a.length<=1){
            return;
        }else{
            for(int i=0; i<a.length; i++){
                int min = i;
                for(int j=i+1; j<a.length; j++){
                    if(a[j]<a[min]){
                        min = j;
                    }
                }
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
        System.out.println(Arrays.toString(a));
        long end = System.currentTimeMillis();
        System.out.println(end-star);
    }
    //归并排序
    public static void guibinSort(int a[],int left, int right){
        if(left>=right){

            return ;
        }
        int mid = (right+left)/2;
        guibinSort(a,left,mid);
        guibinSort(a,mid+1,right);

        guibinsort(a,left,mid,right);
        System.out.println(Arrays.toString(a));
    }
    //归并排序中的合并数组
    public static void guibinsort(int a[],int left,int mid,int right){
        int[] temp = new int[right-left+1];
        int i=left;
        int j=mid+1;
        int k = 0;
        while(i<=mid&&j<=right){
            if(a[i]<=a[j]){
                temp[k++]=a[i++];
            }else{
                temp[k++]=a[j++];
            }
        }
        int start = i;
        int endl =mid;
        if(j<=right){
            start = j;
            endl = right;
        }
        while(start<=endl){
            temp[k++]=a[start++];
        }
        for(i=0; i<=right-left; i++){
            a[left+i] = temp[i];
        }

    }
    //快速排序1
    public static void kuaisuSort(int a[]){
        int l = 0;
        int r = a.length-1;
        kuaisusort(a,l,r);
        System.out.println(Arrays.toString(a));
    }
    public static void kuaisusort(int a[],int l, int r){
        if(l>=r){
            return;
        }
        int p = findjizhunSort(a,l,r);
        kuaisusort(a,l,p-1);
        kuaisusort(a,p+1,r);
    }
    public static int findjizhunSort(int a[],int l,int r){
        //int random =( int)(Math.random()*(r-l)+1);
        //swap(a,random,l);
        int v = a[l];
        int j = l;
        int i = l+1;
        for(;i<=r; i++){
            if(a[i]<v){
                swap(a,j+1,i);
                j++;
            }
        }
        swap(a,j,l);
        return j;
    }
    public static void swap(int a[],int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //快速排序2
    public static void kuaiSort(int a[],int l,int r){
        if(l>=r){
            return;
        }
        int i = l;
        int j= r;
        int temp = a[l];
        while(i!=j){

            while(a[j]>=temp&&i<j){
                j--;
            }
            while(a[i]<=temp&&i<j){
                i++;
            }
            if(i<j){
                swap(a,i,j);
            }
        }
        a[l]=a[i];
        a[i]=temp;
        kuaiSort(a,l,i-1);
        kuaiSort(a,i+1,r);
        return;
    }

}

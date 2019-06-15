package NiuKeWang;
/*
某个数占数组元素的一半以上，找出这个元素

本题虽然通过测试，但是使用了额外空间和时间复杂度较大
 */
public class Demo24 {
    public static int getValue(int[] gifts, int n) {
        // write code here
        int[] arr = new int[100000];
        for (int i = 0; i < gifts.length; i++) {
            arr[gifts[i]]++;
        }
        int max = arr[0];
        int t = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                t=i;
            }
        }
        if (max >= n / 2) {
            return t;
        } else {
            return 0;
        }
    }

    //答案
    public static int getValues(int[] gifts,int n){
        int ans = gifts[gifts.length/2];
        int count =0;
        for(int i=0; i<gifts.length; i++){
            if(ans==gifts[i]){
                count++;
            }
        }
        return count>=ans?ans:0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,4,2};
        int n = arr.length;
        System.out.println(getValue(arr,n));

    }
}

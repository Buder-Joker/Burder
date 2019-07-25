package 剑指Offer;
/*
二维数组自上而下，自左向右以此递增，查找是否包含某个数字
 */
public class offer1 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int w =4;
        int h =4;
        int num = 78;
        System.out.println(isHave(arr,w,h,num));
    }

    private static boolean isHave(int[][] arr,int w,int h,int num){
        if(arr==null||w<0||h<0){
            return false;
        }else{
            int w1 = 0;
            int h1 = h-1;
            while(w1<w&&h1>0){
                if(arr[w1][h1]>num){
                    h1--;
                }else if(arr[w1][h1]<num){
                    w1++;
                }else {
                    System.out.println(w1+" "+h1);
                    return true;
                }
            }
        }
        return false;
    }
}

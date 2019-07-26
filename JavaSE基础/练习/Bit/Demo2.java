package Bit;
/*
 判断一个数是不是快乐数

 */
public class Demo2 {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
    public static boolean isHappy(int n){

        for(int i=0; i<50; i++){
            int t = 0;
            while(n>0){
                t+= (n%10)*(n%10);
                n/=10;
            }
            if(t==1){
                return true;
            }
            n=t;
        }
        return false;
    }

}

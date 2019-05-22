package NiuKeWang;
/*
str1 = aba;
str2 = b;
sre2往str1里边插，判断新的字符串是否为回文，若是 count+1；
 */
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        //System.out.println(isHuiWen(str1));
        String str2 = in.next();
        int count = 0;
        //System.out.println(isHuiWen(str2));
        /*StringBuilder sb1 = new StringBuilder(str1);
        StringBuilder sb2 = new StringBuilder(str2);
        char[] arr = str1.toCharArray();
        int lenth = arr.length;
        String stringBuilder = sb1+"";*/

        for(int i=0; i<=str1.length(); i++){
            StringBuilder sb = new StringBuilder(str1);
            sb.insert(i,str2);
            System.out.println(sb);
            String str = sb+"";
            if(isHuiWen(str)){
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean isHuiWen(String str){
        char[] arr = str.toCharArray();
        char[] srr = new char[arr.length/2];
        for(int i=0; i<srr.length; i++){
            srr[i] = arr[i];
        }
        int index = 0;
        int t = srr.length-1;
        if(arr.length%2==0){
            index = arr.length/2;
        }else {
            index = arr.length/2+1;
        }
        for(int i =index; i<arr.length; i++){
            if(arr[i]==srr[t]){
                if(t==0){
                    return true;
                }
                t--;
            }
        }
        return false;
    }
}

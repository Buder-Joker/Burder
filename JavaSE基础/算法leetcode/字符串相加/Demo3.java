package 算法;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
实现俩字符串相加
str1 = ”123“
str2 = “456”
输出:str = “579”
 */
public class Demo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        String c = addString(a,b);
        c = new StringBuilder(c).reverse().toString();
        System.out.println(c);

    }
    public static String addString(String str1,String str2){
        String str = "";
        char[] arr = str1.toCharArray();
        char[] brr = str2.toCharArray();
        int end1 = arr.length-1;
        int end2 = brr.length-1;
        //进位
        int next = 0;
        while(end1>=0||end2>=0){
            int value1=0;
            int value2=0;
            if(end1>=0){
                value1 = arr[end1]-'0';
            }
            if(end2>=0){
                value2 = brr[end2]-'0';
            }
            int value = value1+value2+next;
            if(value>9){
                next = 1;
                value-=10;
            }else{
                next = 0;
            }
            str = str+value;
            end1--;
            end2--;
        }
        if(next==1){
            str = str+1;
        }
        return str;
    }
}

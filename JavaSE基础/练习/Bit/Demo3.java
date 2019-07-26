package Bit;
/*
题目描述：给定一个英文字符串，写一段代码找出字符串中首先出现三次的英文字母
输入： Have you ever gone shopping and
输出： e
 */
//import java.util.Arrays;
import java.util.Scanner;
public class Demo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        isThree(s);
    }
    public static void isThree(String s){

        char [] a = s.toCharArray();
        A:for(int i=0; i<a.length; i++){
            int count = 0;
            for(int j=0; j<a.length; j++){
                if((a[i]>='a'&&a[i]<='z')||(a[i]>='A'&&a[i]<='Z')){
                    if(a[i]==a[j]){
                        count++;
                    }
                }
                if(count==3){
                    System.out.println(a[i]);
                    break A;
                }
            }
            if(i==a.length-1){
                System.out.println("没有找到！！");
            }
        }

    }

}

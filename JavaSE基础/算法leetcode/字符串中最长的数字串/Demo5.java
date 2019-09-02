<<<<<<< HEAD
package 算法;

import java.util.Scanner;

/*
输出在字符串中最长数字串
 */
public class Demo5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(longString(str));
    }
    private static String longString(String str) {
        String ans = "";
        String ret = "";
        char[] arr = str.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i]>='0'&&arr[i]<='9'){
                ans+=arr[i];
                ret=ret.length()>ans.length()?ret:ans;
            }else{
                ans="";
            }
        }
        ans = ans.length()>ret.length()?ans:ret;
        return ans;
    }
}
=======
package 算法;

import java.util.Scanner;

/*
输出在字符串中最长数字串
 */
public class Demo5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(longString(str));
    }
    private static String longString(String str) {
        String ans = "";
        String ret = "";
        char[] arr = str.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i]>='0'&&arr[i]<='9'){
                ans+=arr[i];
                ret=ret.length()>ans.length()?ret:ans;
            }else{
                ans="";
            }
        }
        ans = ans.length()>ret.length()?ans:ret;
        return ans;
    }
}
>>>>>>> 6c37b49e41cc412a1b093fbd5f2b033c47f2d582

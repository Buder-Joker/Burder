package NiuKeWang;

import java.util.ArrayList;
import java.util.List;

//子串判断
/*
输出:
true true true fasle
 */
public class Demo22 {
    public static void main(String[] args) {
        String p[] = {"a","b","c","g"};
        int n = p.length;
        String s = "abc";
        boolean[] b =isBaokuoString(p,n,s);
        for(int i=0;i<b.length; i++){
            System.out.print(b[i]+" ");
        }

    }
    public static boolean[] chkSubStr(String[] p,int n,String s){
        List<Boolean> list = new ArrayList<>();
        int t = 0;
        for(int i=0; i<n; i++){
            if(s.contains(p[i])){
                list.add(true);
            }else{
                list.add(false);
            }
        }
        boolean[] b = new boolean[list.size()];
        for(int i=0; i<list.size(); i++){
            b[i] = list.get(i);
        }
        return b;
    }

    //标准答案
    public static boolean[] isBaokuoString(String[] p,int n,String s){
        boolean[] arr = new boolean[n];
        for(int i=0; i<n; i++){
            arr[i]=s.contains(p[i]);
        }
        return arr;
    }


}

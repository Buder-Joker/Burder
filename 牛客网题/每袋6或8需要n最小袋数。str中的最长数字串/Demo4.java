package NiuKeWang;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/*
读入一个字符串，输出字符串str中连续最长的数字串
 */
public class Demo4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        isFigure(str);
    }

    private static void isFigure(String str) {
        int count = 0;
        int max = 0;
        int end = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                count++;
                if(max<count){
                    max=count;
                    end =i;
                }
            }else {
                count= 0;
            }
        }
        System.out.println(str.substring(end-max+1,end+1));
    }
}

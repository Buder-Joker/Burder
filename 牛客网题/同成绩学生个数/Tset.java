package NiuKeWang;
/*
统计同成绩学生个数
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tset{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        //List list = new ArrayList();
        while(true){
            int N = in.nextInt();
            if(N==0){
                break;
            }
            int[] arr = new int[N];
            for(int i=0; i<arr.length; i++){
                arr[i] = in.nextInt();
            }
            int X = in.nextInt();
            int count = 0;
            for(int i=0; i<arr.length; i++){
                if(arr[i]==X){
                    count++;
                }
            }
            //list.add(count);
            stringBuilder.append(count);
        }
        for(int i=0; i<stringBuilder.length(); i++){
            System.out.println(stringBuilder.toString().charAt(i));
        }
    }


}

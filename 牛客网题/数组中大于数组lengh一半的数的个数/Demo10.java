package NiuKeWang;
/*
数组中出现大于数组长度n/2的数的个数
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Demo10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        isRight(str);
        //isMymake();

        //Other();

    }

    private static void isMymake() {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int t = 0;
        while(in.hasNextInt()){
            list.add(in.nextInt());
            t++;
        }
        System.out.println(t);
        int count = 0;
        //Iterator it = list.iterator();
        for(int i=0; i<list.size(); i++){
            if(list.get(i)>=(list.size()/2)){
                count++;
            }
        }
        System.out.print(count);
    }

    private static void Other() {
        Scanner cin = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        while(cin.hasNextInt()){
            list.add(cin.nextInt());
        }

        Collections.sort(list);

        System.out.println(list.get(list.size()/2-1));
    }

    private static void isRight(String str){
        String[] strings = str.split("");
        int[] arr = new int[strings.length];
        int n = strings.length;
        int count = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.valueOf(strings[i]);
        }
        for(int i=0; i<n; i++){
            if(arr[i]>=n/2){
                count++;
            }
        }
        System.out.println(count);
    }
}

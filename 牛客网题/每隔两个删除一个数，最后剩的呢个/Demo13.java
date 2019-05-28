package NiuKeWang;
/*
链接：https://www.nowcoder.com/questionTerminal/f9533a71aada4f35867008be22be5b6e
来源：牛客网

有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，
求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，
0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。

 */

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Demo13 {

    public static void main(String[] age){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n>1000){
                n = 999;
            }
            List<Integer> list = new LinkedList<>();
            for(int i=0; i<n; i++){
                list.add(i);
            }
            int i=0;
            while(list.size()>1){
                i = (i+2)%list.size();
                list.remove(i);
            }
            System.out.println(list.get(0));
        }
    }
    //自己未完成
    public static int deleteLast(int[] arr) {
        int[] brr = new int[arr.length];
        for (int i = 0; i < brr.length; i++) {
            brr[i] = 1;
        }
        int i = 2;
        int temp = 0;
        while (arr.length>1) {
            temp = i % arr.length;
            brr[temp] = 0;

        }
        return 0;
    }
}

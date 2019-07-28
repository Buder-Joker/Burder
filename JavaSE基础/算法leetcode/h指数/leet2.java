package BubbleSort.leetCode;
/*
h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）
至多有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）”

示例://0 1 3 5 6
11 22 33
输入: citations = [3,0,6,1,5]
输出: 3
解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
     由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
 */
public class leet2 {
    public static int hIndex(int[] a) {
        int count = 0;
        if(a.length==0){
            return 0;
        }
        int t= 0;
        int h = 0;
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a.length-1-i; j++){
                if(a[j]>a[j+1]){
                    t = a[j];
                    a[j] = a[j+1];
                    a[j+1]=t;
                }
            }
        }
        for(int i=0; i<a.length-1; i++){
            for(int j=0; j<a.length; j++){
                if(a[j]>=a[i]){
                    count++;
                }
            }
            if(count==a[i]){
                h=count;
            }
        }
        return 0;
        /*int h = 0;
        for(int i=0; i<citations.length; i++){
            int val=citations[i];
            int count = 0;
            for(int j= 0; j<citations.length; j++){
                if(citations[j]>=val){
                    count++;
                    if(count>=val){
                       h = h>val? h:val;
                    }
                }

            }

        }return h;*/
    }

    public static void main(String[] args) {
        int [] citations= new int[]{11,15,16};
        System.out.println(hIndex(citations));
    }
}

package Bit;
/*
狐狸抓兔子：十个洞围成一个圈，狐狸从0号先开始，下一次隔一个洞，接着隔俩洞，三洞，，，最后找了1000次，也没有把
兔子找出来，问兔子可能在哪个洞？
 */
public class Demo4 {
    public static void main(String[] args) {
        int[] a = new int[10];
        for(int i=0; i<a.length; i++){
            a[i]=1;
        }
        int t = 0;
        int count = 0;
        for(int i=2; i<=1000; i++){
            t = t+i;
            count = t%10;
            a[count] = 0;
        }
        for(int i=0; i<a.length; i++){
            if(a[i]==1){
                System.out.print(i+" ");
            }
        }
    }
}

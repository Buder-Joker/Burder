package NiuKeWang;

import java.util.Scanner;

/*
机器人走方格

输入:2 2
输出:2
 */
public class Demo15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        System.out.println(countWays(x,y));
    }
    public static int countWays(int x ,int y){
        if(x<=0||y<=0){
            return 0;
        }
        if(x==1||y==1){
            return 1;
        }
        return countWays((x-1),y)+countWays(x,(y-1));
    }

    public static int countWayss(int x,int y){
        int[][] arr = new int[x][y];
        for(int i=0; i<x; i++){
            arr[i][0]=1;
        }
        for(int i=0; i<y; i++){
            arr[0][y]=1;
        }
        return 0;
    }

}

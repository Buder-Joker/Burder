package 剑指Offer.ThreeSix360;

import java.util.Scanner;

public class Main1{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                arr[i][j] = in.nextInt();
            }
        }
        int sum = ((N+M+N*M)<<1);
        int sum1 = 0;
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j]>1){
                    sum1 = sum1+4;
                    count++;
                    if(count>=2){
                        sum1=sum1-2;
                    }
                }
            }
        }
        System.out.println(sum+sum1);
    }
}

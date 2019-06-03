package NiuKeWang;

import java.util.Scanner;

/*
和奥巴马学编程
 */
public class Demo17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        isZheng(n,str);
        /*for (int i = 0; i < n/2; i++) {
            for(int j=0; j<n; j++){
                if(i==0||i==(n/2-1)){
                    System.out.print(str);
                }
            }
            if(i==0){
                for(int k=0; k<n/2-1; k++){
                    if(k==(n/2-1)-1){
                        System.out.print("<br/>");
                    }else {
                        System.out.print("<1 br/>" + str + str);
                    }
                }
            }
        }*/
    }
    private static void isZheng(int n,String str){
        for (int i = 0; i < n/2; i++) {
            for(int j=0; j<n; j++){
                if(i==0||i==(n/2-1)){
                    System.out.print(str);
                }
            }
            System.out.println();
            for(int k=0; k<n; k++){
                if(i<n/2-2){
                    if((k==0||k==n-1)){
                        System.out.print(str);
                    }else{
                        System.out.print(" ");
                    }
                }
            }

        }
    }

}

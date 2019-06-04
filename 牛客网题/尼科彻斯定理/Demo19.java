package NiuKeWang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
尼科彻斯定理
1
1
2
3+5
3
7+9+11
4
13+15+17+19
5
21+23+25+27+29
6
31+33+35+37+39+41
 */
public class Demo19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int m = in.nextInt();
            System.out.println(GetSequeOddNum(m));
        }
    }
    public static String GetSequeOddNum(int m){
        List list = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        int sum =0;
        for(int i=1; i<m; i++){
            sum = sum+i;
        }
        int count = 0;
        count = 2*sum+1;
        for(int i=0; i<m; i++){
            list.add(count+2*i);
        }
        for(int i=0; i<list.size(); i++){
            if(i==list.size()-1){
                stringBuilder.append(list.get(i));
            }else {
                stringBuilder.append(list.get(i) + "+");
            }
        }
        return stringBuilder.toString();

    }
}

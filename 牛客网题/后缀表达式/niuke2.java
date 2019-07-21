package NiuKeWang.Niuke;
/*
后缀表达式
 */
import java.util.Scanner;
import java.util.Stack;

public class niuke2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        while (sc.hasNext()){
            int num = sc.nextInt();
            String[] str = new String[num];
            for(int i=0; i<num; i++){
                str[i] = sc.next();
            }
            for(String s: str){
                char c = s.charAt(0);
                if(s.length()==1&&c=='+'||c=='-'||c=='*'||c=='/'){
                    int a = (Integer)stack.pop();
                    int b = (Integer)stack.pop();
                    stack.push(sum(a,b,c));
                }else{
                    stack.push(Integer.parseInt(s));
                }
            }
            System.out.println(stack.peek());
        }

    }
    private static int sum(int a,int b,char c){
        switch (c){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
            default:

        }
        return 0;
    }
}

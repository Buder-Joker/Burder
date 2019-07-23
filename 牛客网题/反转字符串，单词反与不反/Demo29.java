package NiuKeWang;
/*
反转字符串
 */
import java.util.Scanner;
import java.util.Stack;

public class Demo29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        reverse(str);
    }
    /*整个反转
    i am a boy
    yob a ma i
    */
    private static void reverses(String str){
        char[] arr = new char[str.length()];
        Stack stack = new Stack();
        int index = 0;
        while (index<str.length()){
            stack.push(str.charAt(index));
            index++;
        }
        int index2 = 0;
        while (!stack.isEmpty()){
            arr[index2] = (char)stack.pop();
            index2++;
        }
        System.out.println(String.valueOf(arr));
    }
    /*
    不反转单词
    i am a boy
    boy a am i
     */
    private static void reverse(String str){
        Stack<String> stack = new Stack<>();
        int index = 0;
        int bigin = 0;
        while (index<str.length()){
            if(str.charAt(index)==' '){
                stack.push(str.substring(bigin,index));
                bigin = index+1;
            }
            index++;
        }
        stack.push(str.substring(bigin));

        //int index2 = 0;
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
        //System.out.println(String.valueOf(arr));
    }
}

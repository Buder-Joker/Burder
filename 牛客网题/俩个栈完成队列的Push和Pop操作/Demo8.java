package NiuKeWang;
/*
用俩个栈实现队列，完成push()和pop()操作
 */

import java.util.Stack;

class StackQueue{
    private static Stack<Integer> stack1 = new Stack();
    private static Stack<Integer> stack2 = new Stack();
    public static void push(int node){
        stack1.push(node);
    }
    public static int pop(){
        if(stack1.isEmpty()&&stack2.isEmpty()){
            System.out.println("队列为空");
        }
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
public class Demo8 {
    public static void main(String[] args) {

    }
}

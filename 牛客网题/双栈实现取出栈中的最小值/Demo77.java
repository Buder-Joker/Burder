package dataStruct;
/*
用双栈实现取出栈中的最小值
 */
import java.util.Stack;
class MinStack7 {
    private Stack<Integer> stack;
    private Stack<Integer> minStact;

    public MinStack7() {
        stack = new Stack<>();
        minStact = new Stack<>();
    }

    public void push(int x) {
        if(minStact.isEmpty()||x<=minStact.peek()){
            minStact.push(x);
        }
        stack.push(x);
    }
    public void pop() {
        if(stack.peek().equals(minStact.peek())){
            minStact.pop();
        }
        stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return minStact.peek();
    }

}
public class Demo77 {

}

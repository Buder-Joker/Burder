package NiuKeWang;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyStack {

    Queue<Integer> queueA;
    Queue<Integer> queueB;
    public MyStack() {
        queueA = new LinkedList();
        queueB = new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(queueA.isEmpty()){
            queueB.add(x);
        }else {
            queueA.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queueA.isEmpty()){
            int len = queueB.size();
            for(int i=0; i<len-1; i++){
                queueA.add(queueB.poll());
            }
            int result =  queueB.poll();
            return result;
        }else{
            int len = queueA.size();
            for(int i=0; i<len-1; i++){
                queueB.add(queueA.poll());
            }
            int result = queueA.poll();
            return result;
        }
    }

    /** Get the top element. */
    public int top() {
        if(queueA.isEmpty()){
            int len = queueB.size();
            for(int i=0; i<len-1; i++){
                queueA.add(queueB.poll());
            }
            int result = queueB.poll();
            queueA.add(result);
            return result;
        }else{
            int len = queueA.size();
            for(int i=0; i<len-1; i++){
                queueB.add(queueA.poll());
            }
            int result = queueA.poll();
            queueB.add(result);
            return result;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queueB.isEmpty()&&queueA.isEmpty();
    }

}

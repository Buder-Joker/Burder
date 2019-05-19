package dataStruct;

//基于链表实现栈
public class LinkedStack implements Stack {

    class Node{
        Object data;
        Node next;

        public Node(Object data){
            this.data = data;
        }
    }
    private Node top;
    private int size;
    //入栈
    @Override
    public void push(Object data) {
        Node node = new Node(data);
        if(isEmpty()){
            top = node;
        }
        node.next=top;
        top = node;
        size++;
    }
    //出栈
    @Override
    public void pop() {
        if(isEmpty()){
            System.out.println("栈已空！");
        }
        Object data = top.data;
        top = top.next;
        System.out.println(data);
        size--;
    }
    //栈顶元素
    @Override
    public Object peek() {
        if(isEmpty()){
            System.out.println("栈已空！");
        }
        return top.data;
    }
    //栈的大小
    @Override
    public int getSize() {
        return size;
    }
    //栈是否为空
    @Override
    public boolean isEmpty() {
        if(size==0) {
            return true;
        }
        return false;
    }
}

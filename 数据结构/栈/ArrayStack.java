package dataStruct;

//基于数组实现栈
public class ArrayStack<T> implements Stack<T> {
    public int maxSize;
    public Object[] elem;
    public int top;
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        elem = new Object[maxSize];
        top = 0;
    }
    //入栈
    @Override
    public void push(Object data) {
        if(getSize()== maxSize){
            //Object[] newElem = new Object[maxSize<<1];
            //newElem = elem;
            System.out.println("栈已满！");
        }
        elem[top] = data;
        top++;
    }
    //出栈
    @Override
    public void pop() {
        if(isEmpty()){
            System.out.println("栈已空！");
        }
        Object data = elem[--top];
        System.out.println(data);
    }
    //栈顶元素
    @Override
    public Object peek() {
        if(isEmpty()){
            return null;
        }
        return elem[top-1];
    }
    //栈的大小
    @Override
    public int getSize() {
        return top;
    }

    //栈是否为空
    @Override
    public boolean isEmpty() {
        if(getSize()==0){
            return true;
        }
        return false;
    }
}

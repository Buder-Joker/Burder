package dataStruct;

public class ArrayQueue implements Queue {
    private int head;
    private int tail;
    private Object[] arr;
    public ArrayQueue(int maxQueue){
        arr = new Object[maxQueue];
    }
    //入队
    @Override
    public void enQueue(Object o) {
        if(getSize()==arr.length){
            if(head==0){
                System.err.println("队列已满！");
            }else{
                for(int i=head; i<tail; i++){
                    arr[i-head] = arr[i];
                }
                tail = tail-head;
                head = 0;
            }
        }else{
            arr[tail++] =o;
        }
    }
    //出队
    @Override
    public Object deQueue() {
        if(isEmpty()){
            System.err.println("队列为空！");
        }
        return arr[head++];
    }
    //队首元素
    @Override
    public Object peek() {
        if(isEmpty()){
            System.err.println("队列为空！");
        }
        return arr[head];
    }
    //队列大小
    @Override
    public int getSize() {
        return tail-head;
    }
    //队列是否为空
    @Override
    public boolean isEmpty() {
        return head==tail;
    }
}

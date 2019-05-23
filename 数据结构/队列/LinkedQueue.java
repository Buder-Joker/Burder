package dataStruct;

public class LinkedQueue<E> implements Queue<E>{
    Node head ;
    Node tail;
    int size;
    class Node {
        E data;
        Node next;
        public Node(E data){
            this.data = data;
        }
    }
    //入队
    @Override
    public void enQueue(E e) {
        Node newNode = new Node(e);
        if(head==null){
            head = tail = newNode;
        }else{
            tail.next=newNode;
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E deQueue() {
        if(isEmpty()){
            System.err.println("队列为空！");
        }
        E temp= head.data;
        head.data = null;
        head = head.next;
        size--;
        return temp;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            System.err.println("队列为空！");
        }
        return head.data;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}

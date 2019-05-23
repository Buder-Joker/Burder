package dataStruct;

public class TestLinkedQueue {
    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enQueue(1);
        linkedQueue.enQueue(2);
        linkedQueue.enQueue(3);
        linkedQueue.enQueue(4);
        linkedQueue.enQueue(5);
        System.out.println(linkedQueue.getSize());
        System.out.println(linkedQueue.peek());
    }
}

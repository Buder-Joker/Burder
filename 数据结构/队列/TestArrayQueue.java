package dataStruct;

public class TestArrayQueue {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enQueue(1);
        arrayQueue.enQueue(2);
        arrayQueue.enQueue(3);
        arrayQueue.enQueue(4);
        arrayQueue.deQueue();
        arrayQueue.enQueue(5);

        System.out.println(arrayQueue.getSize());
        System.out.println(arrayQueue.peek());

        //System.out.println(arrayQueue.peek());
    }
}

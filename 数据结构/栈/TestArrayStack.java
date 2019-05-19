package dataStruct;

public class TestArrayStack {
    public static void main(String[] args) {
        ArrayStack<Integer> elem = new ArrayStack<Integer>(5);
        elem.push(1);
        elem.push(2);
        elem.push(3);
        elem.push(4);
        elem.push(5);
        System.out.println(elem.peek());
        elem.pop();
        System.out.println(elem.peek());
        System.out.println(elem.getSize());
    }
}

package dataStruct;

public interface Stack<T> {
    void push(Object data);
    void pop();
    Object peek();
    int getSize();
    boolean isEmpty();
}

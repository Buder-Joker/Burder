package dataStruct;

public interface Tree<E> {
    void add(E e);
    boolean contain(E e);

    void perOrder();
    void inOrder();
    void postOrder();
    //层序遍历
    void levelOrder();
    E getMin() throws Exception;
    E getMax() throws Exception;
    E removeMin();
    E removeMax();

    boolean remove(E e);
    int size();
}

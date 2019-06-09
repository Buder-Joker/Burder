package dataStruct;

import java.util.Arrays;
import java.util.Comparator;

public class Heap<E> {
    private Comparator<E> comparator;
    //默认初始容量
    private static final int DEFAULT_CAPACITY = 10;
    private static int size;
    private E[] elemData ;
    public Heap(){
        this(DEFAULT_CAPACITY,null);
    }
    public Heap(int initialCapacity){
        this(initialCapacity,null);
    }
    public Heap(int initialCapacity,Comparator<E> comparator){
        this.elemData = (E[])new Object[initialCapacity];
        this.comparator = comparator;

    }


    //添加元素
    public void add(E e){
        if(elemData.length==DEFAULT_CAPACITY){
            grow();
        }
        elemData[size++] = e;
        siftUp(size-1);
    }
    //上浮
    private void siftUp(int index) {
        while (index>0&&compare(elemData[index],elemData[parentIndex(index)])>0){
            swap(index,parentIndex(index));
            index = parentIndex(index);
        }
    }

    public int leftIndex(int index){
        return 2*index+1;
    }
    public int rigthIndex(int index){
        return 2*index+2;
    }
    public int parentIndex(int index){
        return (index-1)/2;
    }
    private void swap(int indexA,int indexB){
        E temp = elemData[indexA];
        elemData[indexA] = elemData[indexB];
        elemData[indexB] = temp;

    }
    private void grow() {
        int oldElem = elemData.length;
        int newElem = oldElem +(oldElem<64?oldElem:oldElem>>1);
        elemData = Arrays.copyOf(elemData,newElem);
    }

    public int compare(E o1, E o2) {
        if(comparator==null){
            return ((Comparable<E>)o1).compareTo(o2);
        }
        return comparator.compare(o1,o2);
    }

    public static int Size() {
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    //将任意数组变成一个堆
    public Heap(E[] arr){
        elemData = (E[])new Object[arr.length];
        for(int i=0; i<arr.length; i++){
            elemData[i] = arr[i];
        }
        size = elemData.length;
        for(int i=(arr.length-1-1)/2; i>=0; i--){
            siftDown(i);
        }
    }
    public E findMax(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("heap is empty!");

        }
        return elemData[0];
    }
    //删除任意元素
    public E removeMax(){
        E result = findMax();
        swap(0,size-1);
        elemData[--size] = null;
        //下沉找合适位置
        siftDown(0);
        return result;
    }

    //将根节点替换为新的元素
    public E replace(E newEmedata){
        E result = elemData[0];
        elemData[0] = newEmedata;
        siftDown(0);
        return result;

    }
    //下沉
    private void siftDown(int index){
        while(leftIndex(index)<size){
            int j = leftIndex(index);
            if(j+1<size){
                if(compare(elemData[j],elemData[j+1])<0){
                    //指向右孩子下标
                    j++;
                }
                //保证elemData[j]一定是最大的
            }
            if(compare(elemData[index],elemData[j])<0){
                swap(index,j);
                index = j;
            }else{
                break;
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(E e:elemData){
            if(e!=null){
                stringBuilder.append(e+" ");
            }
        }
        return stringBuilder.toString();
    }
}

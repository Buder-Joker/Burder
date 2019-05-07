package dataStruct;

public class data1 {
    public static class Node{
        Node next;
        Object data;
        public Node(Object data){
            this.data = data;
        }
        public Node(Node next,Object data){
            this.data = data;
            this.next = next;
        }
    }
    private static int size;
    private static Node dummyNode;
    private data1(Node dummyNode){
        this.dummyNode = new Node(null,null);
    }
    //在任位置插入元素
    private static void add(int index,Object data){
        IsCheck(index);
        Node pre = dummyNode;
        Node newNode = new Node(data);
        for(int i=0; i<index; i++){
            pre=pre.next;
        }
        newNode.next = pre.next;
        pre.next = newNode;
        size++;
    }
    //头插
    private static void addFirst(int index, Object data){
        IsCheck(index);
        add(0,data);
    }
    //尾插
    private static void addLast(int index,Object data){
        IsCheck(index);
        add(size,data);
    }
    //找到当前结点
    private static Node get(int index){
        Node pre =dummyNode.next;
        for(int i=0; i<index; i++){
            pre=pre.next;
        }
        return pre;
    }
    //将某处的数据换成一个新的数据,返回旧数据
    private static Object set(int index,Object newData){
        IsCheck(index);
        Node node = get(index);
        Object oldData = node.data;
        node.data = newData;
        return oldData;
    }
    //移除某个结点
    private static void remove(int index){
        IsCheck(index);
        Node pre = dummyNode;
        for(int i=0; i<index; i++){
            pre=pre.next;
        }
        pre.next = pre.next.next;
        size--;
    }
    //链表的反转
    private static void resverList(Node dummyNode){
        Node p = dummyNode.next;
        Node l = p.next;
        while(p.next!=null){
            p.next = l.next;
            l.next = dummyNode.next;
            dummyNode.next = l;
            l=p.next;
        }
    }
    //K个数反转
    private static void KresverList(int k,Node dummyNode){
        Node pre = dummyNode.next;
        for(int i = 0; i<k; i++){
            pre = pre.next;
        }
        Node p = dummyNode.next;
        Node l = p.next;
        while(p.next!=pre){
            p.next = l.next;
            l.next = dummyNode.next;
            dummyNode.next = l;
            l = p.next;
        }
    }
    //清空链表
    private static void clear(){
        for(Node temp=dummyNode.next; temp.next!=null; temp=temp.next){
            temp.data= null;
            Node per = temp.next;
            temp.next=null;
            temp = per;
            size--;
        }
    }
    //检查是否包含某个数据
    private static boolean contains(Object data){
        for(Node temp = dummyNode.next; temp!=null; temp=temp.next){
            if (temp.data == data) {
                return true;
            }
        }
        return false;
    }

    //将链表中的元素存在数组中
    private static Object[] toArray(){
        Object[] arr = new Object[size];
        int i = 0;
        for(Node temp=dummyNode.next; temp!=null; temp=temp.next){
            arr[i] = temp.data;
            i++;
        }
        return arr;
    }

    //判断索引值是否合理
    private static void IsCheck(int index){
        if(index<0||index>size){
            System.out.println("索引值不合理！！");
        }
    }
    //链表大小
    public static int size(int size) {
        return size;
    }
    //输出链表
    private static void printf(){
        for(Node temp = dummyNode.next; temp!=null; temp = temp.next){
            System.out.print(temp.data+" ");
        }
    }

    public static void main(String[] args) {
        data1 d = new data1(dummyNode);
        d.addLast(0,1);
        d.addLast(1,2);
        d.addLast(2,3);
        d.addLast(3,4);
        d.addLast(4,5);
        //set(2,6);
        //System.out.println(contains(1));
        //System.out.println(contains(5));
        //System.out.println(contains(8));
        //remove(0);
        //clear();
        //resverList(dummyNode);
        KresverList(3,dummyNode);
        d.printf();
    }
}

package dataStruct;
/*
链表的反转和排序
 */
class Node2{
    int val;
    Node2 next;
    Node2(int x) { val = x; }

}
public class data5 {
    //排序
    public static Node2 sort(Node2 node){
        Node2 pre = node;
        Node2 cur = null;
        while(pre!=null){
            cur = pre.next;
            while(cur!=null){
                if(cur.val<pre.val){
                    int temp = cur.val;
                    cur.val = pre.val;
                    pre.val = temp;
                }
                cur = cur.next;
            }
            pre = pre.next;
        }
        return node;
    }

    //反转
    public static Node2 reverNode2(Node2 dummyNode){
        Node2 f = dummyNode.next;
        Node2 s = f.next;
        while(f.next!=null){
            f.next = s.next;
            s.next = dummyNode.next;
            dummyNode.next = s;
            s = f.next;
        }
        return dummyNode;
    }
    public static void main(String[] args) {
        Node2 dummyNode = new Node2(-1);
        Node2 a = new Node2(4);
        Node2 b = new Node2(5);
        Node2 c = new Node2(1);
        Node2 d = new Node2(3);
        Node2 e = new Node2(2);
        dummyNode.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        sort(a);
        reverNode2(dummyNode);
        for(Node2 temp = dummyNode.next; temp!=null; temp=temp.next){
            System.out.print(temp.val+" ");
        }
    }
}

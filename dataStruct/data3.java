package dataStruct;
/*
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
 */
class Node1 {
      int val;
      Node1 next;
      Node1(int x) { val = x; }
 }
public class data3 {
    public static Node1 reverseBetween(Node1 dummyNode, int m, int n) {
        Node1 first = dummyNode.next;
        Node1 last = dummyNode.next;
        for(int i=1; i<m; i++){
            first=first.next;
        }
        for(int i=0; i<n; i++){
            last = last.next;
        }
        Node1 f = first;
        Node1 s = f.next;
        while(f.next!=last.next){
            f.next = s.next;
            s.next = first.next;
            first.next = s;
            s = f.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        Node1 dummyNode = new Node1(-1);
        Node1 a = new Node1(1);
        Node1 b = new Node1(2);
        Node1 c = new Node1(3);
        Node1 d = new Node1(4);
        Node1 e = new Node1(5);
        dummyNode.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        reverseBetween(dummyNode,2,4);
        for(Node1 temp = a; temp!=null; temp=temp.next){
            System.out.print(temp.val+" ");
        }
    }
}

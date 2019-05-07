package dataStruct;
/*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
class Node {
     int val;
     Node next;
     Node(int x) { val = x; }
 }
public class data2 {
    public static Node swapPairs(Node head) {
        Node dummyNode = new Node(-1);
        dummyNode.next = head;
        head= dummyNode;
        while(head.next!=null&&head.next.next!=null){
            Node f = head.next;
            Node s = head.next.next;
            head.next = s;
            f.next = s.next;
            s.next = f;
            head =f;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        //Node e = new Node(5);
        a.next = b;
        b.next = c;
        c.next = d;
        //d.next = e;
        swapPairs(a);
        for(Node temp = a; temp!=null; temp=temp.next){
            System.out.print(temp.val+" ");
        }
    }
}

package NiuKeWang;
/*
链表基于某个值进行分割
 */

public class Demo25 {
    public static class Node{
        int val;
        Node next = null;
        public Node(int val){
            this.val = val;
        }
    }

    public static Node partLink(Node head,int x){
        if(head==null||head.next==null){
            return head;
        }
        Node minHead = new Node(-1);
        Node maxHead = new Node(-1);
        Node minH = minHead;
        Node maxH = maxHead;
        for(Node temp=head; temp!=null; temp=temp.next){
            if(temp.val<=x){
                minHead.next = new Node(temp.val);
                minHead = minHead.next;
            } else{
                maxHead.next = new Node(temp.val);
                maxHead = maxHead.next;
            }
        }
        minHead.next = maxH.next;
        return minH.next;
    }

    public static void main(String[] args) {
        Node a = new Node(4);
        Node b = new Node(7);
        Node c = new Node(9);
        Node d = new Node(3);
        Node e = new Node(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        Node node = partLink(a,5);
        for(Node temp = node; temp!=null; temp=temp.next){
            System.out.print(temp.val+" ");
        }
    }
}

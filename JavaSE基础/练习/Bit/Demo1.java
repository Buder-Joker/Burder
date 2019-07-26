package Bit;


//俩个链表按大小放在一块
class ListNode {
     int val;
    ListNode next;
     ListNode(int x) { val = x; }
 }
class Demo1 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node;
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<=l2.val){
            node = l1;
            node.next = mergeTwoLists(l1.next,l2);
        }else{
            node = l2;
            node.next = mergeTwoLists(l1,l2.next);
        }
        return node;

        }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l4= new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l4;
        l4.next = l3;
        ListNode l2 = new ListNode(1);
        ListNode l8= new ListNode(3);
        ListNode l9 = new ListNode(4);
        l2.next = l8;
        l8.next = l9;
        mergeTwoLists(l1,l2);
        ListNode rear = l1;
        while(rear!=null){
            System.out.print(rear.val+" ");
            rear = rear.next;
        }
    }
}

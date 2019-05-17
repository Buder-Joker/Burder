package dataStruct;
/*
在一个排序的节点中，存在重复的节点，请删除该链表中重复的节点，重复的节点不保留返回链表的
头指针。例如 1—>2->3->3->4->4->5  处理后为1->2->5;
 */
class Node3 {
    int data;
    Node3 next;

    Node3(int x) {
        data = x;
    }
}
// 1 2 3 3 3 4 5
public class data4 {
    //请删除该链表中重复的节点，重复的节点不保留
    public static Node3 deleteDuplication(Node3 cur){
        Node3 dummyNode = new Node3(-1);
        Node3 temp = dummyNode;
        while (cur!=null){
            //为何这个条件前后反转一下就好了
            if(cur.next!=null&&cur.data==cur.next.data){
                while(cur.next!=null&&cur.data==cur.next.data){
                    cur = cur.next;
                }
                cur =cur.next;
                dummyNode.next = cur;
            }else{
                dummyNode.next= cur;
                dummyNode=cur;
                cur=cur.next;
            }
        }
        return temp.next;
    }
    //删除已排序的重复元素只保留一个
    public static Node3 deleteRever(Node3 dummyNode){
        if(dummyNode.next==null){
            return null;
        }
        Node3 f = dummyNode.next;
        Node3 s = f.next;
        while(s!=null){
            while(true){
                if(f.data==s.data&&s.next==null){
                    f.next=null;
                }
                if(f.data==s.data&&s.next!=null){
                    f.next = s.next;
                    s = s.next;
                }else{
                    break;
                }
            }
            f = f.next;
            s = s.next;
        }
        return dummyNode.next;
    }
    public static void main(String[] args) {
        //Node3 dummyNode = new Node3(-1);
        Node3 a = new Node3(1);
        Node3 b = new Node3(2);
        Node3 c = new Node3(2);
        Node3 d = new Node3(3);
        Node3 e = new Node3(3);
        Node3 g = new Node3(4);
        Node3 h = new Node3(5);
        //dummyNode.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = g;
        g.next = h;
        Node3 ew = deleteDuplication(a);
        //deleteRever(dummyNode);
        for(Node3 temp =ew ; temp!=null; temp=temp.next){
            System.out.print(temp.data+" ");
        }
    }

}

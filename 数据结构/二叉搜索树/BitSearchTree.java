package dataStruct;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
二叉搜索树的基本操作
 */
public class BitSearchTree<E extends Comparable> implements Tree<E> {
    private Node root;
    private int size;
    private class Node{
        E data;
        Node left;
        Node right;
        public Node(E data){
            this.data = data;
        }
    }
    //增加结点
    public void add(E e){
        root = add(root,e);
    }
    public Node add(Node node,E e){
        if(node == null){
            Node newNode = new Node(e);
            size++;
            return newNode;
        }
        if(e.compareTo(node.data)>0){
            node.right = add(node.right,e);
        }
        if(e.compareTo(node.data)<0){
            node.left = add(node.left,e);
        }
        return node;
    }
    /* @Override
     public void add(E e) {
         if(root==null){
             Node newNode = new Node(e);
             root = newNode;
             size++;
         }
         //不为空的话递归寻找插入位置
         add(root,e);
     }
     private void add(Node root,E e){
         //插入的值刚好是树根节点的值
         if(e.compareTo(root.data)==0){
             return;
         }else if(e.compareTo(root.data)>0&&root.right==null){
             Node newNode = new Node(e);
             root.right = newNode;
             size++;
         }else if(e.compareTo(root.data)<0&&root.left==null) {
             Node newNode = new Node(e);
             root.left = newNode;
             size++;
         }else if(e.compareTo(root.data)>0){
             add(root.right,e);
         }else{
          add(root.left,e);
         }
     }*/
    //是否存在某个值
     @Override
   public boolean contain(E e) {
        if(root==null){
            return false;
        }
        //递归查找
        return contain(root,e);
    }
    private boolean contain(Node node,E e){
        if(node==null){
            return false;
        }
        /*if(node.data.equals(e)){
            return true;
        }*/
        if(e.compareTo(node.data)==0){
            return true;
        }else if(e.compareTo(node.data)>0){
            return contain(node.right,e);
        }else {
            return contain(node.left,e);
        }
    }
    //前序遍历
    @Override
    public void perOrder() {
        perOrder(root);
    }
    private void perOrder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.data+" ");
        perOrder(node.left);
        perOrder(node.right);
    }

    //中序遍历
    @Override
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
    //后序遍历
    @Override
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node ==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }
    //层式遍历非递归
    @Override
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        if(root==null){
            return;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data+" ");
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }

        }
    }
    //层式遍历递归实现(未实现)
    public void levelOrders(){
         levelOrders(root);
    }
    private void levelOrders(Node node){
         if(node==null){
             return;
         }
         while(true){
             System.out.print(node.data);
             if(node.left!=null){
                 levelOrders(node.left);
             }
             if(node.right!=null){
                 levelOrders(node.right);
             }
         }
    }
    //找到最小值,用循环实现
    @Override
    public E getMin() throws Exception{
        if(root==null){
            throw new Exception("结点为空");
        }
        return getMin(root).data;
    }
    private Node getMin(Node node){
         while(node.left!=null){
             node = node.left;
         }
         return node;
    }

    //找到最大值,用递归实现
    @Override
    public E getMax() throws Exception{
         if(root==null){
             throw new Exception("结点为空");
         }
        return getMax(root).data;
    }
    private Node getMax(Node node){
         if(node.right!=null){
             return getMax(node.right);
         }else{
             return node;
         }

    }
    //删除最小值
    @Override
    public E removeMin() {
         if(root==null){
             return null;
         }
        return removeMin(root).data;
    }
    public Node removeMin(Node node){
         Node minNode = getMin(node);
         if(node.left==minNode){
             node.left=null;
         }else {
             removeMin(node.left);
         }
         return minNode;
    }
    //删除最大值
    @Override
    public E removeMax() {
        if(root==null){
            return null;
        }
        return removeMax(root).data;
    }
    public Node removeMax(Node node){
         Node maxNode = getMax(node);
         if(node.right==maxNode){
             node.right = null;
         }else {
             removeMax(node.right);
         }
         return maxNode;
    }

    //删除某个值
    @Override
    public boolean remove(E e) {
        
        return false;
    }

    //大小
    @Override
    public int size() {
        return size;
    }

    //花式前序遍历输出
    public void perSearchTreeStruct(Node node, int depth, StringBuilder sb){
        if(node==null){
            sb.append("null"+"\n");
            return;
        }
        sb.append(perSearchTreeGang(depth)+node.data+"\n");
        perSearchTreeStruct(node.left,depth+1,sb);
        perSearchTreeStruct(node.right,depth+1,sb);

    }
    private String perSearchTreeGang(int depth){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<depth; i++){
            stringBuilder.append("--");
        }
        return stringBuilder.toString();
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        perSearchTreeStruct(root,0,res);
        return res.toString();
    }
}

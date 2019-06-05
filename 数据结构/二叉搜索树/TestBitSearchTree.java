package dataStruct;

public class TestBitSearchTree {
    public static void main(String[] args) throws Exception {
        BitSearchTree<Integer> bitSearchTree = new BitSearchTree<>();
        bitSearchTree.add(5);
        bitSearchTree.add(3);
        bitSearchTree.add(1);
        bitSearchTree.add(8);
        bitSearchTree.add(9);
        bitSearchTree.add(4);
        bitSearchTree.add(7);
        System.out.println(bitSearchTree.size());
        System.out.print("前序遍历:");
        bitSearchTree.perOrder();
        /*花式前序遍历输出
        System.out.println();
        System.out.println(bitSearchTree);*/

        System.out.println();
        System.out.print("中序遍历:");
        bitSearchTree.inOrder();
        System.out.println();
        System.out.print("后序遍历:");
        bitSearchTree.postOrder();
        System.out.println();
        System.out.print("层式遍历:");
        bitSearchTree.levelOrder();
        System.out.println();

        System.out.println(bitSearchTree.contain(4));
        System.out.println(bitSearchTree.contain(7));

        System.out.println(bitSearchTree.getMin());
        System.out.println(bitSearchTree.getMax());

        System.out.println("删除的最小值为:"+bitSearchTree.removeMin());
        System.out.println("删除的最大值为:"+bitSearchTree.removeMax());
        System.out.print("中序遍历:");
        bitSearchTree.inOrder();


    }
}

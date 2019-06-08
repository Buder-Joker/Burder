package dataStruct;


public class isSameTree {
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }
    //判断相同的子树
    public static boolean isSunZiTree(TreeNode s,TreeNode t){
       if(s==null){
           return false;
       }else{
           if(s.val==t.val){
               if(isSameTree(s,t)){
                   return true;
               }else{
                   return isSunZiTree(s.left,t)||isSunZiTree(s.right,t);
               }
           }
       }
        return false;
    }

    //判断相同的树
    public static boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}

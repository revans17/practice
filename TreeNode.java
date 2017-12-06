public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
     public boolean isLeaf(TreeNode node){
          if(node == null)
               return false;
          if(node.right == null && node.left == null)
               return true;
          return false; 
     }
}

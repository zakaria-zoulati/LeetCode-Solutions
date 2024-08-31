/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int solve( int curr ,  TreeNode root ){
        if( root.right == null && root.left == null ){
            return curr ;
        }
        int rs = 0 ; 
        if( root.right != null ){
            rs += solve( curr*2 + root.right.val , root.right  ) ; 
        }
        if( root.left != null ){
            rs += solve( curr*2 + root.left.val , root.left  ) ; 
        }
        return rs  ;
    }
    public int sumRootToLeaf(TreeNode root) {
       return solve( root.val ,  root ) ;
    }
}
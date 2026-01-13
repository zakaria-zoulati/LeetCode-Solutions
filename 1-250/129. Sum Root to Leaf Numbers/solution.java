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
    public int fill( TreeNode root , int curr  ){
        if( root.right == null && root.left == null ){
            return curr ; 
        }
        int rs = 0 ; 
        if( root.right != null ){
            rs += fill( root.right , curr*10 + root.right.val ) ; 
        }
        if( root.left != null ){
            rs += fill( root.left , curr*10 + root.left.val ) ; 
        }
        return rs ; 
    }
    public int sumNumbers(TreeNode root) { 
        int rs = fill( root , root.val  )  ; 
        return rs ; 
    }
}
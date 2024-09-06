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
    public int fill( TreeNode root , int n ){
        if( root == null) return 0; 
        int rs = 0 ; 
        if( root.val >= n ){
            rs++ ;
            n = root.val ;
        }
        rs += fill( root.right , n ) + fill( root.left , n ) ; 
        return rs ; 
    }
    public int goodNodes(TreeNode root) {
        int rs = 1 + fill( root.right , root.val ) + fill( root.left , root.val )   ;
        return rs ; 
    }
}
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
    public int find( TreeNode root , long curr , long t  ){
        int rs = 0; 
        if( curr == t ) rs++ ; 
        if( root.right != null ){
            rs += find( root.right , curr + root.right.val , t ); 
        }
        if( root.left !=null ){
            rs += find( root.left , curr + root.left.val , t ); 
        }
        return rs  ; 
    }
    public int traverseTree( TreeNode root , int t  ){
        if( root == null ) return 0  ;
        return find( root, root.val , t ) + traverseTree( root.right , t ) + traverseTree( root.left  , t ) ; 
    }
    public int pathSum(TreeNode root, int targetSum) {
        return traverseTree( root , targetSum ) ; 
    }
}
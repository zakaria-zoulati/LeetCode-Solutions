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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if( val >= root.val ){
            TreeNode rs = new TreeNode( val ) ; 
            rs.left = root ; 
            return rs ; 
        }
        if( root.right == null ){
            root.right = new TreeNode(val) ; 
            return root ; 
        }
        root.right = insertIntoMaxTree( root.right , val ) ;
        return root ; 
    }
}
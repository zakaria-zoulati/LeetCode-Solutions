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
    public void fill( TreeNode root , List<Integer> rs  ){
        if( root == null ) return ; 
        fill( root.left , rs  ) ; 
        rs.add( root.val ) ; 
        fill( root.right , rs ) ; 
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>() ; 
        fill( root , rs ) ;
        return rs ; 
     }
}
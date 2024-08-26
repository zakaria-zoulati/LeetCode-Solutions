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
    public TreeNode Other( TreeNode a , TreeNode b ){
        if( a == null && b == null ){
            return null ;
        }else if( a == null ){
            return b ; 
        }else {
            return a ; 
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if( root == null ){
            return null ; 
        }
        if( root.val == val ){
            return root ; 
        }
        return Other( searchBST(root.right,val)  , searchBST(root.left,val) ) ; 
   
    }
}
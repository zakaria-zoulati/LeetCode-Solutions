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
    public int sum( TreeNode root ){
       if( root == null ){
        return  0 ; 
       }
       int sum = 0 ;
       if( root.right != null ){
            sum += root.right.val ; 
       }
        if( root.left != null ){
            sum += root.left.val ; 
       }
       return sum ; 
    }
    public int sumEvenGrandparent(TreeNode root) {
        if( root == null ){
            return 0 ; 
        }
        if( root.right == null && root.left == null ){
            return 0 ; 
        }
        if( root.val % 2 == 0 ){
            return sum( root.right ) + sum( root.left ) + sumEvenGrandparent( root.right ) + sumEvenGrandparent( root.left ) ; 
        }
        return  sumEvenGrandparent( root.right ) + sumEvenGrandparent( root.left ) ;  
    }
}
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length ; 
        return recur( nums , 0 , n-1 ) ; 
    }
    public TreeNode recur( int[] nums , int s , int e ){
        if( e - s < 0 ){
            return  null ; 
        }
        int curr = -1 ; 
        int in = -1 ; 
        for( int i=s ; i<=e ; ++i ){
            if( nums[i] > curr ){
                curr = nums[i] ; 
                in = i ; 
            }
        }
        TreeNode root = new TreeNode( curr ) ; 
        root.left = recur( nums , s , in-1 ) ; 
        root.right = recur( nums , in+1 , e) ; 
        return root ; 
    }
}
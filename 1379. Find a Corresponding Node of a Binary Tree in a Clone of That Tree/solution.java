/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 class Solution {
    TreeNode rs  ; 
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs( cloned  , target.val  ) ; 
        return rs  ;
    }
    public void dfs( TreeNode root , int val ){
        if( root == null ) return  ; 
        if( root.val == val  ){
            rs = root ; 
            return  ; 
        }
        dfs( root.right , val ) ; 
        dfs( root.left , val ) ; 
    }
}
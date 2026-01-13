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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>() ; 
        Queue<TreeNode> helper = new LinkedList<>() ; 
        q.add( root ) ; 
        int index = 0 ; 
        while( !q.isEmpty()  ){
            if( index == 0 ){
                int min = Integer.MIN_VALUE ; 
                while( !q.isEmpty() ){
                    TreeNode p = q.poll() ; 
                    if( p.val <= min || p.val % 2 == 0 ) return false ; 
                    min = p.val ; 
                    helper.add( p ) ; 
                }
            }else {
                TreeNode start = q.poll() ; 
                if( start.val % 2 == 1 ) return false ; 
                helper.add( start ) ; 
                while( !q.isEmpty() ){
                    TreeNode p = q.poll() ; 
                    if( p.val >= start.val || p.val % 2 == 1 ) return false ; 
                    start = p ; 
                    helper.add( p ) ; 
                }
            }

            while( !helper.isEmpty() ){
                TreeNode curr = helper.poll() ; 
                if( curr.left != null ){
                    q.add( curr.left ) ; 
                }
                if( curr.right != null ){
                    q.add( curr.right ) ; 
                }
            }
            index ^= 1 ; 
        }
        return true ; 
     }
}
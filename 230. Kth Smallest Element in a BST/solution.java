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
    public void fill( PriorityQueue<Integer> pq , TreeNode root , int k ){
        if( root == null ){
            return ; 
        }
        if( pq.size() < k ){
            pq.add( root.val ) ; 
        }else if( pq.peek() > root.val ){
                pq.poll() ; 
                pq.add( root.val ) ; 
        }
        fill( pq , root.right , k ) ;
        fill( pq , root.left , k ) ;
    }
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b) -> b-a ) ; 
        fill( pq , root , k ) ; 
        return pq.peek() ; 
    }
}
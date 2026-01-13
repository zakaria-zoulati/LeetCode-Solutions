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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue< TreeNode > q = new ArrayDeque<>() ; 
        q.add( root ) ; 
        PriorityQueue< Long > pq = new PriorityQueue<>(  ) ;
        while( !q.isEmpty() ){
            int len = q.size() ; 
            long sum = 0 ; 
            for( int i=0 ; i<len ; ++i ){
                TreeNode curr = q.poll() ; 
                sum += curr.val ; 
                if( curr.right != null ){
                    q.add( curr.right ) ; 
                }
                if(  curr.left != null ){
                    q.add( curr.left ) ; 
                } 
            }

            pq.add( sum ) ; 
            if( pq.size() > k ){
                pq.poll() ; 
            }
        }

        if( pq.size() == k ) return  pq.peek() ; 
        return -1  ;
    }
}

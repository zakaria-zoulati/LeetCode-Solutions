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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> rs = new ArrayList<>() ; 
        if( root == null ) return rs ; 
        Queue<TreeNode> q = new ArrayDeque<>() ; 
        q.add( root ) ; 
        while( !q.isEmpty() ){
            int len = q.size() ; 
            int max = Integer.MIN_VALUE ; 
            for( int i=0 ; i<len ; ++i ){
                TreeNode curr = q.poll() ; 
                max = Math.max( max , curr.val ) ; 
                if( curr.left != null ){
                    q.add( curr.left ) ; 
                }
                if( curr.right != null ){
                    q.add( curr.right ) ; 
                }
            }
            rs.add( max ) ; 
        } 
        return rs ; 
    }
}
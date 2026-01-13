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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rs = new ArrayList<>() ; 
        bfs( root , rs , 0 ) ; 
        return rs ; 
    }
    public void bfs( TreeNode root , List<Integer> rs , int depth ){
        if( root == null ) return ; 
        if( rs.size() == depth ){
            rs.add( root.val ) ; 
        }else {
            rs.set( depth , root.val ) ; 
        }
        bfs( root.left , rs , depth +1  ) ; 
        bfs( root.right , rs , depth +1  ) ; 
    }
}
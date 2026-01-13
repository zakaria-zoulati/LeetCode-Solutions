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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>() ; 
        if( root == null ){
            return list ; 
        }
        Queue<TreeNode> q = new LinkedList<>() ; 
        q.add( root ) ; 
        while( !q.isEmpty() ){
            List<Integer> curr = new ArrayList<>() ; 
            int size = q.size() ; 
            while( size-- >0  ){
                TreeNode inter = q.poll() ; 
                curr.add( inter.val ) ; 
                if( inter.left != null ){
                    q.add( inter.left ) ; 
                }
                if( inter.right != null ){
                    q.add( inter.right ) ; 
                }.
            }
            list.add( curr ) ; 
        }
        Collections.reverse( list ) ; 
        return list ;  

    }
}
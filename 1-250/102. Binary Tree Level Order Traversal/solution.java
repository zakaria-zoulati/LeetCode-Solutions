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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>() ; 
        if( root == null ){
            return list ; 
        }
        Queue<TreeNode> q = new LinkedList<>() ; 
        q.add( root ) ; 
        while( !q.isEmpty() ){
            List<Integer> inter = new ArrayList<>() ; 
            int size  = q.size() ; 
            while( size-->0 ){
                TreeNode item = q.poll() ;
                inter.add( item.val ) ; 
                if( item.left != null ){
                    q.add( item.left ) ; 
                }
                if( item.right != null ){
                    q.add( item.right ) ; 
                }
            }
            list.add( inter ) ; 
        }

        return list; 

    }
}
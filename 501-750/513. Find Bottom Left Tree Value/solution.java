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
    public int findBottomLeftValue(TreeNode root) {
        int curr = root.val ; 
        Queue<TreeNode> q = new ArrayDeque<>() ; 
        q.add( root ) ; 
        while( !q.isEmpty() ){
            int len = q.size() ; 
            TreeNode first = q.poll() ; 
            curr = first.val ; 
            if( first.left != null ){
                q.add( first.left ) ; 
            }
            if( first.right != null ){
                q.add( first.right ) ; 
            }
            for(int i=1 ; i<len ; ++i){
                TreeNode node = q.poll() ; 
                if( node.left != null ){
                    q.add( node.left ) ; 
                }
                if( node.right != null ){
                    q.add( node.right ) ; 
                }
            }
        }
        return curr ; 
    }
}
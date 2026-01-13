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
    public void fill( List<Integer> list , TreeNode root ){
        if( root == null ){
            return  ;
        }
        fill( list , root.left ) ; 
        list.add( root.val ) ; 
        fill( list , root.right ) ; 
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>() ; 
        fill( list , root1 ) ; 
        fill( list , root2 ) ; 
        Collections.sort( list ) ; 
        return list ; 
    }
}
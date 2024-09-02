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
    public void fill( List<List<Integer>> rs , List<Integer> inter , int curr , TreeNode root , int t ){
        if( root.right == null && root.left == null  ){
            if( curr == t ) rs.add(inter) ; 
            return  ; 
        }
        if( root.right != null && root.left != null ){
            List<Integer> r = new ArrayList<>(inter) ; 
            r.add( root.right.val ) ; 
            fill( rs , r  , curr+root.right.val,root.right , t  ) ; 
            List<Integer> l = new ArrayList<>(inter) ; 
            l.add( root.left.val ) ; 
            fill( rs , l  , curr+root.left.val, root.left , t  )  ;
        }
        else if( root.right != null ){
            inter.add( root.right.val) ; 
            fill( rs , inter , curr+root.right.val , root.right , t ) ; 
        }else {
            inter.add( root.left.val) ; 
            fill( rs , inter , curr+root.left.val , root.left , t ) ; 
        }
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> rs = new ArrayList<>() ; 
        if( root == null ) return rs  ;
        List<Integer> start = new ArrayList<>() ;
        start.add( root.val ) ; 
        fill( rs , start , root.val , root , targetSum  ) ; 
        return rs ;
    }
}
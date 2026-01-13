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
    public void insert( TreeNode root1 , TreeNode root2 ){
        if( root1 == null ){
            return ; 
        }
        if( root1.val <= root2.val ){
            if( root2.left == null ){
                root2.left = new TreeNode( root1.val ) ; 
                return ; 
            }else {
                insert( root1 , root2.left ) ; 
            }
        }else {
            if( root2.right == null ){
                root2.right = new TreeNode( root1.val ) ;  
                return ; 
            }else {
                insert( root1 , root2.right ) ; 
            }
        }
    }
    public void complete( TreeNode root1 , TreeNode root2 ){
        if( root1 == null ) return ; 
        insert( root1 , root2 ) ;   
        complete( root1.right , root2 ) ; 
        complete( root1.left , root2 ) ; 
    }
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
        if( root2 == null ){
            root2 = root1 ; 
        }else {
            complete( root1 , root2 ) ; 
        }
        fill( list , root2 ) ; 
        return list ; 
    }
}
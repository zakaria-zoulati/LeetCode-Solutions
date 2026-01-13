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
    public TreeNode deleteNode(TreeNode root, int key) {
        if( root == null ){
            return root ; 
        }
        // If the root have the key 
        if( root.val == key ){
            if( root.right == null && root.left == null ){
                return null ; 
            }else if( root.right == null ){
                return root.left ; 
            }else if( root.left == null ){
                return root.right ; 
            }else{
                TreeNode leftMost = leftMost( root.right ) ; 
                TreeNode left = root.left ; 
                root = root.right ; 
                leftMost.left = left ; 
                return root ; 
            }
        }
        search( root , key ) ; 
        return root ; 
        
    }
    public TreeNode leftMost( TreeNode root ){
        while( root.left != null ){
            root = root.left ; 
        }
        return root ; 
    }
    public void search( TreeNode root , int key ){
        if( root.left != null ){
            if( root.left.val == key ){
                root.left = deleteNode( root.left , key ) ; 
                return ; 
            }
            search( root.left , key ) ; 
        }
        if( root.right != null ){
            if( root.right.val == key ){
                root.right = deleteNode( root.right , key ) ; 
                return ; 
            }
            search( root.right , key ) ; 
        }
    }
}
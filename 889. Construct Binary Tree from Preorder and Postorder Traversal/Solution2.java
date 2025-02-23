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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return construct( preorder , postorder , 0 , 0 , preorder.length ) ; 
    }
    public TreeNode construct( int[] preorder , int[] postorder , int preStart , int postStart , int size ){
        if( size == 0 ) return null ; 
        TreeNode root = new TreeNode( preorder[preStart] ) ; 
        if( size == 1 ) return root ; 
        int i=0 ; 
        while( postorder[ postStart+i ] != preorder[ preStart +1 ] ) ++i ; 
        int len = i+1 ; 
        root.left  = construct( preorder , postorder ,  preStart+1 , postStart , len ) ; 
        root.right = construct( preorder , postorder , preStart+len+1  ,  postStart+len , size - len -1 ) ; 
        return root ; 
    }
}
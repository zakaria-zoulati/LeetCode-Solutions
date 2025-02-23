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
        int n = preorder.length ; 
        if( n == 0 ){
            return null ; 
        }
        TreeNode root = new TreeNode( preorder[0] ) ; 
        if( n == 1 ){
            return root ; 
        }
        int i=0 ; 
        for(  ; i<n ; ++i ){
            if( postorder[i] == preorder[1] ){
                break ; 
            }
        }
        int[] leftPost = new int[ i+1 ] ; 
        int[] leftPreOrder = new int[i+1] ; 
        for( int j=0 ; j<=i ; ++j ){
            leftPost[j] = postorder[j] ; 
        }  
        for( int j=1  ; j<=i+1 ; ++j ){
            leftPreOrder[j-1] = preorder[j] ; 
        }
        root.left = constructFromPrePost(  leftPreOrder , leftPost ) ; 
        int len = n - (i+2) ; 
        if( len > 0 ){
            int[] rightPost = new int[ len ] ; 
            int[] rightPreOrder = new int[ len ] ; 
            for( int j=n-len ; j<n ; ++j ){
                rightPreOrder[j- (n-len) ] = preorder[j] ; 
            }
            for( int j=n-len-1 ; j<n-1 ;++j ){
                rightPost[j - (n-len-1) ] = postorder[j] ; 
            }
            root.right = constructFromPrePost( rightPreOrder , rightPost ) ; 
        }
        return root ; 
    }
}
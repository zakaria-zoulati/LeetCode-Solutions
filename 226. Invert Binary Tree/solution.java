class Solution {
    public TreeNode invertTree(TreeNode root) {
        if( root==null || ( root.right == null && root.left == null )  ){
            return root ;
        }
        if( root.left == null ){
            root.left = invertTree( root.right ) ; 
            root.right = null ; 
            return root ; 
        }

        if( root.right == null ){
            root.right = invertTree(  root.left ) ; 
            root.left = null ; 
            return root ; 
        }

        TreeNode inter = root.right ; 
        root.right = invertTree( root.left ) ; 
        root.left = invertTree( inter ) ; 
        return root ; 

    }
}
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0 ;
        }
        if(root.right==null && root.left==null){
            return 1;
        }
        else if(root.right==null){
            return 1 + maxDepth(root.left) ;
        }
        else if(root.left==null){
            return 1 + maxDepth(root.right) ;
        }
        return (int) Math.max(1+maxDepth(root.right) , 1+maxDepth(root.left)) ;
    }
}
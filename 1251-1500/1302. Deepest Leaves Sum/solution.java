class Solution {
    public int depth( TreeNode root ){
        if( root == null ){
            return 0 ; 
        }else {
            return 1 + Math.max( depth(root.right) , depth(root.left)  ) ; 
        }
    }
    
    public int calcul( TreeNode root , int depth , int current ){
        if( root != null ){
             current++ ;
            if( depth == current ){
                return root.val ; 
            }else {
                return calcul( root.right , depth , current ) + calcul( root.left , depth , current ) ; 
            }

        }
        return  0 ; 
       
    }
    public int deepestLeavesSum(TreeNode root) {
        int depth = depth(root) ; 
        int rs = calcul( root , depth  , 0 ) ; 
        return rs ; 
     }
}
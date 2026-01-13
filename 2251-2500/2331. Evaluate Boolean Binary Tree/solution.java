class Solution {
    public boolean evaluateTree(TreeNode root) {
        if( root.val == 1  ) return true  ;
        if( root.val == 0  ) return false  ;
        if( root.val == 2  ){
            return  evaluateTree( root.right ) || evaluateTree( root.left ) ;
        }
         return  evaluateTree( root.right ) && evaluateTree( root.left ) ;
    }
}
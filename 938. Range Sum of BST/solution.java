class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if( root == null ){
            return 0 ; 
        }
        int sum = 0 ; 
        if( root.val <= high && root.val >= low  ){
            sum += root.val +  rangeSumBST( root.right , low , high ) + rangeSumBST( root.left , low , high ) ; 
        }
        else if( root.val > high ){
            sum += rangeSumBST( root.left , low , high) ;
        }
        else {
            sum += rangeSumBST( root.right , low, high) ;
        }

        return sum ; 

    }
}
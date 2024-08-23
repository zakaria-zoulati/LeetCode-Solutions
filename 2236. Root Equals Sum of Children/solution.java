class Solution {
    public boolean checkTree(TreeNode root) {
        return root.val == root.right.val + root.left.val ; 
    }
}
class Solution {
    int maxHeight = 0;
    public int getDiameter(TreeNode root){
        if(root == null)
            return 0;

        int leftHeight = getDiameter(root.left);
        int rightHeight = getDiameter(root.right);

        maxHeight = Math.max(maxHeight, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return maxHeight;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 class Solution {
    TreeNode result = null;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null) {
            return null;
        }
        if(original == target) return cloned;
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if(left != null) {
            return left;
        }
        return getTargetCopy(original.right, cloned.right, target);
    }
}
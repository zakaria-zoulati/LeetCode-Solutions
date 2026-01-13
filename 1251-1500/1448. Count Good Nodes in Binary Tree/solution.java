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
    public int minDiffInBST(TreeNode root) {
        
        List<Integer> values = new ArrayList<>();
        inOrder(root, values);
        int result = Integer.MAX_VALUE;

        for(int i = 0; i < values.size() - 1; i++) {
            result = Math.min(result, values.get(i+1) - values.get(i));
        }
        return result;
    }

    public  void inOrder(TreeNode node, List<Integer> values) {
        if(node == null) {
            return;
        }
        inOrder(node.left, values);
        values.add(node.val);
        inOrder(node.right, values);

    }
}
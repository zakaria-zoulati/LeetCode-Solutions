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
    int res=0;
    int maxdepth=0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return res;
    }
    public void dfs(TreeNode root,int depth){
        if(root==null){
            return;
        }
        depth=depth+1;
        if(root.left==null && root.right==null){
            if(maxdepth<depth){
                res=root.val;
                maxdepth=depth;
            }
        }
        dfs(root.left,depth);
        dfs(root.right,depth);
    }
}
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
    public void dfs(TreeNode root,int lvl,List<Integer>res){
        if(root==null) return ;
        if(lvl==res.size()) res.add(root.val);
        else res.set(lvl,Math.max(root.val,res.get(lvl)));
        dfs(root.left,lvl+1,res);
        dfs(root.right,lvl+1,res);
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        dfs(root,0,res);
        return res;    
    }
}
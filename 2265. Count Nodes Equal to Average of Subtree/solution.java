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
    public int[] traverse( TreeNode root   ){
        int[] arr = new int[3] ; 
        if( root == null ){
            return arr ; 
        }
        arr[0] = root.val ; 
        arr[1] = 1 ; 
        int[] r = traverse( root.right ) ; 
        int[] l = traverse( root.left  ) ; 
        arr[0] += r[0] + l[0] ; 
        arr[1] += r[1] + l[1] ; 
        arr[2] += r[2] + l[2] ; 

        if( root.val == ( arr[0] )/arr[1] ){
            arr[2]++  ; 
        }
        return arr ; 
    }
    public int averageOfSubtree(TreeNode root) {
        return traverse( root  )[2] ; 
    }
}
/**
 * Definition for a binary tree node.
 */
// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        int n = traversal.length(); 
        if (n == 0) {
            return null; 
        }
        int i = 0; 
        int num = 0; 
        while (i < n && traversal.charAt(i) != '-') {
            num = num * 10 + (traversal.charAt(i) - '0'); 
            i++;
        }
        TreeNode root = new TreeNode(num); 
        if (i == n) return root; 
        int count = 0; 
        while (i < n && traversal.charAt(i) == '-') {
            count++; 
            i++; 
        }
        int start = i ; 
        int j = n; 
        for (int k = start; k < n; ++k) {
            if (traversal.charAt(k) == '-') {
                int curr = 1; 
                while (k + 1 < n && traversal.charAt(k + 1) == '-') {
                    k++; 
                    curr++; 
                }
                if (curr == count) {
                    j = k + 1; 
                    break; 
                }
            }
        }
        if (j != n) {
            root.left = recoverFromPreorder(traversal.substring(start , j - count)); 
            root.right = recoverFromPreorder(traversal.substring(j, n)); 
        } else {
            root.left = recoverFromPreorder(traversal.substring(start, n)); 
        }
        return root; 
    }
}

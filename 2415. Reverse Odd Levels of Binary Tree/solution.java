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
    public TreeNode reverseOddLevels(TreeNode root) {
        TreeNode[] ele = new TreeNode[ 1<<12 + 1 ] ; 
        int in = 0 ; 
        boolean flag = false ; 
        ele[in] = root ; 
        while( true ){
            if( flag ){
                int left = 0 ; 
                int right = in ; 
                while( left <= right ){
                    swap( ele[left++] , ele[right--] ) ; 
                } 
            }
            if( ele[0].left == null ){
                break ; 
            }
            int next = in*2 + 1 ;
            int ne = next  ;
            while( in >= 0 ){
                TreeNode curr = ele[in--] ; 
                ele[ne--] = curr.right ; 
                ele[ne--] = curr.left ; 
            }
            in = next ; 
            flag = !flag ; 
        }
        return root ; 
    }

    public void swap( TreeNode a , TreeNode b ){
        int temp = a.val ; 
        a.val = b.val ; 
        b.val = temp ;
    }
}
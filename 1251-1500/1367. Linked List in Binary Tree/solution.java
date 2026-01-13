/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean check( ListNode head , TreeNode root ){
        if( head == null ){
            return true ; 
        }
        if( root == null ){
            return false ; 
        }
        if( root.val == head.val ){
            return check( head.next , root.right ) || check( head.next , root.left ) ;
        }
        return false ; 
    }
    public boolean traverse( ListNode head , TreeNode root ){
        if( head == null ){
            return true ; 
        }
        if( root == null ){
            return false ; 
        }
        return check( head , root ) || traverse( head , root.right ) || traverse( head , root.left  ) ; 
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        return traverse( head , root ) ;
    }
}
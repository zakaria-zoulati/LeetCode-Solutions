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
class Solution {
    public int pairSum(ListNode head) {
        int rs = 0 ; 
        int size = 0 ;
        ListNode helper = head ; 
        while( helper != null ){
            size++ ; 
            helper = helper.next ; 
        } 
        int[] all = new int[size/2] ; 
        int co = 0 ; 
        helper = head ; 
        while( co != size/2 ){
            all[co++] = helper.val ; 
            helper = helper.next ; 
        }
        while( helper != null ){
            rs = Math.max( rs , all[ size-1 - co ] + helper.val ) ; 
            co++ ; 
            helper = helper.next ; 
        }

        return rs ; 

    }
}
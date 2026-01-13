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
    public boolean isCritical( int a , int b , int c ){
        if( b>a && b>c ) return true ;
        if( b<a && b<c ) return true ; 
        return false ; 
    }
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if( head.next == null || head.next.next == null ){
            return new int[]{ -1 , -1 } ; 
        }
        int prev = head.val ; 
        int first_ind = -1 ; 
        int prev_ind = -1 ;
        int d = Integer.MAX_VALUE ; 
        int ind = 1 ; 
        head = head.next ; 
        while( head.next != null ){
            if( isCritical( prev , head.val , head.next.val ) ) {
                if( first_ind == -1 ){
                    first_ind = ind ; 
                }else {
                    d = Math.min( d , ind - prev_ind ) ; 
                }
                prev_ind = ind ; 
            }
            ind++ ; 
            prev = head.val ; 
            head = head.next ; 
        }
        if( d == Integer.MAX_VALUE ){
            return new int[]{ -1 , -1 } ; 
        }
        return new int[]{ d , prev_ind - first_ind } ; 
    }
}
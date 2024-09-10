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
    public int gcd( int a , int b  ){
        while( b != 0 ){
            int temp =  a ; 
            a = b ; 
            b = temp%b ;
        }
        return a ; 
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head ; 
        ListNode next = head.next ; 
        while( curr != null && next != null ){
            int mid_v = gcd( curr.val , next.val ) ; 
            ListNode mid = new ListNode( mid_v ) ; 
            curr.next = mid ;
            mid.next = next ; 
            curr = next ; 
            next = curr.next ; 
        }
        return head ; 
    }
}
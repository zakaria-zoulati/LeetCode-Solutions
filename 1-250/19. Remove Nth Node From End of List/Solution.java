class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode right = head ; 
        ListNode left = head ; 
        while( n-- > 0 ){
            right = right.next ; 
        }
        if( right == null ){
            return head.next; 
        }
        while( right.next != null ){
            right = right.next ; 
            left = left.next ; 
        }
        left.next = left.next.next ;
        return head ; 
    }
}
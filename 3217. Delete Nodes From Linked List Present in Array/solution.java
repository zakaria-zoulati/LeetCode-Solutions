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
    public ListNode modifiedList(int[] nums, ListNode head) {
        int n = nums.length ; 
        HashSet<Integer> set = new HashSet<>(n) ; 
        for( int num : nums ){
            set.add( num ) ;
        } 
        while( head != null &&  set.contains( head.val )  ){
            head = head.next ;
        }
        if( head == null ){
            return null ; 
        }
        ListNode helper = head ; 
        while( helper != null &&  helper.next != null ){
            if( set.contains( helper.next.val ) ){
                helper.next = helper.next.next ; 
            }else{
                helper = helper.next ; 
            }
        }
        return head ; 
    }
}
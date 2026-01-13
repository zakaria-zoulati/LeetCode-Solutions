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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int count = 0 ; 
        ListNode helper = list1 ; 
        ListNode secondPart = null ; 
        while( true ){
            if( count == a-1 ){
                secondPart = helper ; 
                while( count != b+1 ){
                  secondPart = secondPart.next ; 
                  count++ ; 
                }
                helper.next = list2 ; 
                while( helper.next !=  null ){
                    helper = helper.next ; 
                }
                helper.next = secondPart ; 
                break ; 
            }else {
                helper = helper.next ; 
                count++ ; 
            }
        }
        return list1 ; 
    }
}
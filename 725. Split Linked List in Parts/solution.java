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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] rs = new ListNode[k] ; 
        int len = 0 ; 
        ListNode helper = head ; 
        while( helper != null ){
            len++ ; 
            helper = helper.next ; 
        }
        int por = len/k ; 
        int rem = len%k ; 
        helper = head ; 
        for(int i=0 ; i<k && len>0 ; ++i){
            rs[i] = helper ; 
            for(int j=0 ; j< por+( rem>0 ?1:0 ) -1 ; ++j ){
                helper = helper.next ; 
            }
            len -= por+( rem>0 ?1:0 ) ; 
            if( rem >0 ) rem-- ; 
            ListNode temp = helper.next ; 
            helper.next = null ; 
            helper = temp ; 
        }
        
        return rs; 

    }
}
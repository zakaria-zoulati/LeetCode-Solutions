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
    public int str( String s ){
        int rs = 0 ; 
        int n = s.length() ; 
        for(int i=0 ; i<n ; ++i){
            rs += ( 1 << n-1-i )*( s.charAt(i) - '0') ; 
        }
        return rs ; 
    }
    public int getDecimalValue(ListNode head) {
        StringBuilder inter = new StringBuilder() ; 
        while( head != null ){
            inter.append( head.val ) ; 
            head = head.next ; 
        }
        return str( inter.toString() ) ; 
    }
}
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>() ; 
        Stack<Integer> s2 = new Stack<>() ; 
        ListNode h1 = l1 ; 
        ListNode h2 = l2 ; 
        while( h1 != null ){
            s1.push( h1.val ) ; 
            h1 = h1.next ; 
        }
        while( h2 != null ){
            s2.push( h2.val ) ; 
            h2 = h2.next ; 
        }
        int cache = 0 ; 
        ListNode back = null ; 
        ListNode curr = null ; 
        while( !s1.isEmpty() && !s2.isEmpty() ){
            int a = s1.pop() ; 
            int b = s2.pop() ; 
            curr = new ListNode(( a + b + cache) % 10 ) ; 
            cache = ( a + b + cache)/10 ; 
            curr.next = back ; 
            back = curr ; 
        }
        while( !s1.isEmpty() ){
            int a = s1.pop() ; 
            curr = new ListNode( ( a  + cache ) % 10 ) ; 
            cache = ( a  + cache )/10 ; 
            curr.next = back ; 
            back = curr ;  
        }

        while( !s2.isEmpty() ){
            int b = s2.pop() ; 
            curr = new ListNode( ( b + cache ) % 10 ) ; 
            cache = ( b + cache )/10 ; 
            curr.next = back ; 
            back = curr ;  
        }
        if( cache == 1 ){
            curr = new ListNode(1) ; 
            curr.next = back ; 
        }
        return curr ; 
    }
}
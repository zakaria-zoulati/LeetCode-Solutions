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
    public ListNode addTwoNumbers(ListNode h1, ListNode h2) {
        int i = 0 ; 
        int j = 0 ; 
        int[] s1 = new int[101] ; 
        int[] s2 = new int[101] ;  
        while( h1 != null ){; 
            s1[ i++ ] = h1.val ; 
            h1 = h1.next ; 
        }
        while( h2 != null ){
            s2[ j++ ] = h2.val ; 
            h2 = h2.next ; 
        }
        int cache = 0 ; 
        ListNode back = null ; 
        ListNode curr = null ; 
        while( i>0 && j>0 ){
            curr = new ListNode(( s1[i-1] + s2[j-1] + cache) % 10 ) ; 
            cache = ( s1[i-1] + s2[j-1] + cache)/10 ; 
            curr.next = back ; 
            back = curr ; 
            i-- ; 
            j-- ; 
        }
        while( i>0 ){
            curr = new ListNode( ( s1[i-1]  + cache ) % 10 ) ; 
            cache = ( s1[i-1]  + cache )/10 ; 
            curr.next = back ; 
            back = curr ;  
            i-- ; 
        }

        while( j>0 ){
            curr = new ListNode( ( s2[j-1] + cache ) % 10 ) ; 
            cache = ( s2[j-1] + cache )/10 ; 
            curr.next = back ; 
            back = curr ;  
            j-- ; 
        }
        if( cache == 1 ){
            curr = new ListNode(1) ; 
            curr.next = back ; 
        }
  
        return curr ; 
    }
}
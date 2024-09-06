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
    public ListNode removeNodes(ListNode head) {
        int[] arr = new int[100001] ; 
        int curr = 0 ; 
        ListNode helper = head ; 
        while( helper != null  ){
            arr[curr++] = helper.val ; 
            helper = helper.next ;  
        }
        for(int i=curr-2 ; i>=0 ; --i){
            if( arr[i+1] > arr[i] ){
                arr[i] = arr[i+1] ; 
            }
        }

        int i = 0 ; 
        while( head != null && arr[i] > head.val ){
            head = head.next ; 
            i++ ; 
        }
        i++ ;
        helper = head ;
        while( helper != null && helper.next != null ){
            if( helper.next.val < arr[i] ){
                helper.next = helper.next.next ; 
            }else {
                helper = helper.next ;
            }
            i++ ;
        }
        
        return head ; 



    }
}
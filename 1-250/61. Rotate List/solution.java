class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        
        ListNode p = head;
        ArrayList<ListNode> arr = new ArrayList<ListNode>();
        
        while (p != null) {
            arr.add(p);
            p = p.next;
        }
        
        k = k % arr.size();
        if (k == 0) {
            return head;
        }
        
        ListNode newHead = arr.get(arr.size() - k);
        ListNode newTail = arr.get(arr.size() - k - 1);
        ListNode oldTail = arr.get(arr.size() - 1);
        
        oldTail.next = head;
        newTail.next = null;
        
        return newHead;
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length ; 
        int[] rs = new int[n-k+1] ; 
        Deque<Integer> dequeue = new LinkedList<>();
        for( int i=0 ; i<k ; ++i ){
            while( !dequeue.isEmpty() && nums[dequeue.peekLast() ] < nums[i] ){
                dequeue.removeLast() ; 
            }
            dequeue.addLast( i ) ; 
        }
        rs[0] = nums[ dequeue.peekFirst() ] ; 
        for( int i=k ; i<n ; ++i ){
            while( !dequeue.isEmpty() && dequeue.peekFirst()  <= i-k  ){
                dequeue.removeFirst() ; 
            }
            while( !dequeue.isEmpty() && nums[ dequeue.peekLast() ] < nums[i] ){
                dequeue.removeLast() ; 
            }
            dequeue.addLast( i ) ;
            rs[i-k+1] =  nums[ dequeue.peekFirst() ] ; 
        }
        return rs ;
    }
}
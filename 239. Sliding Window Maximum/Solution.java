class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length ; 
        int[] rs = new int[n-k+1] ; 
        Deque<int[]> dequeue = new LinkedList<>();
        for( int i=0 ; i<k ; ++i ){
            while( !dequeue.isEmpty() && dequeue.peekLast()[0] < nums[i] ){
                dequeue.removeLast() ; 
            }
            dequeue.addLast( new int[] { nums[i] , i } ) ; 
        }
        rs[0] = dequeue.peekFirst()[0] ; 
        for( int i=k ; i<n ; ++i ){
            while( !dequeue.isEmpty() && dequeue.peekFirst()[1] <= i-k  ){
                dequeue.removeFirst() ; 
            }
            while( !dequeue.isEmpty() && dequeue.peekLast()[0] < nums[i] ){
                dequeue.removeLast() ; 
            }
            dequeue.addLast( new int[]{ nums[i] , i } ) ;
            rs[i-k+1] = dequeue.peekFirst()[0] ; 
        }
        return rs ;
    }
}
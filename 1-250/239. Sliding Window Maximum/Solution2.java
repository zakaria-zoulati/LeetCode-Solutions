class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length ; 
        int[] rs = new int[n-k+1] ; 
        int[] deq = new int[n+1]; 
        int start = -1 ; 
        int end = -1 ;  
        for( int i=0 ; i<k ; ++i ){
            while( start != end  && nums[ deq[end] ] < nums[i] ){; 
                end-- ; 
            }
            deq[++end] = i ; 
        } 
        rs[0] = nums[ deq[ start+1 ] ] ; 
        for( int i=k ; i<n ; ++i ){
            while( start != end && deq[start+1] <= i-k  ){
                start++ ; 
            }
            while( start != end && nums[ deq[end] ] < nums[i] ){
                end-- ; 
            }
            deq[++end] = i ;
            rs[i-k+1] = nums [deq[ start+1 ] ] ; 
        }
        return rs ;
    }
}
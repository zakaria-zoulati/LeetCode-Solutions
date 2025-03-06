class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length ; 
        int[] rs = new int[n-k+1] ; 
        int[][] deq = new int[n+1][2]; 
        int start = -1 ; 
        int end = -1 ;  
        for( int i=0 ; i<k ; ++i ){
            while( start != end  && deq[end][0] < nums[i] ){; 
                end-- ; 
            }
            deq[++end] = new int[] { nums[i] , i } ; 
        } 
        rs[0] = deq[ start+1 ][0] ; 
        for( int i=k ; i<n ; ++i ){
            while( start != end && deq[start+1][1] <= i-k  ){
                start++ ; 
            }
            while( start != end && deq[end][0] < nums[i] ){
                end-- ; 
            }
            deq[++end] = new int[] { nums[i] , i } ; 
            rs[i-k+1] = deq[ start+1 ][0] ; 
        }
        return rs ;
    }
}
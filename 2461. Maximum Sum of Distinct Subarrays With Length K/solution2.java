class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length ; 
        long rs = 0L ; 
        long sum = 0L ; 
        int m = 0 ; 
        for( int i : nums ){
            m = Math.max( i , m ) ; 
        }
        int[] f = new int[m+1] ; 
        int e = 0 ; 
        for( int i=0 ; i<k ; ++i){
            if( f[ nums[i] ]++ == 0 ) ++e ; 
            sum += nums[i] ; 
        }
        if( e == k ) rs = sum ; 
        for( int i=k ; i<n ; ++i ){
            sum -= nums[i-k] ; 
            sum += nums[i] ; 
            if( f[ nums[i-k] ]-- == 1 ) e-- ; 
            if( f[ nums[i] ]++ == 0 ) e++ ; 
            if( e == k ){
                rs = Math.max( rs , sum ) ;
            }
        }
        return rs ; 
    }
}
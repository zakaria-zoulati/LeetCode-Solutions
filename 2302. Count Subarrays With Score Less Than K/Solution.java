class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length ; 
        long rs = 0 ; 
        long sum = 0 ;
        int start = 0 ;  
        for( int i=0 ; i<n ; ++i ){
            sum += nums[i] ; 
            while( sum*( i - start +1 ) >= k ){
                sum -= nums[start++] ; 
            }
            rs += i-start+1 ; 
        }
        return rs ; 
    }
}
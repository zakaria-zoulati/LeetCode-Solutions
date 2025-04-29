class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length ; 
        long rs = 0 ; 
        int max = -1 ; 
        int count = 0 ; 
        int start = 0 ;  
        for( int i=0 ; i<n ; ++i ){
            if( nums[i] > max ){
                start = i ; 
                count = 1 ; 
                max = nums[i] ; 
                rs = 0 ; 
            }else if( nums[i] == max ){
                count++ ; 
            }
            if( count >= k  ){
                while( count > k ) {
                    if( nums[start] == max ) count-- ; 
                    start++ ; 
                }
                while( nums[start] != max ) start++ ; 
                rs += start + 1 ; 
            }
        }
        return rs ; 
    }
}
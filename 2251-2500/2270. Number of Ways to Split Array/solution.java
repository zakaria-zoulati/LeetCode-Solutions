class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length ; 
        long sum = 0L ; 
        for( int i : nums ){
            sum += i ; 
        }
        long curr = 0L ; 
        int rs = 0 ; 
        for( int i=0 ; i<n-1 ; ++i ){
            curr += nums[i] ;
            sum -= nums[i] ; 
            if( curr >= sum ){
                ++rs ;
            }
        }
        return rs  ;
    }
}
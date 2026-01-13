class Solution {
    public long largestPerimeter(int[] nums) {
        int n = nums.length ; 
        long rs = -1 ; 
        Arrays.sort(nums) ; 
        long curr =  nums[0] + nums[1] ; 
        for( int i=2 ; i<n ; ++i ){
            if( nums[i] < curr ){
                rs = curr + nums[i] ; 
            }
            curr += nums[i] ; 
        }
        return rs ; 
    }
}
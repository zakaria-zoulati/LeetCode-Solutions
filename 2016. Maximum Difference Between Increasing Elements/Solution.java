class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length ; 
        int right = nums[n-1] ; 
        int rs = 0 ; 
        for( int i=n-2 ; i>=0 ; --i ){
            rs = Math.max( rs , right - nums[i] ) ; 
            right = Math.max( right , nums[i] ) ; 
        }
        return rs==0 ? -1 : rs ; 
    }
}
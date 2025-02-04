class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length ; 
        int rs = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            int curr = nums[i] ; 
            while( i+1<n && nums[i+1] > nums[i] ){
                i++ ; 
                curr += nums[i] ; 
            }
            rs = Math.max( rs , curr ) ; 
        }
        return rs ; 
    }
}
class Solution {
    public int countSubarrays(int[] nums) {
        int rs = 0 ;
        int n = nums.length ; 
        for( int i=1 ; i+1<n ; ++i ){
            if( nums[i]%2 == 0 && nums[i+1] + nums[i-1] == nums[i] / 2 ){
                rs++ ; 
            }
        }
        return rs ; 
    }
}
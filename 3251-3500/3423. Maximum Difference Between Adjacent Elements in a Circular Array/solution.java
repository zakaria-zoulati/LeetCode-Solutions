class Solution {
    public int maxAdjacentDistance(int[] nums) {
         int n = nums.length ; 
         int rs = 0 ; 
         for( int i=0 ; i<n ; ++i ){
             rs = Math.max( rs , Math.abs( nums[(i+1)%n] - nums[i] ) ) ;
         }
        return rs ; 
    }
}
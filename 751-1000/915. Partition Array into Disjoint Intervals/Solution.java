class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length ; 
        int max = nums[0] ; 
        int curr = 0 ; 
        int ma = nums[0] ; 
        for( int i=1 ; i<n ; ++i ){
            if( nums[i] < max ){
                curr = i ; 
                max = ma ; 
            }else {
                ma = Math.max( ma , nums[i] ) ; 
            }
        }
        return curr+1 ; 
    }
}
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length ; 
        while( k-- > 0 ){
            int in = 0 ; 
            int val = nums[0] ;
            for( int i=1 ; i<n ; ++i ){
                if( nums[i] < val ){
                    val = nums[i] ; 
                    in = i ; 
                }
            }
            nums[in] *= multiplier ; 
        }
        return nums ; 
    }
}
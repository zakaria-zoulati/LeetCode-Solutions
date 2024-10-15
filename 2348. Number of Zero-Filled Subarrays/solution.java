class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long rs = 0L ; 
        int n = nums.length ; 
        int count = 0; 
        for( int i=0 ; i<n ; ++i ){
            if( nums[i] == 0 ){
                count = 1 ; 
                while( i+1<n && nums[i+1] == 0 ){
                    ++i ; 
                    count++ ; 
                }
                rs += (long) count*(count+1)/2 ; 
                ++i ; 
            }
        }
        return rs ; 
    }
}
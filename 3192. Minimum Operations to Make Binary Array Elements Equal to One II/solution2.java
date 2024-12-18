class Solution {
    public int minOperations(int[] nums) {
        int prev = nums[0] ; 
        int p = 1 - prev ; 
        for( int i : nums ){
            if( i != prev ){
                ++p ; 
                prev=i;
            }
        } 
        return p ; 
    }
}
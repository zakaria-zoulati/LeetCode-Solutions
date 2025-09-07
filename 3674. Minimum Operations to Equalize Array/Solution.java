class Solution {
    public int minOperations(int[] nums) {
         for( int i=1 ; i<nums.length ; ++i ){
             if( nums[i] != nums[i-1] ) return 1 ; 
         }
        return 0 ; 
    }
}
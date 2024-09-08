class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length ; 
        int all = 0 ; 
        for(int i=1 ; i<n ; ++i){
            nums[i] ^= nums[i-1] ; 
        }
        int right = n-1 ; 
        int left = 0; 
        while( left < right ){
            int temp = nums[right] ; 
            nums[right] = nums[left] ; 
            nums[left] = temp ; 
            left++ ; 
            right-- ; 
        }

        for(int i=0 ; i<n ; ++i){
            nums[i] ^=  ( ( 1 << maximumBit ) - 1 ) ; 
        }
        return nums ; 
    }
}
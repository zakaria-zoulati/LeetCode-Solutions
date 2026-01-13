class Solution {
    public int[] transformArray(int[] nums) {
        int n = nums.length ; 
        int evens = 0 ; 
        for( int i : nums ){
            if( i % 2 == 0 ){
                evens++ ; 
            }
        }
        for( int i=0 ; i<n ; ++i ){
            if( evens-- > 0 ){
                nums[i] = 0 ; 
            }else{
                nums[i] = 1; 
            }
        }
        return nums;  
    }
}
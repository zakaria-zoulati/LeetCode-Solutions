class Solution {
    public int minOperations(int[] nums) {
        int rs = 0 ; 
        int n = nums.length ; 
        for(int i=0; i+2<n ; ++i){
            if( nums[i] == 0 ){
                nums[i+1] ^= 1 ;  
                nums[i+2] ^= 1 ;
                ++rs ; 
            }
        }
        if( nums[n-1] == 1 && nums[n-2] == 1 ){
            return rs ; 
        }
        return -1 ; 
    }
}
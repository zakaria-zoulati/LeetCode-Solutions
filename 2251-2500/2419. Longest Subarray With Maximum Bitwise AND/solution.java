class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length ; 
        int rs = 1 ; 
        int max = 0 ; 
        for(int i=0 ; i<n ; ++i){
            if( nums[i] > max ){
                max = nums[i] ; 
            }
        }
        int len = 0 ;
        for(int i=0 ; i<n ; ++i){
            while( i<n && ( nums[i] & max  ) == max ){
                i++ ; 
                len++ ; 
            }
            rs = Math.max( len , rs ) ; 
            len = 0 ; 
        }
        return rs ; 
    }
}
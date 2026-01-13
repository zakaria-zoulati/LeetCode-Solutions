class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length ; 
        long rs = 0 ; 
        int in = 0 ; 
        int in1 = -1 ; 
        int in2 = -1 ; 
        for( int i=0 ; i<n ; ++i ){
            if( nums[i] > maxK || nums[i] < minK ) {
                in = i + 1 ; 
                in1 = -1 ; 
                in2 = -1 ;
                continue; 
            }
            if( nums[i] == minK ){
                in1 = i ; 
            } 
            if( nums[i] == maxK ){
                in2 = i ; 
            }
            if( in1 != -1 && in2 != -1 ){
                int pos = Math.min( in1 , in2 ) ; 
                rs += pos - in + 1 ; 
            }
        }  
        return rs ; 
    }
}
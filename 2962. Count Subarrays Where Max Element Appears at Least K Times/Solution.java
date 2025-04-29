class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length ; 
        long rs = 0 ; 
        int max = -1 ; 
        int count = 0 ; 
        int start = 0 ;  
        int[] q = new int[n] ; 
        int in = 0 ; 
        int p = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            if( nums[i] > max ){
                start = i ; 
                count = 1 ; 
                max = nums[i] ; 
                p = 0 ; 
                in = 0 ; 
                rs = 0 ; 
            }else if( nums[i] == max ){
                q[in++] = i ; 
                count++ ; 
            }
            if( count > k ){
                start = q[p++] ;  
                count-- ; 
                rs += start + 1 ; 
            }else if( count == k ){
                rs += start + 1; 
            }
        }
        return rs ; 
    }
}
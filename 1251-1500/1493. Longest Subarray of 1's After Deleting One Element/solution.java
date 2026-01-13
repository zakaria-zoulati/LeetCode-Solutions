class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length ; 
        int i=0 ; 
        int curr = 0 ; 
        int zeros = 0 ; 
        while( i<n && nums[i] == 1 ){
            ++i ; 
            ++curr ; 
        }
        if( i == n ){
            return n-1 ; 
        }
        int rs = curr ; 
        for( ; i<n ; ){
            zeros = 0 ; 
            while( i<n && nums[i] == 0 ){
                ++zeros ; 
                ++i ; 
            }
            if( zeros > 1 ) curr = 0 ; 
            int count = 0 ; 
            while( i<n && nums[i] == 1 ){
                ++count ; 
                ++i ; 
            }
            rs = Math.max( rs , count + curr ) ; 
            curr = count  ; 
        }
        return rs ; 
    }
}
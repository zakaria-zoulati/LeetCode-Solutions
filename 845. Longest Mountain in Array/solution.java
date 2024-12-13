class Solution {
    public int longestMountain(int[] nums) {
        int n = nums.length ; 
        if( n < 3 ) return 0 ; 
        int start = 0 ; 
        boolean flag = true ; 
        int rs = 0 ; 
        for( int i=1 ; i<n ; ++i ){
            while( i<n && nums[i] == nums[i-1] ){
                ++i ; 
                start = i ; 
            }
            while( i<n && nums[i] <= nums[i-1] ){
                ++i ;  
                start = i; 
            }
            int up = 0 ; 
            start = i ; 
            while( i<n && nums[i] > nums[i-1] ){
                ++i ; 
                up++ ; 
            }
            if( up == 0 ) continue ; 
            int dow = 0 ; 
            while( i<n && nums[i] < nums[i-1] ){
                ++i ; 
                dow++; 
            }
            if( dow == 0 ) continue ; 
            rs = Math.max( rs , up+dow+1 ) ; 
            --i ; 
        }
        if( rs < 3 ){
            return 0 ; 
        }
        return rs ; 
    }
}
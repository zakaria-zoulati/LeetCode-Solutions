class Solution {
    public int longestMountain(int[] nums) {
        int n = nums.length ; 
        if( n < 3 ) return 0 ; 
        int rs = 0 ; 
        for( int i=1 ; i<n ;  ){
            while( i<n && nums[i] == nums[i-1] ){
                ++i ; 
            }
            while( i<n && nums[i] <= nums[i-1] ){
                ++i ;  
            }
            int up = 0 ; 
            while( i<n && nums[i] > nums[i-1] ){
                ++i ; 
                ++up ; 
            }
            if( up == 0 ) continue ; 
            int dow = 0 ; 
            while( i<n && nums[i] < nums[i-1] ){
                ++i ; 
                dow++; 
            }
            if( dow == 0 ) continue ; 
            rs = Math.max( rs , up+dow+1 ) ; 
        }
        if( rs < 3 ){
            return 0 ; 
        }
        return rs ; 
    }
}
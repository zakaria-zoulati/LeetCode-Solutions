class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length ; 
        int max = -1 ; 
        for( int i=0 ; i<n ; ++i ){
            int b = Integer.bitCount( nums[i] ) ; 
            int mi = nums[i] ; 
            int ma = nums[i] ; 
            while( i+1 <n && Integer.bitCount( nums[i+1] ) ==b ){
                ++i ; 
                if( nums[i] < mi ){
                    mi = nums[i] ; 
                }else if( nums[i] > ma ){
                    ma = nums[i] ; 
                }
            }
            if( mi < max ) return false  ; 
            max = ma ; 
        }
        return true ; 
    }
}

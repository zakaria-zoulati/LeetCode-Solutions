class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length ; 
        for( int i=n-1 ; i>=1 ; --i ){
            nums[i] -= nums[i-1] ; 
        }
        int q = queries.length ; 
        for( int i=0 ; i<q ; ++i ){
            int l = queries[i][0] ; 
            int r = queries[i][1] ; 
            nums[l]-- ; 
            if( r+1 < n ){
                nums[r+1]++ ; 
            }
        }
        if( nums[0] > 0 ) return false ; 
        for( int i=1 ; i<n ; ++i ){
            nums[i] += nums[i-1] ;
            if( nums[i] > 0 ) return false ; 
        }
        return true ; 
    }
}
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length ; 
        int[] diff = new int[n] ; 
        diff[0] = nums[0] ; 
        for( int i=1 ; i<n ; ++i ){
            diff[i] = nums[i] - nums[i-1] ;
        }
        int q = queries.length ; 
        for( int i=0 ; i<q ; ++i ){
            int l = queries[i][0] ; 
            int r = queries[i][1] ; 
            diff[l]-- ; 
            if( r+1 < n ){
                diff[r+1]++ ; 
            }
        }
        for( int i=1 ; i<n ; ++i ){
            diff[i] += diff[i-1] ;
        }
        for( int i=0 ; i<n ; ++i ){
            if( diff[i] > 0 ) return false ; 
        }
        return true ; 
    }
}
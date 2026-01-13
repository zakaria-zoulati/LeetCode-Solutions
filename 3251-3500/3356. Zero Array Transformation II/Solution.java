class Solution {
    public boolean isValid( int[] nums , int[][] queries , int[] diff ,  int limit ){
        int n = nums.length ; 
        for( int i=0 ; i<=limit ; ++i ){
            diff[ queries[i][0] ] -= queries[i][2] ; 
            if( queries[i][1] + 1 < n ){
                diff[ queries[i][1] + 1 ] += queries[i][2] ; 
            }
        }
        // recovers and checks 
        if( diff[0] > 0 ) return false ; 
        for( int i=1 ; i<n ; ++i ){
            diff[i] += diff[i-1] ; 
            if( diff[i] > 0 ) return false ; 
        }
        return true ; 
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length ; 
        int m = queries.length ; 
        // Edge case 
        int zeros = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            if( nums[i] == 0 ){
                zeros++ ; 
            }else break ;
        }
        if( zeros == n ) return 0 ; 
        int[] diff = new int[n] ; 
        diff[0] = nums[0] ; 
        for( int i=1 ; i<n ; ++i ){
            diff[i] = nums[i] - nums[i-1] ; 
        }
        int l = 0 ; 
        int r = m-1 ; 
        while( l < r ){
            int mid = l + ( r - l )/2 ; 
            if( isValid( nums , queries, diff.clone() ,  mid ) ){
                r = mid  ; 
            }else {
                l = mid + 1 ; 
            }
        }
        
        if( isValid( nums , queries , diff.clone() ,  r ) ){
            return r+1 ; 
        }

        return -1 ; 
    }
}
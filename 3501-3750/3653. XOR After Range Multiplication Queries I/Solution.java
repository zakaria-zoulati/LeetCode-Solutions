class Solution {
    public int xorAfterQueries(int[] nums, int[][] qq) {
        int n = nums.length ; 
        int q = qq.length ; 
        int mod = 1_000_000_007 ; 
        long[] arr = new long[n] ; 
        for( int i=0 ; i<n ; ++i) {
            arr[i] = nums[i] ; 
        }
        for( int i=0 ; i<q ; ++i ){
            int l = qq[i][0] ; 
            int r = qq[i][1] ; 
            int k = qq[i][2] ; 
            int v = qq[i][3] ; 
            for( int j=l ; j<=r ; j += k ){
                arr[j] = ( arr[j] * v ) % mod ; 
            }
        }
        long rs = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            rs ^= arr[i] ; 
        }
        return (int) rs ; 
    }
}
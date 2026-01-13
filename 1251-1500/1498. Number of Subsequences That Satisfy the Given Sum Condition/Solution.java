class Solution {
    public int numSubseq(int[] nums, int target) {
        long rs = 0;  
        int n = nums.length ; 
        int mod = 1_000_000_007 ; 
        Arrays.sort( nums ) ;
        int[] pw = new int[n] ; 
        pw[0] = 1 ; 
        for( int i=1 ; i<n ; ++i ){
            pw[i] = ( pw[i-1]*2 ) % mod ; 
        }
        int l=0 , r=n-1;
        while( l<=r ){
            if( nums[l] + nums[r] <= target ){
                rs=(rs + pw[r-l] )%mod ; 
                l++ ; 
            }else {
                r-- ; 
            }
        }
        return (int) rs ;
    }
}
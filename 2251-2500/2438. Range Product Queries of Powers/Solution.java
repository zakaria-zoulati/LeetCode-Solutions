class Solution {
    int mod = 1_000_000_007 ; 
    public int[] productQueries(int n, int[][] queries) {
        int q = queries.length ;
        int[] rs = new int[q] ; 
        int curr = n ; 
        int p = 0 ;  
        while( curr > 0 ){
            curr -= curr&-curr ; 
            p++ ; 
        }
        curr = n ; 
        long[] powers = new long[p] ; 
        for( int i=0 ; i<p; ++i ){
            powers[i] = curr&-curr ;
            curr -= curr&-curr ; 
        } 
        long[][] pref = new long[p][p] ; 
        for( int i=0 ; i<p ; ++i ){
            pref[i][i] = powers[i] ; 
            for( int j=i+1 ; j<p ; ++j ){
                pref[i][j] = (pref[i][j-1]*powers[j])%mod; 
            }
        }
        for( int i=0 ; i<q ; ++i ){
            int start = queries[i][0] ; 
            int end = queries[i][1] ;
            rs[i] = (int) pref[start][end] ; 
        }
       return rs ;  
    }
}
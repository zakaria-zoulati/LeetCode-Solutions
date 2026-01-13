class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long rs = 0L ; 
        int[] f = new int[n] ; 
        int[] fr = new int[n] ; 
        fr[0] = n ; 
        for( int[] r : roads ){
            f[r[0]]++ ; 
            f[r[1]]++ ; 
        }
        for( int i : f ){
            fr[i]++ ; 
        }
        for( int i=n-1 ; i>=1; --i){
            while( i>0 && fr[i] == 0 ){
                i-- ; 
            }
            if( i == 0 ) break ; 
            if( fr[i] > 0 ){
                long c = (long) fr[i]*(fr[i] - 1 )/2 ; 
                rs += (long) i*( (long) fr[i]*n - c ) ; 
                n -= fr[i] ; 
            }
        }
        return rs ;
    }
}
class Solution {
    public long maximumOr(int[] a, int k) {
        int n = a.length;
        if( n == 1 ){
            long e = a[0] ; 
            return e << k ; 
        }
        int[] r = new int[n] ;  
        r[n-1] = a[n-1] ; 
        for( int i=n-2 ; i>0 ; --i ){
            r[i] |= r[i+1] ; 
            r[i] |= a[i] ; 
        }
        long e = r[1] ; 
        long rs =( e | ( (long) a[0] << k ) ) ; 
        long pref = a[0] ; 
        for( int i=1 ; i<n-1 ; ++i ){
            rs = Math.max( rs , ( pref | r[i+1] | ( (long) a[i] << k))) ; 
            pref |= a[i] ; 
        }
        rs = Math.max( rs , pref|( (long) a[n-1] << k  ) ) ; 
        return rs ; 
    }
}

class Solution {
    public long numOfSubsequences(String s) {
        int n = s.length() ; 
        int[][] pref = new int[n+1][2] ; 
        int[][] suff = new int[n+2][2] ; 
        for( int i=1 ; i<=n ; ++i ){
            for( int j=0 ; j<2 ; ++j ){
                pref[i][j] = pref[i-1][j] ; 
            }
            if( s.charAt(i-1) == 'L' ){
                pref[i][0]++ ; 
            }
            if( s.charAt(i-1) == 'C' ){
                pref[i][1] += pref[i-1][0] ; 
            }
        }
        for( int i=n ; i>=1 ; --i ){
            for( int j=0 ; j<2 ; ++j ){
                suff[i][j] = suff[i+1][j] ; 
            }
            if( s.charAt(i-1) == 'T' ){
                suff[i][0]++ ; 
            }
            if( s.charAt(i-1) == 'C' ){
                suff[i][1] += suff[i+1][0] ; 
            }
        }
        long rs = 0 ; 
        for( int i=2 ; i<=n-1 ; ++i ){
            if( s.charAt(i-1) == 'C' ){
                rs += pref[i-1][0]*suff[i+1][0] ; 
            }
        }
        long c = 0 ; 
        for( int i=1 ; i<=n ; ++i ){
            c = Math.max( c , suff[i][1] ) ; 
            c = Math.max( c ,(long) pref[i-1][0]*suff[i][0] ) ; 
            c = Math.max( c ,pref[i-1][1] ) ; 
        }
        c = Math.max( c , pref[n][1] ) ; 

        return rs + c ; 
    }
}
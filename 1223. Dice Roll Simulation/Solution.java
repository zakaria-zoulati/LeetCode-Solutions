class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int mod = 1_000_000_007 ; 
        long[][][] dp = new long[n][6][] ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<6 ; ++j ){
                dp[i][j] = new long[ rollMax[j] + 1 ] ;  
            }
        }
        for( int i=0 ; i<6 ; ++i ){
            dp[0][i][1] = 1;  
        }
        for( int i=1 ; i<n ; ++i ){
            long prev = 0;
            for( int j=0 ; j<6 ; ++j ){
                for( int k=1 ; k<=rollMax[j] ; ++k ){
                    prev = ( prev + dp[i-1][j][k] ) % mod ; 
                }
            }
            for( int j=0 ; j<6 ; ++j ){
                long curr = prev; 
                for( int k = 1 ; k<=rollMax[j]; ++k ){
                    curr = ( curr - dp[i-1][j][k] ) % mod ;
                }
                dp[i][j][1] = ( curr + mod ) % mod ; 
                for( int k=2 ; k<=rollMax[j] ; ++k ){
                    dp[i][j][k] = ( dp[i-1][j][k-1] ) % mod ; 
                }
            }
        }
        long rs = 0 ; 
        for( int i=0 ; i<6 ; ++i ){
            for( int j=1 ; j<=rollMax[i] ; ++j ){
                rs = ( rs + dp[n-1][i][j] ) % mod ; 
            }
        }
        return (int) rs ;
    }
}
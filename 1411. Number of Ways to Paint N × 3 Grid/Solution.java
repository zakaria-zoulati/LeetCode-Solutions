class Solution {
    static int mod = 1_000_000_007 ; 
    static int[][] trans = new int[12][12] ; 
    static { 
        int[][] cases = new int[12][3] ; 
        int in = 0 ; 
        for( int i=0 ; i<3 ; ++i ){
            for( int j=0 ; j<3 ; ++j ){
                for( int k=0 ; k<3 ; ++k ){
                    if( i != j && j != k ){
                        cases[in][0] = i ; 
                        cases[in][1] = j ; 
                        cases[in][2] = k ;
                        in++ ;  
                    }
                }
            }
        }
        for( int i=0 ; i<12 ; ++i ){
            for( int j=i+1 ; j<12 ; ++j ){
                if( check( cases[i] , cases[j] ) ){
                    trans[i][j] = 1; 
                    trans[j][i] = 1; 
                }
            }
        } 
    }
    static boolean check( int[] a , int[] b ){
        return a[0] != b[0] && a[1] != b[1] && a[2] != b[2] ; 
    }
    public int numOfWays(int n) {
        int[] dp = new int[12] ;  
        Arrays.fill( dp , 1 ) ;  
        for( int i=1 ; i<n ; ++i ){
            int[] curr = new int[12] ; 
            for( int j=0 ; j<12 ; ++j ){ 
                for( int k=j+1 ; k<12 ; ++k ){
                    if( trans[j][k] == 1 ){
                        curr[j] = ( curr[j] + dp[k] ) % mod ; 
                        curr[k] = ( curr[k] + dp[j] ) % mod ; 
                    }
                }
                dp[j] = curr[j] ; 
            }
        }
        int ans = 0 ; 
        for( int i=0 ; i<12 ; ++i ){
            ans = ( ans + dp[i] ) % mod ; 
        }
        return ans ; 
    }   
}
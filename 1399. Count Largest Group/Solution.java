class Solution {
    public int countLargestGroup(int n) {
        if( n <= 9 ){
            return n ; 
        }
        int[] dp = new int[n+1] ;
        int[] f = new int[37] ;  
        for( int i=1 ; i<10 ; ++i ){
            dp[i] = i ; 
            f[i] = 1 ;
        }
        for( int i=10 ; i<=n ; ++i ){
            dp[i] = dp[ i/10 ] + i%10 ; 
            f[ dp[i] ]++ ; 
        }
        int count = 0 ; 
        int top = 0 ; 
        for( int i : f ) {
            if( i > top ){
                count = 1 ; 
                top = i ; 
            }else if( i == top ){
                count++ ; 
            }
        }
        return count ; 
    }
}
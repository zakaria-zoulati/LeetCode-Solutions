class Solution {
    public int numDecodings(String s) {
        int n = s.length() ; 
        long[] dp = new long[n+1] ; 
        long mod = 1_000_000_007 ; 
        dp[n] = 1; 
        if( s.charAt(n-1) != '0' ){
            dp[n-1] = s.charAt(n-1)=='*'?9:1 ; 
        }
        for( int i=n-2 ; i>=0 ; --i ){
            char c = s.charAt(i) ; 
            if( c == '0' ){
                continue ; 
            }
            if( c == '*' ){
                dp[i] = ( 9*dp[i+1] ) % mod ; 
                dp[i] = ( dp[i] + ( s.charAt(i+1)=='*' ? 9*dp[i+2] : dp[i+2]  )) % mod ; 
                if( s.charAt(i+1) == '*' ){
                    dp[i] = ( dp[i] + 6*dp[i+2] ) % mod ; 
                }else if( s.charAt(i+1) < '7' ){
                    dp[i] = ( dp[i] + dp[i+2] ) % mod ; 
                }
            }else if( c > '2' ){
                dp[i] = dp[i+1] ; 
            }else if( c == '1' ){
                dp[i] = dp[i+1] ; 
                dp[i] = ( dp[i] +( s.charAt(i+1)=='*'?9*dp[i+2] : dp[i+2]) ) % mod ; 
            }else {
                dp[i] = dp[i+1] ;
                if( s.charAt(i+1) == '*' ){
                    dp[i] = ( dp[i] + 6*dp[i+2] ) % mod ;
                }else if( s.charAt(i+1) < '7' ){
                    dp[i] = ( dp[i] + dp[i+2] ) % mod ; 
                }
            }
        }
        return (int) dp[0] ; 
    }
}
class Solution {
    public int numDecodings(String s) {
        int n = s.length() ; 
        int rs = 0 ; 
        int[] dp = new int[n+1] ;
        dp[n] = 1 ;  
        dp[n-1] = ( s.charAt(n-1) == '0' ? 0 : 1 ) ;  
        for( int i=n-2 ; i>=0 ; --i ){
            char c = s.charAt(i) ;  
            if( c == '0') { 
                dp[i] = 0 ; 
            }else if( c > '2' ){
                dp[i] = dp[i+1];
            }else if( c == '1' ){
                dp[i] = dp[i+1] + dp[i+2] ;   
            }else if( s.charAt(i+1) <= '6' ){
                dp[i] = dp[i+1] + dp[i+2] ; 
            }else {
                dp[i] = dp[i+1] ; 
            }
        }
        return dp[0] ; 
    }
}
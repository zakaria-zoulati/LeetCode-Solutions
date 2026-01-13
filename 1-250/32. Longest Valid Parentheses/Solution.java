class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length() ; 
        int[] dp = new int[n] ; 
        char[] chars = s.toCharArray(); 
        int rs = 0 ; 
        for( int i=1 ; i<n ; ++i ){
            if( chars[i] == ')' ){
                if( chars[i-1] == '(' ){
                    dp[i] = 2 + ( i >= 2 ? dp[i-2] : 0 ) ; 
                }else if( i - dp[i-1] > 0 && chars[( i - dp[i-1] -1 )] == '(' ) {
                    dp[i] = dp[i-1] + 2 + (( i-dp[i-1]-2 >=0 ) ? dp[ i-dp[i-1]-2 ] : 0) ; 
                }
                rs = Math.max( rs , dp[i] ) ; 
            }
        }
        return rs ; 
    }
}
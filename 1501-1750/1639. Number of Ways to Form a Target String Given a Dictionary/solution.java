class Solution {
    public int numWays(String[] words, String t) {
        int n = t.length() ;
        int m = words.length ; 
        int len = words[0].length() ; 
        int mod = 1_000_000_007 ; 
        int[][] f = new int[len][26];
        // filling the frequency array of the i column of all words  
        for( String in : words ){
            for( int i=0 ; i<len ; ++i ){
                ++f[i][in.charAt(i)-'a'] ; 
            }
        }
        long[][] dp = new long[n+1][len+1] ;
        for( int i=0 ; i<len+1 ; ++i ){
            dp[0][i] = 1 ; 
        } 
        // The number dp[i][j] represents the number of target( 0 , i ) till The len = j in words 
        for( int i=1 ; i<=n ; ++i ){
            for( int j=i ; j<=len ; ++j ){
                dp[i][j] = ( dp[i][j-1] + f[j-1][t.charAt(i-1) - 'a']*dp[i-1][j-1] )% mod ; 
            }
        }
        return (int) dp[n][len] ; 
    }
}
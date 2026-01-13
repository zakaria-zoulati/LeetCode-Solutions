class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length() ; 
        int m = text2.length() ; 
        char[] c1 = text1.toCharArray() ; 
        char[] c2 = text2.toCharArray() ; 
        int[][] dp = new int[n+1][m+1] ; 
        for( int i=n-1 ; i>=0 ; --i ){
            for( int j=m-1 ; j>=0 ; --j ){
                if( c1[i] == c2[j] ){
                    dp[i][j] = 1 + dp[i+1][j+1] ; 
                }else{
                    dp[i][j] = Math.max( dp[i][j+1] , dp[i+1][j] ) ; 
                }
            }
        }
        return dp[0][0] ; 
    }
}
class Solution {
    public int countVowelStrings(int n) {
        int[][] dp  = new int[n+1][5] ; 
        dp[1][0] = 1 ; 
        dp[1][1] = 1 ; 
        dp[1][2] = 1 ; 
        dp[1][3] = 1 ; 
        dp[1][4] = 1 ; 
        for(int i=2 ; i<=n ; ++i){
            int a = dp[i-1][0] ; 
            int b = dp[i-1][1] ; 
            int c = dp[i-1][2] ; 
            int d = dp[i-1][3] ; 
            int e = dp[i-1][4] ;
            for(int j=0 ; j<5 ; ++j){
                dp[i][j] += a; 
            } 
            for(int j=1 ; j<5 ; ++j){
                dp[i][j] += b; 
            } 
            for(int j=2 ; j<5 ; ++j){
                dp[i][j] += c; 
            } 
            for(int j=3 ; j<5 ; ++j){
                dp[i][j] += d; 
            } 
            for(int j=4 ; j<5 ; ++j){
                dp[i][j] += e; 
            } 
        }

        int rs  = dp[n][0] +  dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4] ;
        return rs ;

    }
}
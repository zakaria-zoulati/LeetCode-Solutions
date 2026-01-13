class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1] ; 
        for( int i=1 ; i<=amount ; ++i ){
            dp[i] = amount+1 ; 
        }
        for( int i : coins ){
            for( int j=i ; j<=amount ; ++j ){
                dp[j] = Math.min( dp[j] , dp[j-i] + 1 ) ; 
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
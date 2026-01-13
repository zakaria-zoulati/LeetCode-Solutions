class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1] ; 
        dp[0] = 0 ; 
        for( int i=1 ; i<=amount ; ++i ){
            dp[i] = Integer.MAX_VALUE - 1 ; 
            for( int j : coins ){
                if( i >= j  ){
                    dp[i] = Math.min( dp[i] , dp[i-j] +1 ) ; 
                }
            }
        }  
        if( dp[amount] == Integer.MAX_VALUE - 1  ){
            return -1 ; 
        }
        return dp[amount] ; 
    }
}
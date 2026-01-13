class Solution {
    int top  = Integer.MAX_VALUE ; 
    public int insert( int coin , int[] dp , int position  ){
        int n = dp.length ; 
        if( position - coin < 0 ){
            return top  ; 
        }
        if( dp[position - coin] == 0 ){
            return top ;
        }else {
            return dp[position-coin]+1 ; 
        }
    }
    public int coinChange(int[] coins, int amount) {
    if( amount ==0  ){
        return 0 ; 
    }
     Arrays.sort(coins) ; 
     if( amount < coins[0] ) return -1 ;
     int n = coins.length ; 
     int len = amount + 1;
     int[] dp = new int[len] ; 
     for(int i=0;i<n && coins[i]<len ; ++i ){
        dp[ coins[i] ] = 1;
     }
    for(int i=coins[0]+1 ; i<=amount;++i){
        if( dp[i] != 0  ) continue ;
        dp[i] = top ; 
        for(int j=0; j<n ; ++j){
            dp[i] = Math.min(insert( coins[j] , dp , i ) , dp[i] ) ; 
        }
        if( dp[i] == top ){
            dp[i] = 0 ; 
        }
    }
    if( dp[amount] == 0 ){
        return -1 ; 
    } 
    return dp[amount] ; 
    }
}
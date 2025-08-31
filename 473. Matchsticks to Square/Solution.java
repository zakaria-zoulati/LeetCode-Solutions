class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length ;
        if( n < 4 ) return false ; 
        int sum = 0 ;
        for( int i : matchsticks ){
            sum += i ; 
        }
        if( sum % 4 != 0 ) return false ; 
        int tar = sum / 4 ; 
        int all = ( 1 << n ) - 1; 
        int[] dp = new int[all+1] ;
        for( int mask = 1; mask <= all ; mask++ ){
            int curr = 0 ;
            for( int i=0 ; i<n ; ++i ){
                if( ( mask & ( 1 << i ) ) > 0 ){
                    curr += matchsticks[i] ; 
                    dp[mask] = Math.max( dp[mask] , dp[mask^(1<<i)] ) ; 
                }
            }
            if( curr % tar == 0 ){
                dp[mask]++ ; 
            } 
        }  
        return dp[all] == 4 ; 
    }
}
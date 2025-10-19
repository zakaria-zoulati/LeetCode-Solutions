class Solution {
    Integer[][] dp ; 

    public int countArrangement(int n) {
        dp = new Integer[n+1][1<<n] ; 
        return helper( n , 1 , 0 ) ; 
    }

    public int helper( int n , int ind , int mask ){
        if( ind > n ) return 1; 
        if (dp[ind][mask] != null) return dp[ind][mask] ; 

        int count = 0 ; 
        for( int i=1 ; i<=n ; ++i ){
            if( (ind%i==0||i%ind==0) && ( mask & ( 1<<(i-1) ) ) == 0 ){
                count += helper( n , ind+1 , mask | ( 1 << (i-1) ) ) ; 
            }
        }
        
        return dp[ind][mask] = count ; 
    }
}
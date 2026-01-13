class Solution {
    int getPosition( int[] stones , int n , int tar){
        if( tar > stones[n-1] ) return -1 ; 
        int l = 0 ; 
        int r = n-1 ; 
        while( l <= r ){
            int mid = l + ( r - l )/2 ; 
            if( stones[mid] == tar ){
                return mid ; 
            }else if( stones[mid] > tar ){
                r = mid - 1 ; 
            }else {
                l = mid + 1 ; 
            }
        }
        return -1 ; 
    }
    public boolean canCross(int[] stones) {
        int n = stones.length ; 
        if( stones[1] - stones[0] != 1 ) return false;
        if( stones[n-1] > stones[0] + n*(n-1)/2 ) return false ; 
        boolean[][] dp = new boolean[n][n] ;
        dp[1][1] = true ; 
        int pos = -1 ; 
        for( int i=1 ; i<n ; ++i ){
            for( int j=1 ; j<=i ; ++j ){
                if( dp[i][j] ){
                    pos = getPosition( stones , n , stones[i] + j ) ; 
                    if( pos != -1 ){
                        dp[pos][j] = true ; 
                        if( pos+1<n && stones[pos+1] == stones[pos] + 1 ){
                            dp[pos+1][j+1] = true ; 
                        }
                    }else {
                        pos = getPosition( stones , n , stones[i] + j+1 ) ; 
                        if( pos != -1 ) dp[pos][j+1] = true ;  
                    }
                    pos = getPosition( stones, n , stones[i] + j-1 ) ; 
                    if( pos != -1 ) dp[pos][j-1] = true ; 
                }
            }
        }
        for( int i=1 ; i<n ; ++i ){
            if( dp[n-1][i] ) return true ;
        }
        return false ; 
    }
}
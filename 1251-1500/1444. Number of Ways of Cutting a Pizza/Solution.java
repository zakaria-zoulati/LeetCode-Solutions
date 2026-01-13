class Solution {
    int n , m , k ; 
    Integer[][][] memo ; 
    int[][] count ; 
    int mod ; 
    public int ways(String[] pizza, int k) {
        this.n = pizza.length ; 
        this.m = pizza[0].length(); 
        this.k = k ; 
        this.mod = 1_000_000_007 ; 
        this.memo = new Integer[n][m][k+1] ; 
        this.count = new int[n+1][m+1] ;
        for( int i=n-1 ; i>=0 ; --i ){
            for( int j=m-1 ; j>=0 ; --j ){
                count[i][j] = count[i+1][j] + count[i][j+1] - count[i+1][j+1] ; 
                if( pizza[i].charAt(j) == 'A' ) count[i][j]++ ; 
            }
        }
        return dfs( k , 0 , 0 ) ; 
    }
    public int dfs( int tar , int r , int c ){
        if( count[r][c] == 0 ) return memo[r][c][k] = 0 ; 
        if( tar == 1 ) return memo[r][c][1] = 1 ; 
        if( memo[r][c][tar] != null ) return memo[r][c][tar] ; 
        int rs = 0 ; 
        for( int i=r+1 ; i<n ; ++i ){
            if( count[r][c] - count[i][c] > 0 ){
                rs = ( rs + dfs( tar-1 , i , c ) ) % mod ; 
            }
        }
        for( int j=c+1 ; j<m ; ++j ){
            if( count[r][c] - count[r][j] > 0 ){
                rs = ( rs + dfs( tar-1, r , j ) ) % mod ; 
            }
        }
        return memo[r][c][tar] = rs  ; 
    }
}
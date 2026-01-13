class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length ;     
        int m = matrix[0].length ; 
        int[][] dp = new int[n][m] ; 
        int rs = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            dp[i][0] = matrix[i][0] - '0' ; 
        }
        for( int i=0 ; i<n ; ++i ){
            for( int j=1 ; j<m ; ++j ){
                dp[i][j] = (matrix[i][j] - '0') + dp[i][j-1] ; 
            }
        }
        for( int col = 0  ; col<m ; ++col ){
            for( int end = col ; end < m ; ++end ){
                int span = end - col+1 ; 
                for( int j=0 ; j<n ; ++j ){
                    if( dp[j][end] - ( col-1>=0 ? dp[j][col-1] : 0 ) >= span  ){
                        int curr = 1 ; 
                        while( j+1<n && dp[j+1][end] - ( col-1>=0 ? dp[j+1][col-1] : 0 )  >= span  ) {
                            curr++ ; 
                            j++ ; 
                        }
                        rs = Math.max( rs , curr*span ) ;
                    }
                }
            }
        }
        return rs ; 
    }
}